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

    /**
     * 0.로그인 인증이 끝난 메인화면
     *
     * @return
     */
    @GetMapping("/main")
    public String user_main() {
        return "/main";
    }

    /**
     * 1-1로그인 폼
     *
     * @return
     */
    @GetMapping("/login-form")
    public String login_form() {
        return "loginForm";
    }

    /**
     * 1-2로그인 실행
     *
     * @return
     */
    @PostMapping("/login-action")
    public String login_action(@RequestParam("id") String id,
                               @RequestParam("password") String password) {

        //memberService.login(id, password);
        Member member = memberService.findMember(id, password);
        return "redirect:/member/main";
    }

    /**
     * 1-3회원가입처리
     *
     * @param id
     * @param password
     * @return
     */
    @PostMapping("/signIn")
    public String signIn(@RequestParam("id") String id,
                         @RequestParam("password") String password) {
        log.info("init Controller");
        log.info("id  ::{}", id);
        log.info("password  ::{}", password);

        Long member = memberService.createMember(id, password);
        return null;
    }


}
