package com.acks.service;

import java.util.List;

import com.acks.entities.UserAccount;

public interface UserAccountService {
public String saveOrUpdateUserAcc(UserAccount userAcc);
public List<UserAccount> getAllUserAccounts();
public UserAccount getUserAcc(Integer userId);
public boolean deleteUser(Integer userId);
public boolean updateUserAccStatus(Integer userId,String status);
 
}
