package com.ejolie.board.account.dto;

import com.ejolie.board.account.entity.Account;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
public class AccountCreateRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @Builder
    public AccountCreateRequest(String userId, String userName, String password, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Account toEntity() {
        return Account.builder()
                .userId(userId)
                .userName(userName)
                .password(password)
                .email(email)
                .phone(phone)
                .build();
    }
}