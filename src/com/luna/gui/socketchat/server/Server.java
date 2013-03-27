package com.luna.gui.socketchat.server;
import java.net.*;   
import java.io.*;   
import java.awt.*;   
import java.awt.event.*;   
import java.util.*;   
public class Server{   
       
    private Frame f;   
    private TextArea ta;   
    private ServerSocket server;   
    private Hashtable ht;   
       
    public Server(){   
        f = new Frame("服务器端");   
        f.addWindowListener(new WindowAdapter(){   
                public void windowClosing(WindowEvent e){   
                    System.exit(0);   
                }   
            });   
        ta = new TextArea("用户状态\t用户名\t\tIP\t\t时间\n");   
        ta.setEditable(false);   
        ta.setBackground(Color.white);   
        f.add(ta);   
        f.setSize(400,500);   
        f.setLocation(5,5);   
        f.setVisible(true);   
        try{   
            server = new ServerSocket(8899);   
        }catch(Exception e){   
            System.out.println("此端口已被占有，请选用别的端口号！");   
            ta.setText("此端口已被占有，请选用别的端口号！");   
            try{   
                Thread.sleep(1000);   
            }catch(Exception te){   
                te.printStackTrace();   
            }   
            System.exit(0);   
        }   
    }   
       
    public void listening(){   
        ht = new Hashtable();   
        Socket socket;   
        ObjectInputStream ois;   
        ObjectOutputStream oos;   
        //用户名   
        String from;   
        User u;   
        try{   
            while(true){   
                socket = server.accept();   
                ois = new ObjectInputStream(socket.getInputStream());   
                from = (String)ois.readObject();   
                oos = new ObjectOutputStream(socket.getOutputStream());   
                if(from.equals(null) || from.equals("") || from.equals("all") || from.equals("server")){   
                    oos.writeObject(new Message("server",from,"命名有误请重新登录",Timers.getTime()));   
                    socket.close();   
                }else if(ht.containsKey(from)){   
                    oos.writeObject(new Message("server",from,"已有该用户请换一个用户名！",Timers.getTime()));   
                    socket.close();   
                }else{   
                        u = new User(from,ois,oos);   
                        ta.append("〓上线〓\t"+from+"\t\t"+socket.getInetAddress()+"\t"+Timers.getTime()+"\n");   
                        ht.put(from,u);   
                        //通知所有用户有新用户上线了！   
                            Collection c = ht.values();   
                            Iterator it = c.iterator();   
                            while(it.hasNext()){   
                                User uu = (User)it.next();   
                                ObjectOutputStream oos1 = uu.getOos();   
                                oos1.writeObject(new Message("server","all",from + "上线啦！",Timers.getTime()));                      
                            }   
                        //   
                        ServerRunner r = new ServerRunner(ht,ois,oos,ta);   
                        Thread t = new Thread(r);   
                        t.start();   
                    }   
                }   
        }catch(Exception e){   
            e.printStackTrace();   
        }   
    }   
       
    public static void main(String args[]){   
        Server s = new Server();   
        s.listening();   
    }   
       
}   
class ServerRunner implements Runnable{   
    private Hashtable ht;   
    private ObjectInputStream ois;   
    private ObjectOutputStream oos;   
    private TextArea ta;   
    public ServerRunner(Hashtable ht,ObjectInputStream ois,ObjectOutputStream oos,TextArea ta){   
        this.ht = ht;   
        this.ois = ois;   
        this.oos = oos;   
        this.ta = ta;   
    }   
    public void run(){   
        User u;   
        Message m=null;   
        try{   
            while(true){   
                m = (Message)ois.readObject();   
                System.out.println(m.getFrom()+"\t"+m.getTo()+"\t"+m.getContent()+"\t"+m.getTime());   
                String to = m.getTo();   
                String from = m.getFrom();   
                if(to.equals("all")){   
                    //判断是否下线的隐藏量   
                    String pws = m.getPws();   
                    Collection c = ht.values();   
                    Iterator it = c.iterator();   
                    if(pws.equals("end")){   
                            m.setFrom("server");   
                        }   
                    while(it.hasNext()){   
                        User uu = (User)it.next();   
                        ObjectOutputStream oos1 = uu.getOos();   
                        oos1.writeObject(m);                       
                    }   
                    if(pws.equals("end")){   
                        ht.remove(from);   
                        ta.append("→下线←\t"+from+"\t\t"+"......\t\t"+Timers.getTime()+"\n");   
                    }   
                }else{   
                    u = (User)ht.get(to);   
                    if(u!=null){   
                        u.getOos().writeObject(m);   
                    }else{   
                        u = (User)ht.get(from);   
                        u.getOos().writeObject(new Message("server",from,"没有 "+to+" 该用户",Timers.getTime()));   
                    }   
                }   
                Thread.sleep(300);   
            }              
        }catch(SocketException se){   
            System.out.println("有用户下线！");   
        }catch(Exception e){   
            e.printStackTrace();   
        }   
    }   
}  