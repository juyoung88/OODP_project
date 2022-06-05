package com.oodp.project;

public class CheckIn_Group implements Aggregate{
    private CheckIn_Info[] CheckIn_Infos;
    private int num = 0;

    public CheckIn_Group(int num){
        this.CheckIn_Infos = new CheckIn_Info[num];
    }
    public CheckIn_Info getCheckIn_Info(int index){
        return CheckIn_Infos[index];
    }
    public void AddCheckIn_Info(CheckIn_Info checkIn_info){
        this.CheckIn_Infos[num] = checkIn_info;
        num++;
    }
    public int getLength(){
        return num;
    }
    public CheckInIterator iterator(){
        return new CheckInIterator(this);
    }
}
