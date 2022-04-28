package com.oodp.project;
import java.util.List;

public class Member {
    private String memberID;
    private List<Pet> petList;
    private int membershipPoint;

    public Member(String memberID, List<Pet> petList, int membershipPoint) {
        super();
        this.memberID = memberID;
        this.petList = petList;
        this.membershipPoint = membershipPoint;
    };

}