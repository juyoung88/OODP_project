package com.oodp.project;

import com.oodp.project.repository.MemberRepository;
import com.oodp.project.repository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c;
        System.out.println("WELCOME TO PET HOTEL!");
        Staff s = new Staff("1","admin","admin",50000);
        MemberRepository memberRepository = new MemoryMemberRepository(); // repository
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
                    System.out.println("CHOOSE MENU: ADD(1) VIEW(2) EDIT(3) DELETE(4) RETURN(5)");
                    c = sc.next().charAt(0);
                    if(c=='1') {
                        s.addMember(new Member("1", new ArrayList<>(),0),memberRepository);
                        s.addMember(new Member("2", new ArrayList<>(),0),memberRepository);
                        s.addMember(new Member("3", new ArrayList<>(),0),memberRepository);
                        System.out.println("Addition Successful!");
                    }
                    else if(c=='2') {
                        memberRepository.showAll();
                    }
                    else if(c=='5')
                        break;
                }
            }
            else if(c == '2') {
                System.out.println("------------------------------");
                System.out.println("IN MEMBER MODE");
                System.out.println("------------------------------");
                System.out.println("CHOOSE MEMBER");
                memberRepository.showAll();
            }
            else break;

        }

    }
}