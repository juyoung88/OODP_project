package com.oodp.project;

import com.oodp.project.repository.MemberRepository;
import com.oodp.project.repository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c;
        String str;
        System.out.println("WELCOME TO PET HOTEL!");
        Staff s = new Staff("1","admin","admin",50000);
        MemberRepository memberRepository = new MemoryMemberRepository(); // repository

        while(true) {
            System.out.println("---------------------------------------");
            System.out.println("CHOOSE MODE: ADMIN(1) MEMBER(2) QUIT(3)");
            System.out.println("------------------------------");
            c = sc.next().charAt(0);
            if(c == '1') {
                System.out.println("------------------------------");
                System.out.println("[ADMIN MODE]");
                while(true) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("CHOOSE MENU: ADD(1) VIEW(2) EDIT(3) DELETE(4) RETURN(5)");
                    c = sc.next().charAt(0);
                    if(c=='1') {
                        s.addMember(new Member("1", new ArrayList<>(),0),memberRepository);
                        s.addMember(new Member("2", new ArrayList<>(),0),memberRepository);
                        s.addMember(new Member("3", new ArrayList<>(),0),memberRepository);
                        System.out.println("Member Addition Successful!");
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
                System.out.println("[MEMBER MODE]");


                // TODO: 나중에 삭제하기
//                s.addMember(new Member("1", new ArrayList<>(),0),memberRepository);
//                s.addMember(new Member("2", new ArrayList<>(),0),memberRepository);
//                s.addMember(new Member("3", new ArrayList<>(),0),memberRepository);
//                System.out.println("Member Addition Successful!");

                while(true) {
                    System.out.println("---------------------------");
                    memberRepository.showAll();
                    System.out.println("> Enter Member ID (r: return)");
                    str = sc.next();
                    if (str.equals("r"))
                        break;
                    else {
                        Member m = memberRepository.findById(str);
//                        System.out.println("getMemberID(): " + m.getMemberID());
                        while(true) {
                            System.out.println("---------------------------");
                            System.out.println("CHOOSE MENU:\n1. SHOW PET LIST\n2. ADD PET INFO\n3. EDIT PET INFO\n4. DELETE PET INFO\n5. RETURN");
                            c = sc.next().charAt(0);
                            if (c == '1') {
                               m.viewPetList();
                            }
                            else if (c =='2') {
                                System.out.println("Please Enter Your Pet name.");
                                String petName = sc.next();
                                m.addPetInfo(petName);
                            }
                            else if (c =='3') {
                                System.out.println("not implemented yet...");
                            }
                            else if (c =='4') {
                                System.out.println("not implemented yet...");
                            }
                            else if (c == '5') {
                                break;
                            }

                        }


                    }
                }

            }
            else break;

        }

    }
}