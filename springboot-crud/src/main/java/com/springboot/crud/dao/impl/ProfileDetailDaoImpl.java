package com.springboot.crud.dao.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.crud.RowMapper.ProfileDetailRowMapper;
import com.springboot.crud.dao.ProfileDetailDao;
import com.springboot.crud.model.Profile;

@Repository
public class ProfileDetailDaoImpl implements ProfileDetailDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Transactional
	public List<Profile> findAll() {
		return (List<Profile>) jdbcTemplate.query("select * from profiles", new ProfileDetailRowMapper());

	}
	@Transactional
	public Optional<Profile> findById(long idProfile) {
		return Optional.of(jdbcTemplate.queryForObject("select * from profiles where id_profile=?", new Object[] { idProfile },
				new ProfileDetailRowMapper()));
	}
	
}
