package com.lee.cms.service.impl;

import com.lee.cms.dao.AuthDao;
import com.lee.cms.entity.Auth;
import com.lee.cms.service.AuthService;
import com.lee.cms.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDao authDao;
	
	
	@Override
	public List<Auth> getMenuList(String userType) {
		return authDao.selectMenu(userType);
	}

	@Override
	public List<Auth> getUrlList(String userType) {
		return authDao.selectUrl(userType);
	}

	@Override
	public int getTotalItemsCount(String searchKey) {
		return authDao.getTotalItemsCount(searchKey);
	}

	@Override
	public List<Auth> getAuthList(Pagination<Auth> page,
								  String searchKey) {
		return authDao.getAuthList(page,searchKey);
	}

	@Override
	public int update(Auth auth) {
		return authDao.updateByPrimaryKeySelective(auth);
	}

}
