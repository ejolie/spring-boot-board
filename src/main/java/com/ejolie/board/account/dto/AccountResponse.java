package com.ejolie.board.account.dto;

import com.ejolie.board.account.entity.Account;
import lombok.Getter;

@Getter
public class AccountResponse {

    private String userId;
    private String userName;
    private String email;
    private String phone;

    public AccountResponse(Account entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
    }
}