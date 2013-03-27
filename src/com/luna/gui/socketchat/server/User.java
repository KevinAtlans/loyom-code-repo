package com.luna.gui.socketchat.server;

import java.io.*;   
public class User{   
    private String from;   
    private ObjectInputStream ois;   
    private ObjectOutputStream oos;    
    public User(){}   
    public User(String from,ObjectInputStream ois,ObjectOutputStream oos){   
        this.from = from;   
        this.ois = ois;   
        this.oos = oos;   
    }   
    public void setFrom(String from){   
        this.from = from;   
    }   
    public String getFrom(){   
        return from;   
    }   
    public void setOis(ObjectInputStream ois){   
        this.ois = ois;   
    }   
    public ObjectInputStream getOis(){   
        return ois;   
    }   
    public void setOos(ObjectOutputStream oos){   
        this.oos = oos;   
    }   
    public ObjectOutputStream getOos(){   
        return oos;   
    }   
}