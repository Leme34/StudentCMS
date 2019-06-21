package com.lee.cms.dao;


import com.lee.cms.entity.Auth;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface AuthDao {
	
	List<Auth> selectUrl(String userType);
	
	List<Auth> selectMenu(String userType);
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(Auth record);

    int insertSelective(Auth record);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

	int getTotalItemsCount(String searchKey);

	List<Auth> getAuthList(Pagination<Auth> page, String searchKey);
}