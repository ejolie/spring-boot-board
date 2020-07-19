package com.ejolie.board.account.service;

import com.ejolie.board.account.dto.AccountCreateRequest;
import com.ejolie.board.account.dto.AccountUpdateRequest;
import com.ejolie.board.account.entity.Account;
import com.ejolie.board.account.repository.AccountRepository;
import com.ejolie.board.common.exception.BusinessException;
import com.ejolie.board.common.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new BusinessException(StatusCode.ACCOUNT_NOT_FOUND));
    }

    public Account findByUserId(String userId) {
        return accountRepository.findByUserId(userId).orElseThrow(() -> new BusinessException(StatusCode.ACCOUNT_NOT_FOUND));
    }

    @Transactional
    public Long save(AccountCreateRequest requestDto) {
        if (validateDuplicateUserId(requestDto.getUserId())) {
            throw new BusinessException(StatusCode.ACCOUNT_DUPLICATED);
        }
        /**
         * 궁금점: DTO가 서비스 안으로 들어와도 될까?
         * - Entity는 밖으로 X / DTO는 OK?
         * cf. VO 처리
         */
        return accountRepository.save(requestDto.toEntity()).getId();
    }

    private boolean validateDuplicateUserId(String userId) {
        return accountRepository.findByUserId(userId).isPresent();
    }

    @Transactional
    public void update(Long id, AccountUpdateRequest requestDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new BusinessException(StatusCode.ACCOUNT_NOT_FOUND));
        account.update(requestDto.getUserName(), requestDto.getPassword(), requestDto.getEmail(), requestDto.getPhone());
    }

    @Transactional
    public void delete(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new BusinessException(StatusCode.ACCOUNT_NOT_FOUND));
        accountRepository.delete(account);
    }
}
