package com.oodp.project;

public class Cat extends Pet{
    @Override
    public String getPetType() {
        return super.getPetType();
    }

    @Override
    public void setPetType(String petType) {
        super.setPetType(petType);
    }

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

    @Override
    public Monitor getMonitor() {
        return super.getMonitor();
    }

    @Override
    public void setMonitor(Monitor monitor) {
        super.setMonitor(monitor);
    }

    public Cat() {
        super();
    }

    public Cat(String petID, String petName, Monitor monitor) {
        super(petID, petName, monitor);
    }
}