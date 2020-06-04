package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;
import com.springboot.crud.model.User;

public interface UserDetailService {
	public List<User> findAll();
	public Optional<User> findById(long id);
	public int deleteById(long id);
	public int insert(User user);
	public int update(User user);
}
