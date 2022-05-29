package com.oodp.project;

import java.util.HashMap;

public class GroomFactory {
    private HashMap pool = new HashMap();
    private static GroomFactory singleton = new GroomFactory();
    private GroomFactory(){
    }
    public static GroomFactory getInstance(){
        return singleton;
    }
    public synchronized Groom getGroom(String monitorType, Member member, Pet pet){
        Groom groom = (Groom)pool.get(""+monitorType);
        if(groom == null){
            groom = new Groom(member, pet);
            pool.put("" + monitorType, groom);
            groom.monitorResult();
        }
        else{
            groom.monitorResult();
        }
        return groom;
    }
}
