package com.luna.gui.socketchat.server;

import java.io.Serializable;   
public class Message implements Serializable{   
    private String from;   
    private String to;   
    private String content;   
    private String time;   
    private String pws;   
    public Message(){}   
    public Message(String from,String to,String content,String time,String pws){   
        this.from = from;   
        this.to = to;   
        this.content = content;   
        this.time = time;   
        this.pws = pws;   
    }   
    public Message(String from,String to,String content,String time){   
        this.from = from;   
        this.to = to;   
        this.content = content;   
        this.time = time;   
        this.pws = "start";   
    }   
    public void setFrom(String from){   
        this.from = from;   
    }   
    public String getFrom(){   
        return from;   
    }   
    public void setTo(String to){   
        this.to = to;   
    }   
    public String getTo(){   
        return to;   
    }   
    public void setContent(String content){   
        this.content = content;   
    }   
    public String getContent(){   
        return content;   
    }   
    public void setTime(String time){   
        this.time = time;   
    }   
    public String getTime(){   
        return time;   
    }   
    public void setPws(String pws){   
        this.pws = pws;   
    }   
    public String getPws(){   
        return pws;   
    }   
}  