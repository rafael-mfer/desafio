package com.springboot.crud.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springboot.crud.model.User;;

public class UserDetailRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id_user"));
		user.setName(rs.getString("name"));
		user.setCpf(rs.getString("cpf"));
		user.setBirthDate(rs.getDate("birth_date"));
		user.setIdRole(rs.getLong("id_role"));
		user.setIdProfile(rs.getLong("id_profile"));
		return user;
	}

}
