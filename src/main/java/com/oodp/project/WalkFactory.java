package com.oodp.project;

import java.util.HashMap;

public class WalkFactory {
    private final HashMap pool = new HashMap();
    private static final WalkFactory singleton = new WalkFactory();
    private WalkFactory(){
    }
    public static WalkFactory getInstance(){
        return singleton;
    }
    public synchronized Walk getWalk(String monitorType, Member member, Pet pet){
        Walk walk = (Walk)pool.get(""+monitorType);
        if(walk == null){
            walk = new Walk(member, pet);
            pool.put("" + monitorType, walk);
            walk.monitorResult();
        }
        else{
            walk.monitorResult();
        }
        return walk;
    }
}
