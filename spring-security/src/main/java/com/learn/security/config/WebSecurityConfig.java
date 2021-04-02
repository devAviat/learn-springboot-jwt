package com.learn.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // HttpSecurity
    // 사용자별 s인증 방식을 다르게 할수 있다. 폼 수정도 마찬가지로.
    // 폼 로그인을 스프링 시큐리티에서 제공해주는 방식이 아니라 사용자 커스텀 페이조로 인증할수 있다.
    // 사용자가 HTTP 기존 인증할 수 있다.
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
    }

}
