package com.oodp.project;

import java.util.List;

public class Pet {
    private String petID;
    private String petName;

    
    private List<String> monitorResult;

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



    public List<String> getMonitorResult() {
        return monitorResult;
    }

    public void setMonitorResult(List<String> monitorResult) {
        this.monitorResult = monitorResult;
    }

    public Pet(String petID, String petName,List<String> monitorResult) {
        super();
        this.petID = petID;
        this.petName = petName;
        this.monitorResult = monitorResult;

    }
    public Pet() {
        super();
        this.petID=null;
        this.petName=null;
    }

}
