package com.learn.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MultiHttpSecurityConfig {


    @Configuration
    @Order(1)
    public static class AdminSecurityConfigurationAdaptor extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**")
                    .authorizeRequests(authorize -> authorize
                            .anyRequest()
                            .hasRole("ADMIN")

                    )
                    .httpBasic();
        }
    }

    @Configuration
    @Order(2)
    public static class MemberConfigurationAdaptor extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/member/**")
                    .authorizeRequests(authorize -> authorize
                            .anyRequest()
                            .hasRole("MEMBER")

                    )
                    .httpBasic();
        }
    }

    /*@Configuration
    @Order(3)
    public static class UserConfigurationAdaptor extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")
                    .authorizeRequests(authorize -> authorize
                            .anyRequest()
                            .permitAll()

                    )
                    .httpBasic();
        }
    }*/

}
