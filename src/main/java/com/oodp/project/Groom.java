package com.oodp.project;

public class Groom implements Monitor{
    private static Groom groom = null;

    private Groom(){}

    public static Groom getGroom(){
        if(groom == null){
            groom = new Groom();
        }
        return groom;
    }

    public void monitorResult() {
        System.out.println("    Groom Service is Completed!");
    }


}
