package com.luna.gui.canvas;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawBoardDemo implements ActionListener, MouseListener, MouseMotionListener,
        ItemListener {

    JFrame f;

    MyCanvas cans;

    JButton bt[];

    JLabel lb = new JLabel("颜色设定:", JLabel.RIGHT);

    JLabel la = new JLabel();

    JLabel le = new JLabel();

    JComboBox cb[] = new JComboBox[2];

    String color[] = { "红色", "黄色", "绿色", "蓝色", "黑色", "白色" };

    String size[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    Point dots[] = new Point[1000];

    int dot = 0;

    int ys = 0;

    int dx = 1;

    int flag = 0;

    int startx, starty, endx, endy, height, width;

    public DrawBoardDemo() {

        f = new JFrame("简单画图工具");
        f.setSize(800, 600);
        Container con = f.getContentPane();
        con.setLayout(new BorderLayout());
        JPanel jp1 = new JPanel(new GridLayout(1, 9, 10, 10));
        bt = new JButton[4];
        bt[0] = new JButton("画直线");
        jp1.add(bt[0]);
        bt[0].addActionListener(this);
        bt[1] = new JButton("画曲线");
        jp1.add(bt[1]);
        bt[1].addActionListener(this);
        bt[2] = new JButton("画矩形");
        jp1.add(bt[2]);
        bt[2].addActionListener(this);
        bt[3] = new JButton("画椭圆");
        jp1.add(bt[3]);
        bt[3].addActionListener(this);
        con.add(jp1, "North");
        jp1.add(lb);
        cb[0] = new JComboBox();
        cb[1] = new JComboBox();
        for (int i = 0; i < 6; i++)
            cb[0].addItem(color[i]);
        for (int i = 0; i < 9; i++)
            cb[1].addItem(size[i]);
        cb[0].setBackground(Color.white);
        cb[0].addItemListener(this);
        jp1.add(cb[0]);
        cb[1].setBackground(Color.white);
        cb[1].addItemListener(this);
        jp1.add(cb[1]);
        jp1.add(la);
        jp1.add(le);
        cans = new MyCanvas();
        cans.setBackground(Color.white);
        cans.addMouseListener(this);
        cans.addMouseMotionListener(this);
        con.add(cans);
        f.setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (flag == 1)
            dot = 0;
        else {
            endx = e.getX();
            endy = e.getY();
            if (flag != 0) {
                if ((endx - startx) >= 0) {
                    width = endx - startx;
                    if ((endy - starty) >= 0)
                        height = endy - starty;
                    else {
                        height = starty - endy;
                        starty = endy;
                    }
                } else {
                    width = startx - endx;
                    if ((endy - starty) >= 0) {
                        height = endy - starty;
                        startx = endx;
                    } else {
                        height = starty - endy;
                        startx = endx;
                        starty = endy;
                    }
                }
            }
            cans.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton bu = (JButton) e.getSource();
        {
            for (int i = 0; i < 4; i++)
                if (bu == bt[i])
                    flag = i;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (flag == 1) {
            dots[dot] = new Point(e.getX(), e.getY());
            dot++;
            cans.repaint();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == cb[0]) {
            String str = (String) e.getItem();
            for (int j = 0; j < 6; j++)
                if (str == color[j])
                    ys = cb[0].getSelectedIndex();
        }
        if (e.getSource() == cb[1]) {
            int i = 0;
            String str = (String) e.getItem();
            for (int j = 0; j < 9; j++)
                if (str == size[j])
                    i = cb[1].getSelectedIndex();
            dx = i;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (flag != 1)
            startx = e.getX();
        starty = e.getY();
    }

    class MyCanvas extends Canvas {

        private static final long serialVersionUID = 1L;

        @Override
        public void paint(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            switch (ys) {
            case 0:
                g2.setPaint(Color.red);
                break;
            case 1:
                g2.setPaint(Color.yellow);
                break;
            case 2:
                g2.setPaint(Color.green);
                break;
            case 3:
                g2.setPaint(Color.blue);
                break;
            case 4:
                g2.setPaint(Color.black);
                break;
            case 5:
                g2.setPaint(Color.white);
                break;
            }
            switch (dx) {
            case 1:
                g2.setStroke(new BasicStroke(3));
                break;
            case 2:
                g2.setStroke(new BasicStroke(5));
                break;
            case 3:
                g2.setStroke(new BasicStroke(7));
                break;
            case 4:
                g2.setStroke(new BasicStroke(9));
                break;
            case 5:
                g2.setStroke(new BasicStroke(11));
                break;
            case 6:
                g2.setStroke(new BasicStroke(13));
                break;
            case 7:
                g2.setStroke(new BasicStroke(15));
                break;
            case 8:
                g2.setStroke(new BasicStroke(17));
                break;
            case 9:
                g2.setStroke(new BasicStroke(19));
                break;
            }
            if (flag == 0)
                g2.draw(new Line2D.Double(startx, starty, endx, endy));
            if (flag == 1)
                for (int i = 0; i < dot - 1; i++)
                    g2.draw(new Line2D.Double(dots[i], dots[i + 1]));
            if (flag == 2)
                g2.draw(new Rectangle2D.Double(startx, starty, width, height));
            if (flag == 3)
                g2.draw(new Ellipse2D.Double(startx, starty, width, height));
        }

        @Override
        public void update(Graphics g) {

            paint(g);
        }
    }
}
