package com.oodp.project;

import java.util.Scanner;

public class PartTimerRole implements StaffRole{
    public void viewStaffRole() {
        System.out.println("Your role is Part-timer.");
    }

    public void calculateStaffSalary() {
        Scanner sc = new Scanner(System.in);
        int salary = 0;

        System.out.print("Enter the hours you worked: ");
        String hour = sc.next();

        // 월급 계산식
        salary = Integer.parseInt(hour) * 9500;
        System.out.println("Your salary is " + salary + " won.");
    }

}
