package com.bank.BankingApplication.service.impl;

import com.bank.BankingApplication.dto.AccountDto;
import com.bank.BankingApplication.entity.Account;
import com.bank.BankingApplication.mapper.AccountMapper;
import com.bank.BankingApplication.repository.AccountRepository;
import com.bank.BankingApplication.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
       Account savedAccount= accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
    Account account=    accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesnot Exist"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {

        Account account=    accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesnot Exist"));

       double total= account.getBalance()+amount;
       account.setBalance(total);
      Account savedAccount= accountRepository.save(account);

       return  AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {

        Account account=    accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account Doesnot Exist"));
        if(account.getBalance()<0){
            throw new RuntimeException("Insufficient Balance");

        }

        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
       List<Account> accounts= accountRepository.findAll();

        return accounts.stream().map(AccountMapper::mapToAccountDto)
               .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account=    accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Doesnot Exist"));

        accountRepository.deleteById(  id);
    }
}
