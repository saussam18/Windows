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
    private int xCheck;
    private int yCheck;

    public WindowManager(){
    }
    public void addWindow(int x, int y, int z){
        Random ran = new Random();
        int wX = ran.nextInt(x - 500) + 75;//still not totally happy with the randoms but it works
        int wY = ran.nextInt(y - 500) + 75;
        int xCor = ran.nextInt(x);
        int yCor = ran.nextInt(y);
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
    public void bringToFront(Window w){
        for(int i = 0; i < winds.size(); i++){
            if(w.getzOrder() == winds.get(i).getzOrder()){
                winds.remove(winds.get(i));
                winds.add(w);
                resetZs();
            }
        }
    }
    public Window findWindowByPositon(int x, int y){
        ArrayList<Window> windsAtPos = new ArrayList<Window>();
        Window w = winds.get(winds.size()-1);
        for (int i = 0; i < winds.size() ; i++){
            int xCor = winds.get(i).getxCor();
            int yCor = winds.get(i).getyCor();
            xCheck = findX(winds.get(i));
            yCheck = findY(winds.get(i));
            if(x <= xCheck && x >= xCor && y <= yCheck && y >= yCor){
               windsAtPos.add(winds.get(i));
            }
        }
        if (windsAtPos.size() > 1){ //had trouble with this so got some help from others
            for(int i = 0; i < windsAtPos.size() - 1; i++){
                    if (windsAtPos.get(i).compareTo(windsAtPos.get(i+1)) == 1){
                     w = windsAtPos.get(i);
                    }else if (windsAtPos.get(i).compareTo(windsAtPos.get(i+1)) == 0){
                        w = windsAtPos.get(0);
                    }else {
                        w = windsAtPos.get(windsAtPos.size()-1);
                    }
            }
        }else if (windsAtPos.size() == 1){
            w = windsAtPos.get(0);
        }
        return w;
    }
    public void moveWindowPos(int x, int y, int xDis, int yDis){
            int changeX = x - xDis;
            int changeY = y - yDis;
       // if(x <= xCheck && x >= winds.get(winds.size() - 1).getxCor() && y <= yCheck && y >= winds.get(winds.size() - 1).getyCor()){ //Works but makes really laggy so i just commented it out, not enough time to fix
            winds.get(winds.size() - 1).setxCor(changeX);
            winds.get(winds.size() - 1).setyCor(changeY);
      //  }

    }
    private int findX (Window w){
        return w.getxCor() + w.getxWidth();
    }
    private int findY (Window w){
        return w.getyCor() + w.getyHeight();
    }
}
