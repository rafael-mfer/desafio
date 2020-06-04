package com.springboot.crud.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.crud.dao.ProfileDetailDao;
import com.springboot.crud.model.Profile;
import com.springboot.crud.service.ProfileDetailService;

@Service
public class ProfileDetailServiceImpl implements ProfileDetailService {
	
	@Autowired
	private ProfileDetailDao ProfileDetailDao;
	public List<Profile> findAll() {
		return ProfileDetailDao.findAll();
	}
	public Optional<Profile> findById(long idProfile) {
		return ProfileDetailDao.findById(idProfile);
	}

}