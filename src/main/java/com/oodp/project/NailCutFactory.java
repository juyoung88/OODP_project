package com.oodp.project;

import java.util.HashMap;

public class NailCutFactory {
    private HashMap pool = new HashMap();
    private static NailCutFactory singleton = new NailCutFactory();
    private NailCutFactory(){
    }
    public static NailCutFactory getInstance(){
        return singleton;
    }
    public synchronized NailCut getNailCut(String monitorType, Member member, Pet pet){
        NailCut nailcut = (NailCut)pool.get(""+monitorType);
        if(nailcut == null){
            nailcut = new NailCut(member, pet);
            pool.put("" + monitorType, nailcut);
            nailcut.monitorResult();
        }
        else{
            nailcut.monitorResult();
        }
        return nailcut;
    }
}
