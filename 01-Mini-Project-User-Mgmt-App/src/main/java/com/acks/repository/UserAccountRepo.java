package com.acks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acks.entities.UserAccount;

import jakarta.transaction.Transactional;
@Repository
public interface UserAccountRepo extends  JpaRepository<UserAccount, Integer> {
	
	@Transactional
	@Modifying
	@Query("update UserAccount set activeSwitch=:status where userId=:userId")
	public void UpdateUserAccStatus(Integer userId,String status);
	
}
