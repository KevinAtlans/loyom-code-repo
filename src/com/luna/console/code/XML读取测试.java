package com.luna.console.code;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML读取测试 {

    public static void main(String args[]) {

        File f = new File("src/Myxml.xml");
        Dom(f);
    }

    public static void Dom(File f) {

        // Document可以看作是XML在内存中的一个镜像,那么一旦获取这个Document 就意味
        // 可以通过对内存的操作来实现对XML的操作
        // 首先第一步获取XML相关的Document
        try {
            // 很明显该类是一个单例,先获取产生DocumentBuilder工厂
            // 的工厂,再通过这个工厂产生一个DocumentBuilder,
            // DocumentBuilder就是用来产生Document的
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            // 根节点获得方法
            // Element root=doc.getDocumentElement();
            // System.out.println("根节点是"+root.getTagName());
            NodeList nl = doc.getElementsByTagName("VALUE");
            // 父节点获得方法
            // Node fatherNode=nl.item(0);
            // System.out.println("父节点是"+fatherNode.getNodeName());
            // NamedNodeMap attributes=fatherNode.getAttributes();
            // 遍历XML
            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println("车牌号是"
                        + doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
                System.out.println("车主地址是"
                        + doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
