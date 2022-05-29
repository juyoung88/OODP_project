package com.oodp.project;

import java.util.HashMap;

public class EarCleanFactory {
    private HashMap pool = new HashMap();
    private static EarCleanFactory singleton = new EarCleanFactory();
    private EarCleanFactory(){
    }
    public static EarCleanFactory getInstance(){
        return singleton;
    }
    public synchronized EarClean getEarClean(String monitorType, Member member, Pet pet){
        EarClean earClean = (EarClean)pool.get(""+monitorType);
        if(earClean == null){
            earClean = new EarClean(member, pet);
            pool.put("" + monitorType, earClean);
            earClean.monitorResult();
        }
        else{
            earClean.monitorResult();
        }
        return earClean;
    }
}
