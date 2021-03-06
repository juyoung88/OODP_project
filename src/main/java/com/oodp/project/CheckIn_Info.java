package com.oodp.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

enum MonitorType{
    Sleep, Walk, Eat, Groom, Shower, EarClean, NailCut
}

public class CheckIn_Info {

    private List<String> requirement;
    private List<MonitorType> monitorTypes;
    private int price = 0;
    private Date startDate;
    private Date endDate;
    private Pet pet;    private Member member;



    public CheckIn_Info(Member member, Pet pet, List<MonitorType> monitorTypes, List<String> requirement, int price, Date startDate, Date endDate) {
        super();
        this.member = member;
        this.pet = pet;
        this.monitorTypes = monitorTypes;
        this.requirement = requirement;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setMonitorTypes(List<MonitorType> monitorTypes) {
        this.monitorTypes = monitorTypes;
    }

    public void setRequirement(List<String> requirement) {
        this.requirement = requirement;
    }
    //check.setMonitorTypes(Arrays.asList(MonitorType.Sleep));
    public void setPrice(int price) {
        this.price = price;
    }


    public Pet getPet() {
        return pet;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<MonitorType> getMonitorTypes() {
        return monitorTypes;
    }

    public List<String> getRequirement() {
        return requirement;
    }

    public int getPrice() {
        calculatePrice();
        setMemberPoint();
        return price;
    }
    public void setMemberPoint() {
        int point = this.price;
        point *= 0.07;
        this.member.setMembershipPoint(point);
    }

    public String getStartDate() {
        String datePattern = "EE, yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(datePattern, Locale.ENGLISH);
        return format.format(startDate);
    }

    public String getEndDate() {
        String datePattern = "EE, yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(datePattern, Locale.ENGLISH);
        return format.format(endDate);
    }
    public void addMonitortype(MonitorType monitorType){
        monitorTypes.add(monitorType);
    }

    public int calculatePrice() {
        long diff = endDate.getTime() - startDate.getTime();
        float days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        for (MonitorType monitorType : getMonitorTypes()) {
            switch (monitorType) {
                case Sleep:
                    price += 40;
                    break;
                case Walk:
                case Groom:
                case Shower:
                    price += 50;
                    break;
                case Eat:
                    price += 30;
                    break;
                case EarClean:
                    price += 60;
                    break;
                case NailCut:
                    price += 70;
                    break;
            }
        }

        if(days > 0){
            price += days*100;
        }
        return price;
    }


    public void printMonitorResult() {
        for (MonitorType monitorType : getMonitorTypes()) {
            switch (monitorType) {
                case Sleep:
                    Sleep sleep = Sleep.getSleep();
                    sleep.monitorResult();
                    break;
                case Walk:
                    Walk walk = Walk.getWalk();
                    walk.monitorResult();
                    break;
                case Groom:
                    Groom groom = Groom.getGroom();
                    groom.monitorResult();
                    break;
                case Shower:
                      Shower shower = Shower.getShower();
                      shower.monitorResult();
                    break;
                case Eat:
                    Eat eat = Eat.getEat();
                    eat.monitorResult();
                    break;
                case EarClean:
                    EarClean earClean = EarClean.getEarClean();
                    earClean.monitorResult();
                    break;
                case NailCut:
                    NailCut nailCut = NailCut.getNailCut();
                    nailCut.monitorResult();
                    break;
            }
        }
    }
    public void addWeight(int weight){
        if(weight > 10) price += 10;
        else if(weight > 5) price += 5;
    }
}
