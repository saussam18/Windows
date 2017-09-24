package com.company;

import sun.plugin2.os.windows.Windows;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class WindowManager {


    //WindowManager Class
    //store windows objects
    //constructor
    //support add method
    //support drawWindows to draw on panel
    //support bringToFront
    //support findWindow
    //getWindows method to return an Array list of Windows


    private ArrayList<Window> winds = new ArrayList<Window>();

    public WindowManager(){


    }
    public void addWindow(int x, int y, int z){
        Random ran = new Random();
        int wX = ran.nextInt(x - 300) + 100;
        int wY = ran.nextInt(y - 300) + 100;
        int xCor = ran.nextInt(x - 50);
        int yCor = ran.nextInt(y - 50);
        Window w = new Window(wX, wY, xCor, yCor, z);
        winds.add(w);
    }

    public void drawWindows(Graphics g){
        for (int i = 0; i < winds.size(); i++){
            winds.get(i).drawWindow(g);
        }
    }

    public void bringToFront(int i){
        Window temp;
        temp = winds.get(i);
        winds.remove(winds.get(i));
        winds.add(temp);
    }
    public void findWindowByPositon(int x, int y){
        for (int i = 0; i < winds.size() ; i++){
            int xCor = winds.get(i).getxCor();
            int yCor = winds.get(i).getyCor();
            int xCheck = findX(winds.get(i));
            int yCheck = findY(winds.get(i));
            if(x <= xCheck && x >= xCor && y <= yCheck && y >= yCor){
               bringToFront(i);
            }
        }
    }
    private int findX (Window w){
        return w.getxCor() + w.getxWidth();
    }
    private int findY (Window w){
        return w.getyCor() + w.getyHeight();
    }


}
