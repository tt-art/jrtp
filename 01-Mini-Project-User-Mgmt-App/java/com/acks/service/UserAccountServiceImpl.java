package com.acks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acks.entities.UserAccount;
import com.acks.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepo userAccRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		// TODO Auto-generated method stub

		Integer userId = userAcc.getUserId();

//		Upsert(insert or update)
		userAccRepo.save(userAcc);
		if (userId == null) {
			return "user record saved";
		} else {
			return "user record updated";
		}

//		return null;
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		// TODO Auto-generated method stub
		return userAccRepo.findAll();

//		return null;
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		// TODO Auto-generated method stub

		Optional<UserAccount> findById = userAccRepo.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub

		boolean existsById = userAccRepo.existsById(userId);
		if (existsById) {
			userAccRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		// TODO Auto-generated method stub
		try {
			userAccRepo.UpdateUserAccStatus(userId, status);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}