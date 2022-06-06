package com.oodp.project;

public class Walk implements Monitor{
    private static Walk walk = null;

    private Walk(){}

    public static Walk getWalk(){
        if(walk == null){
            walk = new Walk();
        }
        return walk;
    }

    public void monitorResult() {
        System.out.println("    Walk Service is Completed!");
    }


}
