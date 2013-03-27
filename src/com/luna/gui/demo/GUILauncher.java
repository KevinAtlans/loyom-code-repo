package com.luna.gui.demo;

import java.awt.Color;
import java.io.IOException;

import com.luna.gui.demo.draw.DrawFromImage;

public class GUILauncher {

    public static void main(String[] args) throws IOException {

        DrawFromImage draw = new DrawFromImage("Characters painted", 1000, 900);
        Color[][] colors = draw.readImageFromLocal("/home/xukai/Desktop/h.jpg");
        draw.draw(colors);
    }
}
