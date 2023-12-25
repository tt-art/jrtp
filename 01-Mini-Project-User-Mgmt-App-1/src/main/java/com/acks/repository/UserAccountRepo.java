package com.acks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.acks.entity.UserAccount;

import jakarta.transaction.Transactional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
	@Modifying
	@Transactional
	@Query("update UserAccount set activeSw=:status where userId=:userId")
	public void updateUserAccStatus(Integer userId,String status);
	
	@Modifying
	@Transactional
	@Query(" from UserAccount where activeSw=:status")
	public List<UserAccount> filterActiveUsers(String status);
//	@Modifying
//	@Transactional
	@Query(" from UserAccount where activeSw=:status")
	public List<UserAccount> filterDeActiveUsers(String status);
	

}
