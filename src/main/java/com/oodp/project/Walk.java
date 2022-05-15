package com.oodp.project;

public class Walk {
    private Pet pet;
    private Member member;

    public Walk(Member member, Pet pet){
        super();
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
        System.out.println("    Walk Service is Completed!");
    }

}
