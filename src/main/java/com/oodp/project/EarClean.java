package com.oodp.project;

public class EarClean implements Monitor{
    private static EarClean earClean = null;

    private EarClean(){}

    public static EarClean getEarClean(){
        if(earClean == null){
            earClean = new EarClean();
        }
        return earClean;
    }

    public void monitorResult() {
        System.out.println("    EarClean Service is Completed!");
    }


}
