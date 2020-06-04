package com.springboot.crud.dao.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.crud.RowMapper.UserDetailRowMapper;
import com.springboot.crud.dao.UserDetailDao;
import com.springboot.crud.model.User;

@Repository
public class UserDetailDaoImpl implements UserDetailDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Transactional
	public List<User> findAll() {
		return (List<User>) jdbcTemplate.query("select * from users", new UserDetailRowMapper());

	}
	@Transactional
	public Optional<User> findById(long id) {
		return Optional.of(jdbcTemplate.queryForObject("select * from users where id_user=?", new Object[] { id },
				new UserDetailRowMapper()));
	}
	@Transactional
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from users where id_user=?", new Object[] { id });
	}
	@Transactional
	public int insert(User user) {
		return jdbcTemplate.update("insert into users (name, cpf, birth_date, id_role, id_profile) " + "values(?, ?, ?, ?, ?)",
				new Object[] { user.getName(), user.getCpf(), user.getBirthDate(), user.getIdRole(), user.getIdProfile() });
	}
	@Transactional
	public int update(User user) {
		return jdbcTemplate.update("update users " + " set name = ?, cpf = ?, birth_date = ?, id_role = ?, id_profile = ? where id_user = ?",
				new Object[] { user.getName(), user.getCpf(), user.getBirthDate(), user.getIdRole(), user.getIdProfile(), user.getId()});
	}

}
