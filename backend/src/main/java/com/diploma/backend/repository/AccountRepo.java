package com.diploma.backend.repository;

import com.diploma.backend.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {
    List<Account> findAll();
    Account findByLogin(String login);
    List<Account> findByStudentByStudentId_Id(int id);
    List<Account> findByRoleByRoleId_Id(int id);
    List<Account> findByStudentByStudentId_StudentGroupByGroupId_Title(String title);
}
