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
    private WindowManager w = new WindowManager();
    private int xSize;
    private int ySize;

    public BackGround(int x, int y){
        panel1.addMouseListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(x, y));
        for (int i = 0; i < 10; i++){
            w.addWindow(x, y, i);
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        w.drawWindows(g);
    }


    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        w.findWindowByPositon(x, y);
        System.out.println(x+","+y);
        repaint();
        revalidate();
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
