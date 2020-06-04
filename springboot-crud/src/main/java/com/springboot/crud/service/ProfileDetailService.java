package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;
import com.springboot.crud.model.Profile;

public interface ProfileDetailService {
	public List<Profile> findAll();
	public Optional<Profile> findById(long id);
}
