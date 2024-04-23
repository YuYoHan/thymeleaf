package com.example.mvc.login;

import com.example.mvc.login.domain.member.Member;
import com.example.mvc.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test12!");
        member.setName("테스터");
        memberRepository.save(member);
    }
}
