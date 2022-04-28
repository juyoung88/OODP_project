package com.oodp.project;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c;
        System.out.println("WELCOME TO PET HOTEL!");
        Staff s = new Staff("1","admin","admin",50000);
        System.out.println("------------------------------");
        while(true) {
            System.out.println("CHOOSE MODE: ADMIN(1) MEMBER(2) QUIT(3)");
            System.out.println("------------------------------");
            c = sc.next().charAt(0);
            if(c == '1') {
                System.out.println("------------------------------");
                System.out.println("IN ADMIN MODE");
                System.out.println("------------------------------");
                while(true) {

                }
            }
            else if(c == '2') {
                System.out.println("------------------------------");
                System.out.println("IN MEMBER MODE");
                System.out.println("------------------------------");
            }
            else break;

        }

    }
}