package com.example.demo_account.service;

import com.example.demo_account.dto.AccountDto;
import com.example.demo_account.dto.AccountDtoConverter;
import com.example.demo_account.dto.CreateAccountRequest;
import com.example.demo_account.model.Account;
import com.example.demo_account.model.Customer;
import com.example.demo_account.model.Transaction;
import com.example.demo_account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;


    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          AccountDtoConverter converter){
        this.accountRepository = accountRepository;
        this.customerService = customerService;

        this.converter = converter;
    }
    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    LocalDateTime.now(),
                    account);

            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }


}
