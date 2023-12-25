package com.acks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acks.entity.UserAccount;
import com.acks.repository.UserAccountRepo;
@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountRepo userAccRepo;
	

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		// TODO Auto-generated method stub
		Integer userId = userAcc.getUserId();
		userAccRepo.save(userAcc);
		if(userId==null) {
			return "User Record Saved";
		}
		else {
			return "User Record Updated";
			
		}
		
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		// TODO Auto-generated method stub
//		List<UserAccount> findAll = userAccRepo.findAll();
		
		return userAccRepo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		// TODO Auto-generated method stub
		Optional<UserAccount> findById = userAccRepo.findById(userId);
		if(findById.isPresent()) {
			return	findById.get();
		}
		return null   ;
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		// TODO Auto-generated method stub
		boolean existsById = userAccRepo.existsById(userId);
		if(existsById) {
			userAccRepo.deleteById(userId);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		// TODO Auto-generated method stub
		try {
		 userAccRepo.updateUserAccStatus(userId, status);	
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public List<UserAccount> filterActiveUsers(String status) {
		// TODO Auto-generated method stub
		
		List<UserAccount> filterActiveUsers = userAccRepo.filterActiveUsers(status);
		
		return filterActiveUsers;
	}

	@Override
	public List<UserAccount> filterDeActiveUsers(String status) {
		// TODO Auto-generated method stub
		List<UserAccount> filterDeActiveUsers = userAccRepo.filterDeActiveUsers(status);
		
//		return null;
		return filterDeActiveUsers;
	}
	
	
	

}
