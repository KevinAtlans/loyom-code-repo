package com.luna.console.video;

import com.luna.console.video.extract.Video;
import com.luna.console.video.extract.VideoUtils;

public class Launcher {

    public static void main(String[] args) throws Exception {

        // String url = "http://v.youku.com/v_show/id_XMzQxMzkzNjU2.html";
        // String url = "http://www.tudou.com/programs/view/Zkazx5iaUSQ/";
        // String url
        // =http://www.youtube.com/watch?v=78qEBIKXJqQ&feature=youtu.be
        // "http://v.ku6.com/special/show_4024167/Dwq_4xKT5Go4f4F6.html";
        // String url = "http://v.ku6.com/show/bFx2VCEiF15U53E6.html";
        // String url = "http://6.cn/watch/14757577.html";
        // String url = "http://www.56.com/u37/v_NjE3OTQ4NTg.html";
        // String url =
        // "http://video.sina.com.cn/p/news/s/v/2011-09-11/133861482545.html";
        String url = "http://tv.sohu.com/20110912/n319076906.shtml";
        // String url =
        // "http://v.ifeng.com/documentary/discovery/201109/ed52d159-a3f4-4969-972d-c9e6d51d00ff.shtml";
        // String url = "http://www.yinyuetai.com/video/271439";
        // String url = "http://www.baidu.com/";

        if (url.indexOf("v.youku.com") != -1) {
            System.out.print("asaaaaaaaaaa");
        }
        Video video = VideoUtils.getYouKuVideo(url);

        System.out.println("视频标题：" + video.getTitle());
        System.out.println("视频地址：" + video.getFlashUrl());
        System.out.println("视频时长：" + video.getTime());
        System.out.println("视频来源：" + video.getSource());
        System.out.println("视频简介：" + video.getSummary());
        System.out.println("视频缩略图：" + video.getThumbnail());
        System.out.println("视频原始地址：" + video.getPageUrl());
        System.out.println("视频网页代码：" + video.getHtmlCode());
    }
    //
    // public static Video getYouKuVideo(String url) throws Exception {
    //
    // Document doc = getURLContent(url);
    // String title = doc.title().split("-")[0].trim();
    // String pic = getElementAttrById(doc, "s_sina", "href");
    // int local = pic.indexOf("pic=");
    // pic = pic.substring(local + 4);
    // String flash = getElementAttrById(doc, "link2", "value");
    //
    // String htmlCode = getElementAttrById(doc, "link3", "value");
    // String time = getElementAttrById(doc, "download", "_href");
    // String[] arrays = time.split("\\|");
    // time = arrays[4];
    //
    // Element el = doc.getElementById("long");
    // String summary = el.select(".item").get(0).html();
    //
    // Video video = new Video();
    // video.setTitle(title);
    // video.setThumbnail(pic);
    // video.setFlashUrl(flash);
    // video.setTime(time);
    // video.setSource("优酷视频");
    // video.setPageUrl(url);
    // video.setSummary(summary);
    // video.setHtmlCode(htmlCode);
    //
    // return video;
    // }
    //
    // private static Document getURLContent(String url) throws Exception {
    //
    // Document doc = Jsoup.connect(url).data("query",
    // "Java").userAgent("Mozilla")
    // .cookie("auth", "token").timeout(5000).get();
    // return doc;
    // }
}
