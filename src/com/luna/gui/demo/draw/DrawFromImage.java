package com.luna.gui.demo.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class DrawFromImage {

    private final ImageCanvas imageCvs;

    private final JFrame frame;

    public DrawFromImage(String title, int width, int height) {

        frame = new JFrame(title);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocation(200, 100);
        frame.setSize(width, height);

        imageCvs = new ImageCanvas();
        imageCvs.setBackground(Color.white);

        Container conPane = frame.getContentPane();
        conPane.setLayout(new BorderLayout());
        conPane.setBackground(Color.white);
        conPane.add(imageCvs);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public void draw(Color[][] colors) {

        if (colors != null) {
            imageCvs.setColors(colors);
            imageCvs.repaint();
        }
    }

    public Color[][] readImageFromUrl(String imageUrl) throws IOException {

        InputStream imageFile = getImageStream(imageUrl);
        if (imageFile != null) {

            // 读取图片
            BufferedImage readImageBuffer = ImageIO.read(imageFile);

            // 图片转字符串后的数组
            Color[][] imageGreyLevel = new Color[readImageBuffer.getWidth()][readImageBuffer
                    .getHeight()];

            for (int x = 0; x < readImageBuffer.getWidth(); x++) {
                for (int y = 0; y < readImageBuffer.getHeight(); y++) {
                    int rgb = readImageBuffer.getRGB(x, y);
                    Color color = new Color(rgb);
                    imageGreyLevel[x][y] = color;
                }
            }
            return imageGreyLevel;
        }
        return null;
    }

    public Color[][] readImageFromLocal(String imageSrc) throws IOException {

        File imageFile = new File(imageSrc);
        if (imageFile.exists()) {
            // 读取图片
            BufferedImage readImageBuffer = ImageIO.read(imageFile);

            // 图片转字符串后的数组
            Color[][] imageGreyLevel = new Color[readImageBuffer.getWidth()][readImageBuffer
                    .getHeight()];

            for (int x = 0; x < readImageBuffer.getWidth(); x++) {
                for (int y = 0; y < readImageBuffer.getHeight(); y++) {
                    int rgb = readImageBuffer.getRGB(x, y);
                    Color color = new Color(rgb);
                    imageGreyLevel[x][y] = color;
                }
            }
            return imageGreyLevel;
        }
        return null;
    }

    private InputStream getImageStream(String imageUrl) throws IOException {

        URL url = new URL(imageUrl);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;

        int HttpResult = httpConnection.getResponseCode();
        if (HttpResult != HttpURLConnection.HTTP_OK)
            return null;
        else {
            InputStream inStream = urlConnection.getInputStream();

            return inStream;
        }
    }

}
