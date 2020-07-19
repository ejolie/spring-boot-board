package com.ejolie.board.account.dto;

import lombok.Getter;

@Getter
public class AccountCreateResponse {

    private Long id;

    public AccountCreateResponse(Long id) {
        this.id = id;
    }
}
