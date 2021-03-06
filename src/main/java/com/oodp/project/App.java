package com.oodp.project;

import com.oodp.project.factory.PetFactory;
import com.oodp.project.repository.CheckInRepository;
import com.oodp.project.repository.MemberRepository;
import com.oodp.project.repository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner strSc = new Scanner(System.in);
        char c;
        String str;
        System.out.println("WELCOME TO PET HOTEL!");
        Staff s = new Staff("1", "admin", "admin", 50000);
        MemberRepository memberRepository = new MemoryMemberRepository();
        CheckInRepository checkInRepository = new CheckInRepository();// repository
        PetFactory petFactory = new PetFactory();
        Member_Group member_group = new Member_Group(5);
        Staff_Group staff_group = new Staff_Group(5);


        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("CHOOSE MODE: ADMIN(1) MEMBER(2) QUIT(3)");
            System.out.println("------------------------------");

            c = sc.next().charAt(0);

            if (c == '1') {
                System.out.println("-------------------------------------------------------");
                System.out.println("CHOOSE STAFF ROLE: MANAGER(1) PART-TIMER(2) RETURN(3)");
                System.out.println("-------------------------------------------------------");

                c = sc.next().charAt(0);

                if (c == '1') {
                    s.setRole(new ManagerRole());

                    System.out.println("--------------");
                    System.out.println("[MANAGER MODE]");
                    while (true) {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("CHOOSE MENU: ADD MEMBER(1) VIEW MEMBER(2) EDIT(3) DELETE(4)\n" +
                                "VIEW ROLE(5) CALCULATE SALARY(6) MONITOR(7) ADD STAFF(8) VIEW STAFF(9) RETURN(Q)");
                        c = sc.next().charAt(0);
                        if (c == '1') {
                            s.addMember(new Member("1", new ArrayList<>(), 0), memberRepository);
                            s.addMember(new Member("2", new ArrayList<>(), 0), memberRepository);
                            s.addMember(new Member("3", new ArrayList<>(), 0), memberRepository);
                            member_group.AddMember(new Member("1", new ArrayList<>(), 0));
                            member_group.AddMember(new Member("2", new ArrayList<>(), 0));
                            member_group.AddMember(new Member("3", new ArrayList<>(), 0));

                            MemberGroupIterator member_iterator = member_group.iterator();
                            while(member_iterator.hasNext()){
                                Member member = (Member)member_iterator.next();
                                System.out.println("(test) Member ID : " + member.getMemberID());
                                System.out.println("(test) Member point : " + member.getMembershipPoint());
                            }
                            System.out.println("Member Addition Successful!");
                        } else if (c == '2') {
                            memberRepository.showAll();
                        } else if (c == '5') {
                            s.viewStaffRole();
                        } else if (c == '6') {
                            s.calculateStaffSalary();
                        } else if (c == '7') {
                            s.monitor();
                        } else if(c == '8') {
                            staff_group.AddStaff(new Staff("2","A","part_time",50000));
                            staff_group.AddStaff(new Staff("3","B","part_time",50000));
                            staff_group.AddStaff(new Staff("4","C","part_time",50000));
                            System.out.println("Staff addition complete!");
                        } else if(c=='9') {
                            StaffIterator staffIterator = new StaffIterator(staff_group);
                            while(staffIterator.hasNext()) {
                                Staff staff = (Staff)staffIterator.next();
                                System.out.println("staff ID = " + staff.getStaffID());
                                System.out.println("staff Name = " + staff.getStaffName());
                                System.out.println("staff Role = " + staff.getRole());
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
                else if (c == '2') {
                    s.setRole(new PartTimerRole());

                    System.out.println("----------------");
                    System.out.println("[PART-TIMER MODE]");

                    while (true) {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("CHOOSE MENU: ADD MEMBER(1) VIEW MEMBER(2) EDIT(3) DELETE(4)\n" +
                                "VIEW ROLE(5) CALCULATE SALARY(6) MONITOR(7) RETURN(8)");
                        c = sc.next().charAt(0);
                        if (c == '1') {
                            s.addMember(new Member("1", new ArrayList<>(), 0), memberRepository);
                            s.addMember(new Member("2", new ArrayList<>(), 0), memberRepository);
                            s.addMember(new Member("3", new ArrayList<>(), 0), memberRepository);

//                            member_group.AddMember(new Member("1", new ArrayList<>(), 0));
//                            member_group.AddMember(new Member("2", new ArrayList<>(), 0));
//                            member_group.AddMember(new Member("3", new ArrayList<>(), 0));

//                            MemberGroupIterator member_iterator = member_group.iterator();
//                            while(member_iterator.hasNext()){
//                                Member member = (Member)member_iterator.next();
//                                System.out.println("(test) Member ID : " + member.getMemberID());
//                                System.out.println("(test) Member point : " + member.getMembershipPoint());
//                            }

                            System.out.println("Member Addition Successful!");
                        } else if (c == '2') {
                            memberRepository.showAll();
                        } else if (c == '5') {
                            s.viewStaffRole();
                        } else if (c == '6') {
                            s.calculateStaffSalary();
                        } else if (c == '7') {
                            s.monitor();
                        }
                        else {
                            break;
                        }
                    }

                }
                else {
                    break;
                }

            } else if (c == '2') {

                System.out.println("[MEMBER MODE]");

                while (true) {
                    System.out.println("---------------------------");
                    memberRepository.showAll();
                    System.out.println("> Enter Member ID (r: return)");
                    str = sc.next();
                    if (str.equals("r"))
                        break;
                    else {
                        Member m = memberRepository.findById(str);
//                        System.out.println("getMemberID(): " + m.getMemberID());
                        while (true) {
                            System.out.println("---------------------------");
                            System.out.println("CHOOSE MENU:\n1. SHOW PET LIST\n2. ADD PET INFO\n3. EDIT PET INFO\n4. DELETE PET INFO\n" +
                                    "5. CHECK_IN\n6. CHECK_OUT\n7. VIEW CHECK_IN LIST\n8. VIEW MONITOR RESULT\n9. RETURN");
                            c = sc.next().charAt(0);
                            if (c == '1') {
                                m.viewPetList();
                            } else if (c == '2') {
                                System.out.println("Please Enter Your Pet type (Dog, Cat).");
                                String petType = sc.next();
                                Pet p = petFactory.getPet(petType);
                                System.out.println("Please Enter Your Pet name.");
                                String petName = sc.next();
                                m.addPetInfo(p,petName);
                                member_group.AddMember(m);

                            } else if (c == '3') {
                                System.out.println("not implemented yet...");
                            } else if (c == '4') {
                                System.out.println("not implemented yet...");
                            } else if (c == '5') {
                                if (m.getPetList().size() == 0) {
                                    m.viewPetList();
                                    continue;
                                }
                                m.viewPetList();

                                System.out.println("------------------------------");
                                System.out.println("Type a petID for Check-In");
                                System.out.println("------------------------------");

                                String petID = sc.next();
                                if (m.findByPetID(petID).getPetID() == "0") continue;

                                m.checkIn(m, petID, checkInRepository.getCheckIn_info_list());

                            } else if (c == '6') {
                                if (m.getPetList().size() == 0) {
                                    m.viewPetList();
                                    continue;
                                }
                                if (m.view_checkIn_info(checkInRepository.getCheckIn_info_list(), m)) {

                                    System.out.println("------------------------------");
                                    System.out.println("Type a petID for Check-Out");
                                    System.out.println("------------------------------");

                                    String petID = sc.next();
                                    if (m.findByPetID(petID).getPetID() == "0") continue;

                                    // TODO: check out
                                    m.checkOut(m, petID, checkInRepository.getCheckIn_info_list());

//                                  m.view_checkIn_info(checkInRepository.getCheckIn_info_list(), m);
                                }

                            } else if (c == '7') {

                                m.view_checkIn_info(checkInRepository.getCheckIn_info_list(), m);
                            } else if (c == '8') {
                                m.viewMonitorResult();

                            }
                            else
                                break;
                        }
                    }
                }
            } else break;
        }
    }



//             switch (c){
//                 case '1': check.addMonitortype(MonitorType.Sleep); break;
//                 case '2': check.addMonitortype(MonitorType.Walk); break;
//                 case '3': check.addMonitortype(MonitorType.Eat); break;
//                 case '4': check.addMonitortype(MonitorType.Groom); break;
//                 case '5': check.addMonitortype(MonitorType.Shower); break;
//                 case '6': check.addMonitortype(MonitorType.EarClean); break;
//                 case '7': check.addMonitortype(MonitorType.NailCut); break;
//                 case '0': break;

//             }
//         }while(c != '0');
//     }
//     public static void typeInfo(CheckIn_Info check){
//         Scanner strSc = new Scanner(System.in);
//         String str;
//         System.out.println("Type Start Day (ex: Sat, 02 Apr 2022)");
//         str = strSc.nextLine();
//         check.setStartDate(new Date(str));
//         System.out.println("Type End Day (ex: Sun, 03 Apr 2022)");
//         str = strSc.nextLine();
//         check.setEndDate(new Date(str));

//         System.out.println("Requirement : ");
//         str = strSc.nextLine();

//         check.setRequirement(Arrays.asList(str));
//     }

//     public static void printInfo(CheckIn_Info check){
//         System.out.println("------------------------------");

//         System.out.println("PetID : " + check.getPet().getPetID());
//         System.out.println("PetName : " + check.getPet().getPetName());
//         System.out.println("MonitorType : " + check.getMonitorTypes());
//         System.out.println("Start Day : " + check.getStartDate());
//         System.out.println("End Day : " + check.getEndDate());
//         System.out.println("Your requirement : " + check.getRequirement());
//         System.out.println("Total price : " + check.getPrice());
//         System.out.println("Monitor result : ");
//         check.printMonitorResult();
//     }

}
