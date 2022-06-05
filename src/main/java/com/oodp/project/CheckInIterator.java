package com.oodp.project;


public class CheckInIterator implements Iterator{
    private CheckIn_Group checkIn_group;
    private int index;

    public CheckInIterator(CheckIn_Group checkIn_group){
        this.checkIn_group = checkIn_group;
        this.index = 0;
    }
    public boolean hasNext(){
        if(index < checkIn_group.getLength()){
            return true;
        }
        else{
            return false;
        }
    }
    public Object next(){
        CheckIn_Info checkIn_info = checkIn_group.getCheckIn_Info(index);
        index++;
        return checkIn_info;
    }
}
