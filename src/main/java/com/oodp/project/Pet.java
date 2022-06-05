package com.oodp.project;

import java.util.List;

public class Pet {
    private String petID;
    private String petName;
    private Monitor monitor;
    private List<String> monitorResult;

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

    public List<String> getMonitorResult() {
        return monitorResult;
    }

    public void setMonitorResult(List<String> monitorResult) {
        this.monitorResult = monitorResult;
    }

    public Pet(String petID, String petName, Monitor monitor, List<String> monitorResult) {
        super();
        this.petID = petID;
        this.petName = petName;
        this.monitor = monitor;
        this.monitorResult = monitorResult;
    }
}
