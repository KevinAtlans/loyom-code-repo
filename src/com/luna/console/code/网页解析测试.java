package com.luna.console.code;

import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

public class 网页解析测试 {

    public static final String regex = "^http://www.zhulang.com/\\d+/index.html$";

    public static final String regexNum = "\\d+";

    public static void main(String[] args) {

        try {
            URL uri = new URL("http://www.zhulang.com/");
            URLConnection connection = uri.openConnection();
            Parser parser = new Parser(connection);
            NodeFilter linkFilter = new NodeClassFilter(LinkTag.class);
            NodeList linkList = parser.extractAllNodesThatMatch(linkFilter);
            Pattern p = Pattern.compile(regex);
            Pattern pNum = Pattern.compile(regexNum);
            for (int i = 0; i < linkList.size(); i++) {
                LinkTag node = (LinkTag) linkList.elementAt(i);
                String url = node.getLink();
                message("init-url:" + url);
                if (p.matcher(url).find()) {
                    message("parser-url:" + url);
                    Matcher m = pNum.matcher(url);
                    while (m.find()) {
                        String s = m.group();
                        message(s);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void message(String str) {

        System.out.println(str);
    }
}
