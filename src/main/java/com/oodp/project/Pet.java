package com.oodp.project;

public class Pet {
    private String petID;
    private String petName;
    private String petType;

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

//    public Monitor getMonitor() {
//        return monitor;
//    }

    //public void setMonitor(Monitor monitor) {
//        this.monitor = monitor;
//    }

    //private Monitor monitor;

//    public Pet(String petID, String petName, Monitor monitor) {
    public Pet(String petID, String petName) {
        super();
        this.petID = petID;
        this.petName = petName;
        //this.monitor = monitor;
    }
    public Pet() {
        super();
        this.petID=null;
        this.petName=null;
        //this.monitor=null;
    }
}
