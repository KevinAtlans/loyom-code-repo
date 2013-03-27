package com.luna.console.video.extract;

import org.osm.jsoup.Jsoup;
import org.osm.jsoup.nodes.Document;
import org.osm.jsoup.nodes.Element;
import org.osm.jsoup.select.Elements;

public class VideoUtils {

    public static Video getVideoInfo(String url) {

        Video video = null;

        if (url.indexOf("v.youku.com") != -1)
            try {
                video = getYouKuVideo(url);
            } catch (Exception e) {
                video = null;
            }
        else if (url.indexOf("www.tudou.com") != -1)
            try {
                video = getTudouVideo(url);
            } catch (Exception e) {
                video = null;
            }
        else if (url.indexOf("v.ku6.com") != -1)
            try {
                video = getKu6Video(url);
            } catch (Exception e) {
                video = null;
            }
        else if (url.indexOf("6.cn") != -1)
            try {
                video = get6Video(url);
            } catch (Exception e) {
                video = null;
            }
        else if (url.indexOf("www.56.com") != -1)
            try {
                video = get56Video(url);
            } catch (Exception e) {
                video = null;
            }
        else if (url.indexOf("video.sina.com.cn") != -1)
            try {
                video = getSinaVideo(url);
            } catch (Exception e) {
                video = null;
            }
        else if (url.indexOf("tv.sohu.com") != -1) {
            try {
                video = getSohuVideo(url);
            } catch (Exception e) {
                video = null;
            }
        }

        return video;
    }

    public static Video getYouKuVideo(String url) throws Exception {

        Document doc = getURLContent(url);

        String title = doc.title().split("-")[0].trim();

        String pic = getElementAttrById(doc, "s_sina", "href");
        int local = pic.indexOf("pic=");
        pic = pic.substring(local + 4);

        String flash = getElementAttrById(doc, "link2", "value");

        String htmlCode = getElementAttrById(doc, "link3", "value");

        // String time = getElementAttrById(doc, "download", "_href");
        // String[] arrays = time.split("\\|");
        String time = "as";

        Element el = doc.getElementById("long");
        String summary = el.select(".item").get(0).html();

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(pic);
        video.setFlashUrl(flash);
        video.setTime(time);
        video.setSource("优酷视频");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(htmlCode);

        return video;
    }

    public static Video getTudouVideo(String url) throws Exception {

        Document doc = getURLContent(url);
        String content = doc.html();
        int beginLocal = content.indexOf("<script>document.domain");
        int endLocal = content.indexOf("</script>");
        content = content.substring(beginLocal, endLocal);

        String title = doc.title().split("_")[0].trim();

        String flash = getScriptVarByName("iid_code", content);
        flash = "http://www.tudou.com/v/" + flash.split("=")[1].trim() + "/v.swf";

        String pic = getScriptVarByName("thumbnail", content);
        pic = pic.split("=")[1].trim();

        String summary = doc.select("meta[name=Description]").attr("content");

        String time = getScriptVarByName("time", content);

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(pic);
        video.setFlashUrl(flash);
        video.setTime(time);
        video.setSource("土豆视频");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(getHtmlCode(flash));

        return video;
    }

    public static Video getKu6Video(String url) throws Exception {

        Document doc = getURLContent(url);

        String title = doc.title().split(" ")[0].trim();

        String flash = getElementAttrById(doc, "outSideSwfCode", "value");

        String htmlCode = getElementAttrById(doc, "outSideHtmlCode", "value");

        Element picEt = doc.getElementById("plVideosList");
        String time = null;
        String pic = null;
        if (picEt != null) {
            Elements pics = picEt.getElementsByTag("img");
            pic = pics.get(0).attr("src");

            Element timeEt = picEt.select("span.review>cite").first();
            time = timeEt.text();
        } else {
            pic = doc.getElementsByClass("s_pic").first().text();
        }

        String summary = doc.select("meta[name=Description]").attr("content");

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(pic);
        video.setFlashUrl(flash);
        video.setTime(time);
        video.setSource("酷6视频");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(htmlCode);
        return video;
    }

    public static Video get6Video(String url) throws Exception {

        Document doc = getURLContent(url);

        String title = doc.title().split("-")[0].trim();

        Element picEt = doc.getElementsByClass("summary").first();
        String pic = picEt.getElementsByTag("img").first().attr("src");

        String summary = doc.select("meta[name=Description]").attr("content");

        Element flashEt = doc.getElementById("video-share-code");
        doc = Jsoup.parse(flashEt.attr("value"));
        String flash = doc.select("embed").attr("src");

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(pic);
        video.setFlashUrl(flash);
        video.setSource("6间房");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(getHtmlCode(flash));

        return video;
    }

    public static Video get56Video(String url) throws Exception {

        Document doc = getURLContent(url);
        String content = doc.html();

        String title = doc.getElementById("VideoTitle").select("h1").text();

        int begin = content.indexOf("\"img\":\"");
        content = content.substring(begin + 7, begin + 200);
        int end = content.indexOf("\"};");
        String pic = content.substring(0, end).trim();
        pic = pic.replaceAll("\\\\", "");

        String flash = "http://player.56.com"
                + url.substring(url.lastIndexOf("/"), url.lastIndexOf(".html")) + ".swf";

        String summary = doc.select("meta[name=Description]").attr("content");

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(pic);
        video.setFlashUrl(flash);
        video.setSource("56视频");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(getHtmlCode(flash));
        return video;
    }

    public static Video getSinaVideo(String url) throws Exception {

        Document doc = getURLContent(url);

        String title = doc.getElementById("videoTitle").text();

        String summary = doc.getElementById("videoContent").text();

        String content = doc.html();
        int beginLocal = content.indexOf("document.domain");
        int endLocal = content.indexOf("</script>");
        content = content.substring(beginLocal + 2, endLocal);

        String pic = getScriptVarByName("pic", content);

        String flash = getScriptVarByName("swfOutsideUrl", content);

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(pic);
        video.setFlashUrl(flash);
        video.setSource("新浪视频");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(getHtmlCode(flash));
        return video;
    }

    public static Video getSohuVideo(String url) throws Exception {

        Document doc = getURLContent(url);

        String title = doc.title().split("-")[0].trim();

        String summary = doc.select(".vIntro.clear > p").text();

        String thumbnail = doc.getElementById("thumbnail").attr("src");

        String videoId = thumbnail.split("_")[2];

        String flash = "http://share.vrs.sohu.com/" + videoId + "/v.swf&autoplay=false";

        Video video = new Video();
        video.setTitle(title);
        video.setThumbnail(thumbnail);
        video.setFlashUrl(flash);
        video.setSource("搜狐视频");
        video.setPageUrl(url);
        video.setSummary(summary);
        video.setHtmlCode(getHtmlCode(flash));
        return video;
    }

    private static String getScriptVarByName(String name, String content) {

        String script = content;
        int begin = script.indexOf(name);
        script = script.substring(begin + name.length() + 2);
        int end = script.indexOf(",");
        script = script.substring(0, end);
        String result = script.replaceAll("'", "");
        return result.trim();
    }

    private static String getElementAttrById(Document doc, String id, String attrName)
            throws Exception {

        Element et = doc.getElementById(id);
        String attrValue = et.attr(attrName);
        return attrValue;
    }

    private static String getHtmlCode(String flashUrl) throws Exception {

        return "<embed src=\""
                + flashUrl
                + "\" allowFullScreen=\"true\" quality=\"high\" width=\"480\" height=\"400\" align=\"middle\" allowScriptAccess=\"always\" type=\"application/x-shockwave-flash\"></embed>";
    }

    private static Document getURLContent(String url) throws Exception {

        Document doc = Jsoup.connect(url).data("query", "Java").userAgent("Mozilla")
                .cookie("auth", "token").timeout(5000).get();
        return doc;
    }
}
