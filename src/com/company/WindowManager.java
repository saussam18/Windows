package com.company;

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


    private ArrayList<Window> windows = new ArrayList<Window>();

    public WindowManager(){


    }
    public void addWindow(int x, int y){
        Random ran = new Random();
        int wX = ran.nextInt(x - 200) + 100;
        int wY = ran.nextInt(y - 200) + 100;
        Window w = new Window(wX, wY);
    }

    public void drawWindows(){

    }
}
