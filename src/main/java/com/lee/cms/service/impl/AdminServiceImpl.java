package com.lee.cms.service.impl;

import com.lee.cms.dao.AdminDao;
import com.lee.cms.entity.Admin;
import com.lee.cms.entity.User;
import com.lee.cms.service.AdminService;
import com.lee.cms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService, LoginService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin selectAdmin(Admin admin) {
		return adminDao.select(admin);
	}

	@Override
	public User loginValidate(String username, String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin = selectAdmin(admin);
		if(admin != null) admin.setUserType("admin");
		return admin;
	}

	@Override
	public int update(Admin admin) {
		return adminDao.updateByPrimaryKeySelective(admin);
	}

}
