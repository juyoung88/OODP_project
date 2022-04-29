package com.oodp.project.repository;

import com.oodp.project.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(String memberID);
    void showAll();
}
