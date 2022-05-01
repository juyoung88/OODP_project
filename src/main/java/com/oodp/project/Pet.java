package com.oodp.project;

public class Pet {
    private String petID;
    private String petName;

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

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    private Monitor monitor;

    public Pet(String petID, String petName, Monitor monitor) {
        super();
        this.petID = petID;
        this.petName = petName;
        this.monitor = monitor;
    }
}
