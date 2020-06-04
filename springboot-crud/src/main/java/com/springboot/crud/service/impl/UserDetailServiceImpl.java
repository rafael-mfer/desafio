package com.springboot.crud.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.crud.dao.UserDetailDao;
import com.springboot.crud.model.User;
import com.springboot.crud.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserDetailDao userDetailDao;
	public List<User> findAll() {
		return userDetailDao.findAll();
	}
	public Optional<User> findById(long id) {
		return userDetailDao.findById(id);
	}
	@Override
	public int deleteById(long id) {
		return userDetailDao.deleteById(id);
	}
	@Override
	public int insert(User user) {
		return userDetailDao.insert(user);
	}
	@Override
	public int update(User user) {
		return userDetailDao.update(user);
	}
	public UserDetailDao getUserDetailDao() { //PQ?
		return userDetailDao;
	}
}