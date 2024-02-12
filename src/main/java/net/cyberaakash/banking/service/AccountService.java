package net.cyberaakash.banking.service;

import net.cyberaakash.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    void deleteAccount(Long id);

    List<AccountDto> getAllDetails();

}
