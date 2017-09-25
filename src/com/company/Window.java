package com.company;

import java.awt.*;
import java.util.Random;

public class Window implements Comparable<Window> {
    //Window class
    //Stores info for fake window
    //Constructor
    //set window with random data within boundries
    //implements comparable
    //getters and setters
    private int xWidth;
    private int yHeight;
    public int xCor;
    public int yCor;
    private int zOrder;
    private int color1;
    private int color2;
    private int color3;

    public Window(int x, int y, int xcor, int ycor, int z){
        Random ran = new Random();
        xWidth = x;
        yHeight = y;
        xCor = xcor;
        yCor = ycor;
        zOrder = z;
        color1 = ran.nextInt(255);
        color2 = ran.nextInt(255);
        color3 = ran.nextInt(255);
    }

    @Override
    public int compareTo(Window o) {
        if (zOrder > o.getzOrder()){
            return 1;
        } else if (zOrder < o.getzOrder()){
            return -1;
        } else {
            return 0;
        }
    }

    public void drawWindow (Graphics g){
        Color c = new Color (color1, color2, color3);
        g.setColor(c);
        g.drawRect(xCor, yCor, xWidth, yHeight);
        g.fillRect(xCor, yCor, xWidth, yHeight);
    }

    public int getxWidth() {
        return xWidth;
    }

    public int getyHeight() {
        return yHeight;
    }
    public int getxCor() {
        return xCor;
    }

    public int getyCor() {
        return yCor;
    }

    public int getzOrder() {
        return zOrder;
    }

    public void setxWidth(int xWidth) {
        this.xWidth = xWidth;
    }

    public void setyHeight(int yWidth) {
        this.yHeight = yWidth;
    }

    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    public void setzOrder(int zOrder) {
        this.zOrder = zOrder;
    }
}
