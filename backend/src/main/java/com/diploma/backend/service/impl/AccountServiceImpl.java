package com.diploma.backend.service.impl;

import com.diploma.backend.entity.Account;
import com.diploma.backend.repository.AccountRepo;
import com.diploma.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("customUserDetailsService")
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = findByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(account.getLogin(), account.getPassword(), getAuthority(account));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Account account) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + account.getRoleByRoleId().getTitle().toUpperCase()));
        return authorities;
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account findByLogin(String login) {
        return accountRepo.findByLogin(login);
    }

    @Override
    public List<Account> findByStudentId(int id) {
        return accountRepo.findByStudentByStudentId_Id(id);
    }

    @Override
    public List<Account> findByRoleId(int id) {
        return accountRepo.findByRoleByRoleId_Id(id);
    }

    @Override
    public List<Account> findByGroupTitle(String title) {
        return null;
    }

    @Override
    public Account saveAccount(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepo.deleteById(id);
    }

}
