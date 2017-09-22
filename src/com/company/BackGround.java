package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BackGround extends JPanel implements MouseListener {

    //myJpanel extents jpanel
    //implements mouse interface
    //uses paintComponet()
    //ask window manager to draw all windows
    //Constructor
    //set up mouse
    //create windowManager
    //add fake windows

    private JPanel panel1;
    private int xSize;
    private int ySize;

    public BackGround(int x, int y){
        panel1.addMouseListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(x, y));
        WindowManager w = new WindowManager();
        for (int i = 0; i < 10; i++){
            w.addWindow(x, y);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);
        g2d.drawOval(50, 50, 50, 50);

    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x+","+y);
    }
    public void mouseExited(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
}
