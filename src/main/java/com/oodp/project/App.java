package com.oodp.project;

import com.oodp.project.repository.MemberRepository;
import com.oodp.project.repository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner strSc = new Scanner(System.in);
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
//                System.out.println("------------------------------");
//
//                System.out.println("IN MEMBER MODE");
//                System.out.println("------------------------------");
//                Member member = new Member("1", new ArrayList<>(),0);
//                CheckIn_Info check = new CheckIn_Info(member, new ArrayList<>(), new ArrayList<>(), 0, new Date(), new Date());
//
//                //System.out.println("CHOOSE MEMBER");
//                //memberRepository.showAll();
//
//                while(true){
//
//                    System.out.println("CHOOSE MENU: CHECK-IN(1) RETURN(2)");
//                    System.out.println("------------------------------");
//
//                    c = sc.next().charAt(0);
//                    if(c =='1') {
//                        System.out.println("------------------------------");
//                        System.out.println("Need some information for check-in ");
//                        System.out.println("------------------------------");
//
//                        typeMonitor(check);
//                        typeInfo(check);
//                        printInfo(check);
//
//                    }
//                    else if(c =='2') {
//                        break;
//                    }
//                 }

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
                            System.out.println("CHOOSE MENU:\n1. SHOW PET LIST\n2. ADD PET INFO\n3. EDIT PET INFO\n4. DELETE PET INFO\n5. CHECK_IN\n6. RETURN");
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
                            else if(c =='5') {
                                if(m.getPetList().size() == 0){
                                    m.viewPetList();
                                    continue;
                                }
                                m.viewPetList();

                                System.out.println("------------------------------");
                                System.out.println("Type a petID for Check-in");
                                System.out.println("------------------------------");

                                String petID = sc.next();
                                if(m.findByID(petID).getPetID() == "0") continue;

                                CheckIn_Info check = new CheckIn_Info(m, m.findByID(petID), new ArrayList<>(), new ArrayList<>(), 0, new Date(), new Date());

                                typeMonitor(check);
                                typeInfo(check);
                                printInfo(check);
                            }
                            else if(c == '6'){
                                break;
                            }
                        }
                    }
                }
            }
            else break;
        }
    }
    public static void typeMonitor(CheckIn_Info check){
        Scanner sc = new Scanner(System.in);
        char c;
        do{
            System.out.println("MonitorType : Sleep(1) Walk(2) Eat(3) Groom(4) Shower(5) EarClean(6) NailCut(7) RETURN(0)");
            c = sc.next().charAt(0);

            switch (c){
                case '1': check.addMonitortype(MonitorType.Sleep); break;
                case '2': check.addMonitortype(MonitorType.Walk); break;
                case '3': check.addMonitortype(MonitorType.Eat); break;
                case '4': check.addMonitortype(MonitorType.Groom); break;
                case '5': check.addMonitortype(MonitorType.Shower); break;
                case '6': check.addMonitortype(MonitorType.EarClean); break;
                case '7': check.addMonitortype(MonitorType.NailCut); break;
                case '0': break;

            }
        }while(c != '0');
    }
    public static void typeInfo(CheckIn_Info check){
        Scanner strSc = new Scanner(System.in);
        String str;
        System.out.println("Type Start Day (ex: Sat, 02 Apr 2022)");
        str = strSc.nextLine();
        check.setStartDate(new Date(str));
        System.out.println("Type End Day (ex: Sun, 03 Apr 2022)");
        str = strSc.nextLine();
        check.setEndDate(new Date(str));

        System.out.println("Requirement : ");
        str = strSc.nextLine();

        check.setRequirement(Arrays.asList(str));
    }

    public static void printInfo(CheckIn_Info check){
        System.out.println("------------------------------");

        System.out.println("PetID : " + check.getPet().getPetID());
        System.out.println("PetName : " + check.getPet().getPetName());
        System.out.println("MonitorType : " + check.getMonitorTypes());
        System.out.println("Start Day : " + check.getStartDate());
        System.out.println("End Day : " + check.getEndDate());
        System.out.println("Your requirement : " + check.getRequirement());
        System.out.println("Total price : " + check.getPrice());
    }
}