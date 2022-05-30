package com.oodp.project;

public class Shower extends Monitor{
    private Pet pet;
    private Member member;

    public Shower(Member member, Pet pet){
        super(member, pet);
        this.member = member;
        this.pet = pet;
    }

    public Member getMember(){
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void monitorResult() {
        System.out.println("    Shower Service is Completed!");
    }

}
