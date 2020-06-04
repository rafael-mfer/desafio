package com.springboot.crud.model;

public class Profile {
	private long idProfile;
	private String Profile;

	public Profile(long idProfile, String profile) {
		this.idProfile = idProfile;
		Profile = profile;
	}
	
	public Profile() {
		
	}

	public long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(long idProfile) {
		this.idProfile = idProfile;
	}

	public String getProfile() {
		return Profile;
	}

	public void setProfile(String profile) {
		Profile = profile;
	}

}
