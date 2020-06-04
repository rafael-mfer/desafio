package com.springboot.crud.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springboot.crud.model.Profile;;

public class ProfileDetailRowMapper implements RowMapper<Profile> {
	@Override
	public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
		Profile profile = new Profile();
		profile.setIdProfile(rs.getLong("id_profile"));
		profile.setProfile(rs.getString("profile"));
		return profile;
	}

}
