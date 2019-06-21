package com.lee.cms.service;


import com.lee.cms.entity.Admin;

public interface AdminService {
	public Admin selectAdmin(Admin admin);

	public int update(Admin admin);
}
