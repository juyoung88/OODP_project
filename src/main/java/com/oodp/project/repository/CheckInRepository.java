package com.oodp.project.repository;

import com.oodp.project.CheckIn_Info;

import java.util.ArrayList;
import java.util.List;

public class CheckInRepository {
    public List<CheckIn_Info> getCheckIn_info_list() {
        return checkIn_info_list;
    }

    public void setCheckIn_info_list(List<CheckIn_Info> checkIn_info_list) {
        this.checkIn_info_list = checkIn_info_list;
    }

    private List<CheckIn_Info> checkIn_info_list = new ArrayList<>();

}
