package com.oodp.project;

import java.util.HashMap;

public class ShowerFactory {
    private HashMap pool = new HashMap();
    private static ShowerFactory singleton = new ShowerFactory();
    private ShowerFactory(){
    }
    public static ShowerFactory getInstance(){
        return singleton;
    }
    public synchronized Shower getShower(String monitorType, Member member, Pet pet){
        Shower shower = (Shower)pool.get(""+monitorType);
        if(shower == null){
            shower = new Shower(member, pet);
            pool.put("" + monitorType, shower);
            shower.monitorResult();
        }
        else{
            shower.monitorResult();
        }
        return shower;
    }
}
