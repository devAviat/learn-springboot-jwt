package com.learn.security.app.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {


    @Id
    @GeneratedValue
    private Long member_id;

    private String name;
    private String password;
    private Role role;

    @Builder
    public Member(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public enum Role {
        USER, ADMIN, MEMBER
    }
}