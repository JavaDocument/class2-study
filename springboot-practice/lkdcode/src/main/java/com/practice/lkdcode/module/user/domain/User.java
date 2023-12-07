package com.practice.lkdcode.module.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.practice.lkdcode.global.common.BaseEntity;
import com.practice.lkdcode.module.user.domain.status.UserStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_user")
public class User extends BaseEntity {
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;


    @Builder
    public User(String email, String password, UserStatus userStatus) {
        this.email = email;
        this.password = password;
        this.userStatus = userStatus == null ? UserStatus.CREATED : userStatus;
    }

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.userStatus = UserStatus.CREATED;
    }
}
