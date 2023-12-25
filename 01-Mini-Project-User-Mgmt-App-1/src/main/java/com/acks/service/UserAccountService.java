package com.acks.service;

import java.util.List;

import com.acks.entity.UserAccount;

public interface UserAccountService {

	public String saveOrUpdateUserAcc(UserAccount userAcc);
	public List<UserAccount> getAllUserAccounts();
	public UserAccount getUserAcc(Integer userId);
	public boolean deleteUserAcc(Integer userId);
	public boolean updateUserAccStatus(Integer userId,String status);
	public List<UserAccount> filterActiveUsers(String status);
	public List<UserAccount> filterDeActiveUsers(String status);
	
}
