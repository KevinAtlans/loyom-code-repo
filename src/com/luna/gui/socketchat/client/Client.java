package com.luna.gui.socketchat.client;
import java.awt.*;   
import java.awt.event.*;   
import java.net.*;   
import java.io.*;   
import javax.swing.*;   
public class Client implements ActionListener{   
    private Socket socket;   
    private ObjectOutputStream oos;   
    private ObjectInputStream ois;   
    private Frame f;   
    private TextArea ta;   
    private TextField tf,tf1;   
    private Label lab;   
    private Button but;   
    //用户名   
    private String from;   
    public Client(){   
        f = new Frame("客户端");   
        ta = new TextArea();   
        ta.setEditable(false);   
        ta.setBackground(Color.white);   
        Panel p = new Panel();   
        p.setLayout(new BorderLayout());   
        Panel p1 = new Panel();   
        p1.setLayout(new BorderLayout());   
        Panel p2 = new Panel();   
        p2.setLayout(new BorderLayout());   
        lab = new Label("对方姓名:");   
        tf1 = new TextField(8);   
        p1.add(lab,BorderLayout.WEST);   
        p1.add(tf1,BorderLayout.CENTER);   
        tf = new TextField();   
        tf.addActionListener(this);   
        but = new Button("Send");   
        but.addActionListener(this);   
        p2.add(tf,BorderLayout.CENTER);   
        p2.add(but,BorderLayout.EAST);   
        p.add(p1,BorderLayout.WEST);   
        p.add(p2,BorderLayout.CENTER);   
        f.add(ta,BorderLayout.CENTER);   
        f.add(p,BorderLayout.SOUTH);   
        f.setSize(400,300);   
        f.setLocation(350,100);   
        f.setVisible(true);   
        from = JOptionPane.showInputDialog("请输入你的用户名");   
        if(from==null){   
            from="";   
        }   
        f.setTitle(from);   
    }   
    public static void main(String args[]){   
        Client c = new Client();   
        c.connection();   
        c.closing();   
    }   
    public void actionPerformed(ActionEvent e){   
        String to = tf1.getText();   
        String content = tf.getText();   
        Message m = new Message(from,to,content,Timers.getTime());   
        try{   
            oos.writeObject(m);   
            ta.append(m.getTime()+"  "+m.getFrom()+ " 对 " +m.getTo()+"  说:  "+m.getContent()+"\n");   
            tf.setText("");   
            tf.requestFocus();   
        }catch(Exception e1){   
            e1.printStackTrace();   
        }   
    }   
    public void connection(){   
        try{   
            socket = new Socket("127.0.0.1",8899);   
            oos = new ObjectOutputStream(socket.getOutputStream());   
            oos.writeObject(from);   
            ois = new ObjectInputStream(socket.getInputStream());   
            ClientRunner cr = new ClientRunner(ta,tf1,oos,ois);   
            Thread t = new Thread(cr);   
            t.start();   
        }catch(Exception e){   
            ta.append("对不起服务器,请稍后再登录！");   
            System.out.println("对不起服务器");   
            try{   
                Thread.sleep(1000);   
            }catch(InterruptedException eee){   
                eee.printStackTrace();   
            }   
            System.exit(0);   
        }   
    }   
    public void closing(){   
        f.addWindowListener(new WindowAdapter(){   
                public void windowClosing(WindowEvent e){   
                    try{   
                        oos.writeObject(new Message(from,"all",from+" 下线啦！",Timers.getTime(),"end"));   
                    }catch(Exception e1){   
                        e1.printStackTrace();   
                        System.exit(0);   
                    }   
                    System.exit(0);   
                }   
        });   
    }   
}   
class ClientRunner implements Runnable{   
    private ObjectInputStream ois;   
    private ObjectOutputStream oos;   
    private TextArea ta;   
    private TextField tf1;   
    public ClientRunner(TextArea ta,TextField tf1,ObjectOutputStream oos,ObjectInputStream ois){   
        this.ta = ta;   
        this.tf1 = tf1;   
        this.oos = oos;   
        this.ois = ois;   
    }   
    public void run(){   
        Message m;   
        try{   
            while(true){   
                m = (Message)ois.readObject();   
                ta.append(m.getTime()+"  "+m.getFrom()+ " 对 " +m.getTo()+"  说:  "+m.getContent()+"\n");   
            }   
        }catch(Exception e){   
            System.out.println("与服务器已断开！");   
            try{   
                Thread.sleep(1000);   
            }catch(Exception te){   
                te.printStackTrace();   
            }   
            System.exit(0);   
        }   
           
    }   
}