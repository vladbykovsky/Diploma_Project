package com.diploma.backend.service;

import com.diploma.backend.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findByLogin(String login);
    List<Account> findByStudentId(int id);
    List<Account> findByRoleId(int id);
    List<Account> findByGroupTitle(String title);
    Account saveAccount(Account account);
    void deleteAccount(int id);
}
