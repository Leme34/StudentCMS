package com.lee.cms.service;


import com.lee.cms.entity.User;

public interface LoginService {
	/**
	 * 登录验证方法
	 * @return
	 */
	public User loginValidate(String username, String password);
}
