package com.oodp.project;
import java.util.Iterator;
import java.util.List;

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
    };

    public void addPetInfo(String petName) {
        Monitor m = new Monitor();
        int petID = getPetList().size() + 1;
        Pet p = new Pet( Integer.toString(petID), petName , m);
        this.petList.add(p);

        System.out.println("Pet Info Addition Successful!");
        System.out.println(getMemberID() + "'s new pet : " + p.getPetName());
    }

    public void viewPetList(){
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
    public Pet findByPetID(String petID){
        for (int i = 0; i < petList.size(); i++) {
            if (petID.equals(petList.get(i).getPetID())) return petList.get(i);

        }
        System.out.println("The petID does not exist. Please try again.");
        Monitor m = new Monitor();
        return new Pet("0", "" , m);
    }

}
