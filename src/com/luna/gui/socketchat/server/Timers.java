package com.luna.gui.socketchat.server;

import java.util.*;   
public class Timers{   
    public static String getTime(){   
        String time;   
        int s,f,m;   
        Calendar c = Calendar.getInstance();   
        s = c.HOUR_OF_DAY;   
        f = c.MINUTE;   
        m = c.SECOND;   
        s = c.get(s);   
        f = c.get(f);   
        m = c.get(m);   
        time = s + ":" + f + ":" +m;   
        return time;   
    }   
}  