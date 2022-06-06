package com.oodp.project;

public class Shower implements Monitor{
    private static Shower shower = null;

    private Shower(){}

    public static Shower getShower(){
        if(shower == null){
            shower = new Shower();
        }
        System.out.println(shower);
        return shower;
    }

    public void monitorResult() {
        System.out.println("    Shower Service is Completed!");
    }


}
