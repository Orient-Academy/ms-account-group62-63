package az.edu.orient.controller;

import az.edu.orient.dto.AccountDto;
import az.edu.orient.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto request) {
        return accountService.createAccount(request);
    }

    @GetMapping
    public List<AccountDto> getAllAccounts() {
        return null;
    }

    @GetMapping(path = "{id}")
    public AccountDto getAccountById(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping(path = "{id}")
    public void deleteAccountById(@PathVariable Long id) {

    }

    @PutMapping(path = "{id}")
    public AccountDto updateAccount(@PathVariable Long id, @RequestBody AccountDto request) {
        return null;
    }

    @PatchMapping(path = "{id}/status")
    public AccountDto updateAccountStatus(@RequestBody AccountDto request) {
        return null;
    }
}
