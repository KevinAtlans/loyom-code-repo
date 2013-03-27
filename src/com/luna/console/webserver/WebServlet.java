package com.luna.console.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONObject;

import com.luna.utils.WritetToFile;

public class WebServlet implements Servlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException,
            IOException {

        String command = request.getParameter("method");
        if (null == command || command.isEmpty())
            return;

        response.setContentType("text/html;charset=UTF-8");
        if ("newurl".equals(command)) {
            PrintWriter writer = response.getWriter();
            writer.write(getUrl());
            return;
        } else if ("returnresult".equals(command)) {
            BufferedReader br = request.getReader();
            String json = null;
            String res = null;
            while ((res = br.readLine()) != null) {
                json = json + res;
            }
            write(json);
        } else if ("hello".equals(command)) {
            JSONObject json = new JSONObject();
            json.put("name", "Kevin");
            json.put("age", "20");
            json.put("sign", "this is signature");
            PrintWriter writer = response.getWriter();
            writer.write(json.toString());
        }
    }

    private String getUrl() {

        RestMessage restMessage = new RestMessage();
        restMessage.setDeliveryTag(1L);
        restMessage.setIsLastMessage(true);
        restMessage
                .setJavaScriptObject("\"var timeout;var counter = 0;var timer_is_on = false;var is_send = false;function shouldProcessState() {var state = $('a[class=dsq-more-button]').attr('href') != null;return state;}function fireStateEvent() {var element = $('a[class=dsq-more-button]');element.click();}function doOperationOnState() {if (shouldProcessState()) {fireStateEvent();setTimeout('doOperationOnState()', 3000);} else {is_send = true;}if (is_send) {var links = $('a').attr('href');var requestObject = {links : links,response : getSerializedDom(),pages : counter,isLast : true};chrome.extension.sendRequest(requestObject);}}function getSerializedDom() {var serializer = new XMLSerializer(); var xml = serializer.serializeToString(document); return xml;}function fireStateEvents() {if (!timer_is_on) {timer_is_on = true;timeout = setTimeout('doOperationOnState()', 5000);}}function scrollToComment() {var element = document.getElementById('disqus_thread');if (element != null) {var actualTop = element.offsetTop;var current = element.offsetParent;while (current !== null) {actualTop += current.offsetTop;current = current.offsetParent;}scroll(0, actualTop);}fireStateEvents();}$(document).ready(function() {$.getScript('http://sitename.disqus.com/embed.js', function() {var loader = setInterval(function() {if ($('#disqus_thread').html().length) {clearInterval(loader);disqusReady();}}, 1000);});scrollToComment();});\"");
        restMessage.setPageNumber(1);
        restMessage.setPayload("");
        restMessage.setSubsourceId(2L);
        restMessage
                .setUrl("http://www.electricpig.co.uk/2012/06/22/win-a-samsung-40-inch-led-tv-courtesy-of-currys/");
        return restMessage.toString();
    }

    private int i = 1;

    private void write(String content) {

        WritetToFile wtf = new WritetToFile();
        wtf.WriteOne(content, i + "con.html");
        i = i + 1;
    }

    @Override
    public void destroy() {

        // TODO Auto-generated method stub

    }

    @Override
    public ServletConfig getServletConfig() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {

        // TODO Auto-generated method stub

    }
}
