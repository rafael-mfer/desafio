package com.springboot.crud.dao.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.crud.RowMapper.RoleDetailRowMapper;
import com.springboot.crud.dao.RoleDetailDao;
import com.springboot.crud.model.Role;

@Repository
public class RoleDetailDaoImpl implements RoleDetailDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Transactional
	public List<Role> findAll() {
		return (List<Role>) jdbcTemplate.query("select * from roles", new RoleDetailRowMapper());

	}
	@Transactional
	public Optional<Role> findById(long idRole) {
		return Optional.of(jdbcTemplate.queryForObject("select * from roles where id_role=?", new Object[] { idRole },
				new RoleDetailRowMapper()));
	}
	
}
