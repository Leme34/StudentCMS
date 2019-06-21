package com.lee.cms.service;


import com.lee.cms.entity.Auth;
import com.lee.cms.utils.page.Pagination;

import java.util.List;


public interface AuthService {

	List<Auth> getMenuList(String userType);

	List<Auth> getUrlList(String userType);

	int getTotalItemsCount(String searchKey);

	List<Auth> getAuthList(Pagination<Auth> page, String searchKey);

	int update(Auth auth);

}
