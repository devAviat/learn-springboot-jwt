package com.learn.security.app.controller;

import com.learn.security.app.entity.Member;
import com.learn.security.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static lombok.AccessLevel.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor(access = PROTECTED)
@Slf4j
public class MemberController {

    private final MemberService memberService;


    //메인
    @GetMapping("/main")
    public String user_main() {
        return "/login/main";
    }

    //등록폼
    @GetMapping("/login")
    public String login_form() {
        return "login/register";
    }

    //로그인처리
    @PostMapping("/login")
    public String login_action(@RequestParam("id") String id,
                               @RequestParam("password") String password) {

        Member member = memberService.checkMember(id, password);
        return "redirect:/member/main";
    }


    //등록처리
    @PostMapping("/sign-in")
    public String signIn(@RequestParam("name") String name,
                         @RequestParam("password") String password) {
        log.info("init Controller");
        log.info("name  ::{}", name);
        log.info("password  ::{}", password);

        Long member = memberService.createMember(name, password);
        return "redirect:/member/main";
    }
}
