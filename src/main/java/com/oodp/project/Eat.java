package com.oodp.project;

public class Eat extends Monitor{
    private static Eat eat = null;

    private Eat(){}

    public static Eat getEat(){
        if(eat == null){
            eat = new Eat();
        }
        return eat;
    }

    public void monitorResult() {
        System.out.println("    Eat Service is Completed!");
    }

}
