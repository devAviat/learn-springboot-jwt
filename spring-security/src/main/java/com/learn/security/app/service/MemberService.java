package com.learn.security.app.service;

import com.learn.security.app.entity.Member;
import com.learn.security.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.learn.security.app.entity.Member.*;
import static com.learn.security.app.entity.Member.Role.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void login(String name, String password) {

        Member member = this.checkMember(name, password);
    }

    public Member checkMember(String name, String password) {
        return memberRepository.findByName(name);
    }

    @Transactional
    public Long createMember(String name, String password) {

        log.info("MemberService");
        log.info("name :: {}", name);
        log.info("password :: {}", password);

        Member buildMember = builder()
                .name(name)
                .password(password)
                .role(MEMBER)
                .build();
        log.info("buildMember :: {}", buildMember);

        Member saveMember = memberRepository.save(buildMember);
        log.info("saveMember :: {}", saveMember);

        return saveMember.getMember_id();
    }
}
