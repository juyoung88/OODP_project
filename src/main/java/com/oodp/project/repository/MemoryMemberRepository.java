package com.oodp.project.repository;

import com.oodp.project.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<String, Member> store = new HashMap<>();


    @Override
    public void showAll() {
        store.forEach((k,v) -> System.out.println("ID = " + k));
    }

    @Override
    public void save(Member member) {
        store.put(member.getMemberID(), member);
    }

    @Override
    public Member findById(String memberID) {
        return store.get(memberID);
    }
}
