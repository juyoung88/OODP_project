package com.oodp.project;

public abstract class Monitor{
    private Pet pet;
    private Member member;

    public Monitor(Member member, Pet pet){
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

    public abstract void monitorResult();
}
