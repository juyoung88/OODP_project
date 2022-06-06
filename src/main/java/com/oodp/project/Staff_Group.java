package com.oodp.project;

public class Staff_Group {
    private Staff[] staffs;
    private int num=0;

    public Staff_Group(int num) {
        this.staffs = new Staff[num];
    }
    public Staff getStaff(int index) {
        return staffs[index];
    }
    public void AddStaff(Staff staff) {
        this.staffs[num] = staff;
        num++;
    }
    public int getLength() {
        return num;
    }
    public StaffIterator iterator() {
        return new StaffIterator(this);
    }
}
