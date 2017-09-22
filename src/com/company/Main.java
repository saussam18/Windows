package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //main
        //create jframe
        //set size
        JFrame f = new JFrame("BackGround");
        int xSize = 1950;
        int ySize = 1100;
        BackGround b = new BackGround(xSize, ySize);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(xSize, ySize);
        f.add(b);
        //create jpanel (Should be sub class)
        //add panel to frame
        //make jframe visble
        f.setVisible(true);




    }
}
