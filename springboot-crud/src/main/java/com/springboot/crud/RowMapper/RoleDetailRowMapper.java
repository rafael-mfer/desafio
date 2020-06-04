package com.springboot.crud.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springboot.crud.model.Role;;

public class RoleDetailRowMapper implements RowMapper<Role> {
	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setIdRole(rs.getLong("id_role"));
		role.setRole(rs.getString("role"));
		return role;
	}

}
