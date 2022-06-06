package com.oodp.project;

public class Sleep implements Monitor{
    private static Sleep sleep = null;

    private Sleep(){}

    public static Sleep getSleep(){
        if(sleep == null){
            sleep = new Sleep();
        }
        return sleep;
    }

    public void monitorResult() {
        System.out.println("    Sleep Service is Completed!");
    }


}