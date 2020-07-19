package com.ejolie.board.account.api;

import com.ejolie.board.account.dto.AccountCreateRequest;
import com.ejolie.board.account.dto.AccountCreateResponse;
import com.ejolie.board.account.dto.AccountResponse;
import com.ejolie.board.account.dto.AccountUpdateRequest;
import com.ejolie.board.account.entity.Account;
import com.ejolie.board.account.service.AccountService;
import com.ejolie.board.common.response.BaseResponse;
import com.ejolie.board.common.response.ListResponse;
import com.ejolie.board.common.response.SingleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "계정 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@RestController
public class AccountApiController {

    private final AccountService accountService;

    /**
     * cf. 응답 처리: AOP에서 하는 방식도 존재
     */
    @ApiOperation(value = "계정 목록 조회")
    @GetMapping
    public ListResponse<AccountResponse> getAll() {
        List<AccountResponse> dtos = accountService.findAll().stream()
                .map(AccountResponse::new)
                .collect(Collectors.toList());
        return ListResponse.success(dtos);
    }

    @ApiOperation(value = "계정 조회")
    @GetMapping("/{id}")
    public SingleResponse<AccountResponse> get(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return SingleResponse.success(new AccountResponse(account));
    }

    @ApiOperation(value = "계정 생성")
    @PostMapping
    public SingleResponse<AccountCreateResponse> create(@RequestBody @Valid AccountCreateRequest requestDto) {
        Long id = accountService.save(requestDto);
        return SingleResponse.success(new AccountCreateResponse(id));
    }

    @ApiOperation(value = "계정 수정")
    @PutMapping("/{id}")
    public BaseResponse update(@PathVariable Long id, @RequestBody @Valid AccountUpdateRequest requestDto) {
        accountService.update(id, requestDto);
        return BaseResponse.success();
    }

    @ApiOperation(value = "계정 삭제")
    @DeleteMapping("/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        accountService.delete(id);
        return BaseResponse.success();
    }
}
