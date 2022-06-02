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

    public Pet(String petID, String petName) {
        super();
        this.petID = petID;
        this.petName = petName;
    }
    public Pet() {
        super();
        this.petID=null;
        this.petName=null;
    }
}
