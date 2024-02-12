package net.cyberaakash.banking.controller;

import net.cyberaakash.banking.dto.AccountDto;
import net.cyberaakash.banking.mapper.AccountMapper;
import net.cyberaakash.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account By ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }


    //Deposit Amount REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw Amount REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Fetch All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllDetails();
        return ResponseEntity.ok(accounts);
    }

    //Delete Account By ID REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }

    //Delete Account By ID REST API
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAll() {
        accountService.deleteAllAccounts();
        return ResponseEntity.ok("All Accounts Deleted Successfully");
    }
}
