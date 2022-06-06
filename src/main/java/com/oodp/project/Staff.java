package com.oodp.project;

import com.oodp.project.repository.MemberRepository;
import com.oodp.project.repository.MemoryMemberRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

    public void calculateStaffSalary() {staffRole.calculateStaffSalary();}

    public void setRole(StaffRole staffRole) {
        this.staffRole = staffRole;
    }

    public void monitor() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.showAll();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("> Enter Member ID (r: return)");
            String str = sc.next();
            if (str.equals("r"))
                break;
            else {
                Member member = memberRepository.findById(str);
                while(true) {
                    member.viewPetList();
                    System.out.println("> Enter Member's Pet ID (r: return)");
                    String petID = sc.next();
                    if (petID.equals("r"))
                        break;
                    else {
                        Pet pet = member.findByPetID(petID);
                        String monitoring;
                        String str2;
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");


                        char c;
                        do {
                            System.out.println("MonitorType : Sleep(1) Walk(2) Eat(3) Groom(4) Shower(5) EarClean(6) NailCut(7) RETURN(0)");
                            c = sc.next().charAt(0);

                            switch (c) {
                                case '1':
                                    System.out.println("> Enter how much pet slept (hours) ");
                                    monitoring = sc.next();
                                    str2 = "Sleep: " + monitoring + " hours [" + LocalDate.now().format(formatter) + "]";
                                    pet.getMonitorResult().add(str2);
                                    break;
                                case '2':
                                    System.out.println("> Enter how much pet walked (hours) ");
                                    monitoring = sc.next();
                                    pet.getMonitorResult().add("Walk: " + monitoring + " hours [" + LocalDate.now().format(formatter) + "]");
                                    break;
                                case '4':
                                    pet.getMonitorResult().add("Groom [" + LocalDate.now().format(formatter) + "]");
                                    break;
                                case '5':
                                    pet.getMonitorResult().add("Shower [" + LocalDate.now().format(formatter) + "]");
                                    break;
                                case '3':
                                    System.out.println("> Enter how much pet ate (grams) ");
                                    monitoring = sc.next();
                                    pet.getMonitorResult().add("Eat: " + monitoring + " g [" + LocalDate.now().format(formatter) + "]");
                                    break;
                                case '6':
                                    pet.getMonitorResult().add("EarClean [" + LocalDate.now().format(formatter) + "]");
                                    break;
                                case '7':
                                    pet.getMonitorResult().add("NailCut [" + LocalDate.now().format(formatter) + "]");
                                    break;
                            }
                        } while (c != '0');

//                        System.out.println("Do you want to save monitor result? (Y / N)");
//                        String save = sc.next();
//                        if (save.equals("Y") || save.equals("y")) {
//                            saveMonitorResult();
//                        }
//                        else {
//                            break;
//                        }

                        System.out.println("------" +pet.getPetName() +  "\'s Monitor Result------");
                        for(int i = 0; i < pet.getMonitorResult().size(); i++) {
                            System.out.println(pet.getMonitorResult().get(i));
                        }

                    }
                }
            }

        }

    }

    public void saveMonitorResult() {

    }
}