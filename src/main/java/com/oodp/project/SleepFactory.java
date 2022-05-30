package com.oodp.project;

import java.util.HashMap;

public class SleepFactory {
    private final HashMap pool = new HashMap();
    private static final SleepFactory singleton = new SleepFactory();
    private SleepFactory(){
    }
    public static SleepFactory getInstance(){
        return singleton;
    }
    public synchronized Sleep getSleep(String monitorType, Member member, Pet pet){
        Sleep sleep = (Sleep)pool.get(""+monitorType);
        if(sleep == null){
            sleep = new Sleep(member, pet);
            pool.put("" + monitorType, sleep);
            sleep.monitorResult();
        }
        else{
            sleep.monitorResult();
        }
        return sleep;
    }
}
