package com.oodp.project;

public class MemberGroupIterator implements Iterator{
    private Member_Group member_group;
    private int index;

    public MemberGroupIterator(Member_Group member_group){
        this.member_group = member_group;
        this.index = 0;
    }
    public boolean hasNext(){
        if(index < member_group.getLength()){
            return true;
        }
        else{
            return false;
        }
    }
    public Object next(){
        Member member = member_group.getMember(index);
        index++;
        return member;
    }
}
