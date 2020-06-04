package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;
import com.springboot.crud.model.Role;

public interface RoleDetailService {
	public List<Role> findAll();
	public Optional<Role> findById(long idRole);
}
