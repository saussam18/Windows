package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
public class BackGround extends JPanel implements MouseListener, MouseInputListener {
    //myJpanel extents jpanel
    //implements mouse interface
    //uses paintComponet()
    //ask window manager to draw all windows
    //Constructor
    //set up mouse
    //create windowManager
    //add fake windows
    private WindowManager w = new WindowManager();
    private int xDis;//struggled with drag so got some help from Connor, realized i needed this
    private int yDis;

    public BackGround(int x, int y){
        addMouseListener(this);
        addMouseMotionListener(this);
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
    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        Window wind = w.findWindowByPositon(x, y);
        System.out.println(x+","+y);
        xDis = x - wind.getxCor();
        yDis = y - wind.getyCor();
        w.bringToFront(wind);
        repaint();
    }
    @Override
    public void mouseDragged(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        w.moveWindowPos(x, y, xDis, yDis);
        repaint();
    }

    //rest of these methods are not used
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }
}
