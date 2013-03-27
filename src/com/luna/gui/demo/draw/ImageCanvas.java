package com.luna.gui.demo.draw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ImageCanvas extends Canvas {

    private static final long serialVersionUID = 1L;

    private Color[][] colors;

    @Override
    public void paint(Graphics graphics) {

        if (colors != null) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int y = 10;
            int x = 10;

            for (Color[] tempColors : colors) {
                y = 10;
                for (Color color : tempColors) {
                    graphics2D.setColor(color);
                    graphics2D.drawRect(x, y, 1, 1);
                    y += 1;
                }
                x += 1;
            }
        }
    }

    @Override
    public void update(Graphics graphics) {

        paint(graphics);
    }

    public Color[][] getColors() {

        return colors;
    }

    public void setColors(Color[][] colors) {

        this.colors = colors;
    }
}
