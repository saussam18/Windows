package com.company;

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
        int xCor = xcor;
        int yCor = xcor;
        zOrder = z;
    }

    @Override
    public int compareTo(Window o) {
        return 0;
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
