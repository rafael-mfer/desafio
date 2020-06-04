package com.springboot.crud.dao;

import java.util.List;
import java.util.Optional;
import com.springboot.crud.model.User;

public interface UserDetailDao {
	public List<User> findAll();
	public Optional<User> findById(long id); //Optional e List?
	public int deleteById(long id);
	public int insert(User user);
	public int update(User user);
}
