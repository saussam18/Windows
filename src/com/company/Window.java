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
    private int xCor;
    private int yCor;
    private int zOrder;

    public Window(int x, int y, int xcor, int ycor, int z){
        xWidth = x;
        yHeight = y;
        xCor = xcor;
        yCor = ycor;
        zOrder = z;
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
        Random ran = new Random();
        Color temp = new Color (ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
        g.setColor(temp);
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
