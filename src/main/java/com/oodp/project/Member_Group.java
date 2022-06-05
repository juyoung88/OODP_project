package com.oodp.project;

public class Member_Group implements Aggregate{
    private Member[] Members;
    private int num = 0;

    public Member_Group(int num){
        this.Members = new Member[num];
    }
    public Member getMember(int index){
        return Members[index];
    }
    public void AddMember(Member member){
        this.Members[num] = member;
        num++;
    }
    public int getLength(){
        return num;
    }
    public MemberGroupIterator iterator(){
        return new MemberGroupIterator(this);
    }

}
