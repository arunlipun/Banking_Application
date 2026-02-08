package com.bank.BankingApplication.controller;

import com.bank.BankingApplication.dto.AccountDto;
import com.bank.BankingApplication.service.AccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final  AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add acount rest api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    //get Account Rest
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    //deposite rest api
     @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double>request){
        Double amount = request.get("amount");
       AccountDto  accountDto= accountService.deposit(id, amount);
       return new ResponseEntity<>(accountDto, HttpStatus.OK);

    }

    //withdraw restapi
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double>request){
        Double amount = request.get("amount");
        AccountDto accountDto=accountService.withdraw(id, amount);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }
    //get all accounts
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
       List<AccountDto> accountDtos=accountService.getAllAccounts();
       return new ResponseEntity<>(accountDtos, HttpStatus.OK);
    }

    //delete Account rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted");
    }

}
