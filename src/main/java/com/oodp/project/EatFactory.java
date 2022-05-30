package com.oodp.project;

import java.util.HashMap;

public class EatFactory {
    private final HashMap pool = new HashMap();
    private static final EatFactory singleton = new EatFactory();
    private EatFactory(){
    }
    public static EatFactory getInstance(){
        return singleton;
    }
    public synchronized Eat getEat(String monitorType, Member member, Pet pet){
        Eat eat = (Eat)pool.get(""+monitorType);
        if(eat == null){
            eat = new Eat(member, pet);
            pool.put("" + monitorType, eat);
            eat.monitorResult();
        }
        else{
            eat.monitorResult();
        }
        return eat;
    }
}
