package com.oodp.project;

import java.util.List;

public class Dog extends Pet{
    @Override
    public String getPetID() {
        return super.getPetID();
    }

    @Override
    public void setPetID(String petID) {
        super.setPetID(petID);
    }

    @Override
    public String getPetName() {
        return super.getPetName();
    }

    @Override
    public void setPetName(String petName) {
        super.setPetName(petName);
    }

    public Dog() {
        super();
    }

    @Override
    public String getPetType() {
        return super.getPetType();
    }

    @Override
    public void setPetType(String petType) {
        super.setPetType(petType);
    }

    @Override
    public List<String> getMonitorResult() {
        return super.getMonitorResult();
    }

    @Override
    public void setMonitorResult(List<String> monitorResult) {
        super.setMonitorResult(monitorResult);
    }


    public Dog(String petID, String petName, List<String> monitorResult) {
        super(petID, petName, monitorResult);
    }


}
