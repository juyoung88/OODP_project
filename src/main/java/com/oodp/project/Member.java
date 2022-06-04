package com.oodp.project;

import com.oodp.project.repository.CheckInRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Member {
    private String memberID;
    private List<Pet> petList;
    private int membershipPoint;

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public void setMembershipPoint(int membershipPoint) {
        this.membershipPoint = membershipPoint;
    }

    public String getMemberID() {
        return memberID;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public int getMembershipPoint() {
        return membershipPoint;
    }

    public Member(String memberID, List<Pet> petList, int membershipPoint) {
        super();
        this.memberID = memberID;
        this.petList = petList;
        this.membershipPoint = membershipPoint;
    }


    public void addPetInfo(String petName) {
        int petID = getPetList().size() + 1;
        Pet p = new Pet(Integer.toString(petID), petName);
        this.petList.add(p);

        System.out.println("Pet Info Addition Successful!");
        System.out.println(getMemberID() + "'s new pet : " + p.getPetName());
    }
    public void addPetInfo(Pet pet, String petName) {
        int petID = getPetList().size() + 1;
        pet.setPetID(Integer.toString(petID));
        pet.setPetName(petName);
        this.petList.add(pet);

        System.out.println("Pet Info Addition Successful!");
        System.out.println(getMemberID() + "'s new pet : " + pet.getPetName());
        System.out.println("petType : " + pet.getPetType());
    }

    public void viewPetList() {
        List<Pet> petList = this.getPetList();
        Iterator iterator = petList.iterator();
        System.out.println("------------------------------");
        System.out.println("petList.size() : " + petList.size());
        if (petList.size() == 0)
            System.out.println("Your Pet List is Empty! Please Add Your Pet Info First :)");
        else {
            System.out.println("[" + getMemberID() + "'s petList]");

            System.out.println("<petID>  \t<petName>  \t< monitor> ");
            for (int i = 0; i < petList.size(); i++) {
                // TODO: monitor 정보 출력
                System.out.println("   " + petList.get(i).getPetID() + "\t\t  " + petList.get(i).getPetName());
            }
        }
    }

    public Pet findByPetID(String petID) {
        for (int i = 0; i < petList.size(); i++) {
            if (petID.equals(petList.get(i).getPetID())) return petList.get(i);

        }
        System.out.println("The petID does not exist. Please try again.");
        return new Pet("0", "");
    }

    public void checkIn(Member m, String petID, List<CheckIn_Info> checkInList) {
        CheckIn_Info check = new CheckIn_Info(m, m.findByPetID(petID), new ArrayList<>(), new ArrayList<>(), 0, new Date(), new Date());

        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want Monitor Service ? yes(1) no (2)");
        char c = sc.next().charAt(0);
        if(c == '1'){
            typeMonitor(check);
        }
        typeWeight(check);
        type_checkIn_info(check);
        // repository 에 저장
        checkInList.add(check);
//        System.out.println("saving in checkInList successful!");

        view_checkIn_info(checkInList, m);

    }

    public void checkOut(Member m, String petID, List<CheckIn_Info> checkInList) {
        for (int i = 0; i < checkInList.size(); i++) {
//            System.out.println("checkOut - memberID: " + checkInList.get(i).getMember().getMemberID());
//            System.out.println("checkOut - petID: " + checkInList.get(i).getPet().getPetID());

            if ((checkInList.get(i).getMember().getMemberID().equals(m.getMemberID())) && (checkInList.get(i).getPet().getPetID().equals(petID))) {

                checkInList.remove(i);
                System.out.println("Check-Out successful!");
            }
        }

    }

    public static void typeWeight(CheckIn_Info check){
        Scanner sc = new Scanner(System.in);

        System.out.println("Type your pet's weight(kg)");
        int weight = sc.nextInt();
        check.addWeight(weight);
    }

    public static void typeMonitor(CheckIn_Info check) {
        Scanner sc = new Scanner(System.in);
        char c;
        do {
            System.out.println("MonitorType : Sleep(1) Walk(2) Eat(3) Groom(4) Shower(5) EarClean(6) NailCut(7) RETURN(0)");
            c = sc.next().charAt(0);

            switch (c) {
                case '1':
                    check.addMonitortype(MonitorType.Sleep);
                    break;
                case '2':
                    check.addMonitortype(MonitorType.Walk);
                    break;
                case '3':
                    check.addMonitortype(MonitorType.Eat);
                    break;
                case '4':
                    check.addMonitortype(MonitorType.Groom);
                    break;
                case '5':
                    check.addMonitortype(MonitorType.Shower);
                    break;
                case '6':
                    check.addMonitortype(MonitorType.EarClean);
                    break;
                case '7':
                    check.addMonitortype(MonitorType.NailCut);
                    break;
                case '0':
                    break;

            }
        } while (c != '0');
    }

    public static void type_checkIn_info(CheckIn_Info check) {
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

    public static boolean view_checkIn_info(List<CheckIn_Info> checkInRepository, Member m) {

        boolean found = false;

        for (int i = 0; i < checkInRepository.size(); i++) {
            if (checkInRepository.get(i).getMember() == m) {
                found = true;
                CheckIn_Info check = checkInRepository.get(i);

                System.out.println("------------------------------");
                System.out.println("[Check In Info]");

                System.out.println("Member ID: " + check.getMember().getMemberID());
                System.out.println("PetID : " + check.getPet().getPetID());
                System.out.println("PetName : " + check.getPet().getPetName());
                System.out.println("MonitorType : " + check.getMonitorTypes());
                System.out.println("Start Day : " + check.getStartDate());
                System.out.println("End Day : " + check.getEndDate());
                System.out.println("Your requirement : " + check.getRequirement());
                System.out.println("Total price : " + check.getPrice());
                System.out.println("Membership point : " + m.getMembershipPoint());
                System.out.println("monitor result : ");
            }
        }
        if (!found) {
            System.out.println("There's no check-in list yet..! Please Check-In first :) ");
        }

        return found;


    }

}
