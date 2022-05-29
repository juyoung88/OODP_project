package com.oodp.project;

import com.oodp.project.repository.MemberRepository;
import com.oodp.project.repository.MemoryMemberRepository;

public class Staff {
    private String staffID;
    private String staffName;
    private String role;
    private int salary;


    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getRole() {
        return role;
    }

    public int getSalary() {
        return salary;
    }

    public Staff(String staffID, String staffName, String role, int salary) {
        super();
        this.staffID = staffID;
        this.staffName = staffName;
        this.role = role;
        this.salary = salary;
    }

    public void addMember(Member member, MemberRepository memberRepository) {
        memberRepository.save(member);
    }

    private StaffRole staffRole;

    public void viewStaffRole() {
        staffRole.viewStaffRole();
    }

    public void setRole(StaffRole staffRole) {
        this.staffRole = staffRole;
    }
}