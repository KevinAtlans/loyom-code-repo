package com.luna.console.verificationcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

public class ImageHandle {

    public void load(String imageSrc) throws IOException {

        Color[][] colors = readImageFromLocal(imageSrc);

        List<Color> list = filterColors(colors);
        int width = colors.length, height = colors[0].length;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        bufferedImage = graphics2D.getDeviceConfiguration().createCompatibleImage(width, height,
                Transparency.TRANSLUCENT);
        graphics2D.dispose();
        graphics2D = bufferedImage.createGraphics();

        int x = 0, y = 0;
        for (Color[] c1 : colors) {
            y = 0;
            for (Color c2 : c1) {
                if (!list.contains(c2)) {
                    graphics2D.setPaint(c2);
                    graphics2D.drawRect(x, y, 1, 1);
                }
                y += 1;
            }
            x += 1;
        }
        ImageIO.write(bufferedImage, "png", new File("/home/xukai/Desktop/img/genimg.png"));
    }

    private List<Color> filterColors(Color[][] colors) {

        Map<Color, Integer> colorCount = com.google.common.collect.Maps.newHashMap();

        for (Color[] c1 : colors) {
            for (Color c2 : c1) {
                Integer count = colorCount.get(c2);
                if (count == null) {
                    count = 1;
                } else {
                    count += 1;
                }
                colorCount.put(c2, count);
            }
        }
        List<Color> list = com.google.common.collect.Lists.newArrayList();
        int maxCount = 0;
        Color c = null;
        for (Entry<Color, Integer> entry : colorCount.entrySet()) {
            Color tempColor = entry.getKey();
            Integer count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                c = tempColor;
            }
            if (count < 40) {
                list.add(tempColor);
            }
        }
        list.add(c);

        for (Entry<Color, Integer> entry : colorCount.entrySet()) {
            Color tempColor = entry.getKey();
            Integer count = entry.getValue();

            if (!list.contains(tempColor)) {
                System.out.println("Color:" + tempColor.toString() + "\t Count:" + count);
            }
        }
        return list;
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

}
