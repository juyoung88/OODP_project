package com.oodp.project;

public class Sleep extends Monitor{
    private Pet pet;
    private Member member;

    public Sleep(Member member, Pet pet){
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
        System.out.println("    Sleep Service is Completed!");
    }

}
