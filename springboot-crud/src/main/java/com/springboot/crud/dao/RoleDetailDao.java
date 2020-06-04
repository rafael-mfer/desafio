package com.springboot.crud.dao;

import java.util.List;
import java.util.Optional;
import com.springboot.crud.model.Role;

public interface RoleDetailDao {
	public List<Role> findAll();
	public Optional<Role> findById(long id);
}
