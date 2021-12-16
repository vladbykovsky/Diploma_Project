package com.diploma.backend.controller;

import com.diploma.backend.entity.Account;
import com.diploma.backend.entity.Teacher;
import com.diploma.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountByLogin(@PathVariable(name = "login") String login) {
        Account account = accountService.findByLogin(login);
        return ResponseEntity.ok(account);
    }

    @RequestMapping(value = "/studentId/{id}", method = RequestMethod.GET)
    public List<Account> getAccountByStudentId(@PathVariable(name = "id") int id) {;
        return accountService.findByStudentId(id);
    }

    @RequestMapping(value = "/roleId/{id}", method = RequestMethod.GET)
    public List<Account> getAccountByRoleId(@PathVariable(name = "id") int id) {;
        return accountService.findByRoleId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }
}
