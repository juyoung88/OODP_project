package com.oodp.project;
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

}