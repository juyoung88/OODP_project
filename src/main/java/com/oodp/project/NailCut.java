package com.oodp.project;

public class NailCut extends Monitor{
    private static NailCut nailCut = null;

    private NailCut(){}

    public static NailCut getNailCut(){
        if(nailCut == null){
            nailCut = new NailCut();
        }
        return nailCut;
    }

    public void monitorResult() {
        System.out.println("    NailCut Service is Completed!");
    }

}
