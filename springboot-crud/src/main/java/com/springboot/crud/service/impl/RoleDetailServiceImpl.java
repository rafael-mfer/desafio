package com.springboot.crud.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.crud.dao.RoleDetailDao;
import com.springboot.crud.model.Role;
import com.springboot.crud.service.RoleDetailService;

@Service
public class RoleDetailServiceImpl implements RoleDetailService {
	
	@Autowired
	private RoleDetailDao RoleDetailDao;
	public List<Role> findAll() {
		return RoleDetailDao.findAll();
	}
	public Optional<Role> findById(long idRole) {
		return RoleDetailDao.findById(idRole);
	}

}