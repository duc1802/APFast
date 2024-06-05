package com.example.apfast.service;



import com.example.apfast.model.Member;
import com.example.apfast.repository.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;

    public Optional<Member> findByUserId(String userId) {
        return memberDAO.findById(userId);
    }

    public void addMember(Member member) {
        memberDAO.save(member);
    }

    public void updateMember(Member member) {
        memberDAO.save(member);
    }

    public void deleteMember(String userId) {
        memberDAO.deleteById(userId);
    }

    public Member getMemberById(String userId) {
        return memberDAO.findById(userId).orElse(null);
    }

    public List<Member> getAllMembers() {
        return memberDAO.findAll();
    }
}
