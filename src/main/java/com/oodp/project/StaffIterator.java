package com.oodp.project;

public class StaffIterator implements Iterator{

    private Staff_Group staff_group;
    private int index;
    public StaffIterator(Staff_Group staff_group) {
        this.staff_group = staff_group;
        this.index=0;
    }
    @Override
    public boolean hasNext() {
        if(index < staff_group.getLength()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Object next() {
        Staff staff = staff_group.getStaff(index);
        index++;
        return staff;
    }
}
