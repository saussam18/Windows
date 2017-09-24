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
        winds.add(z, w);
    }

    public void drawWindows(Graphics g){
        for (int i = 0; i < winds.size(); i++){
            winds.get(i).drawWindow(g);
        }
    }
    private void resetZs(){
        for(int i = 0; i < winds.size(); i++){
            winds.get(i).setzOrder(i);
        }
    }

    private void bringToFront(Window w){
        for(int i = 0; i < winds.size(); i++){
            if(w.getzOrder() == winds.get(i).getzOrder()){
                winds.remove(winds.get(i));
                winds.add(w);
                resetZs();
            }
        }
    }
    public void findWindowByPositon(int x, int y){
        ArrayList<Window> windsAtPos = new ArrayList<Window>();

        for (int i = 0; i < winds.size() ; i++){
            int xCor = winds.get(i).getxCor();
            int yCor = winds.get(i).getyCor();
            int xCheck = findX(winds.get(i));
            int yCheck = findY(winds.get(i));
            if(x <= xCheck && x >= xCor && y <= yCheck && y >= yCor){
               windsAtPos.add(winds.get(i));
            }
        }
        if (windsAtPos.size() > 1){
            for(int i = 0; i < windsAtPos.size() - 1; i++){
                if (windsAtPos.get(i).compareTo(windsAtPos.get(i+1)) == 1){
                    bringToFront(windsAtPos.get(i));
                }
            }
        }else{
            bringToFront(windsAtPos.get(0));
        }
    }
    private int findX (Window w){
        return w.getxCor() + w.getxWidth();
    }
    private int findY (Window w){
        return w.getyCor() + w.getyHeight();
    }


}
