package com.springboot.crud.dao;

import java.util.List;
import java.util.Optional;
import com.springboot.crud.model.Profile;

public interface ProfileDetailDao {
	public List<Profile> findAll();
	public Optional<Profile> findById(long id);
}
