package com.lee.cms.dao;


import com.lee.cms.entity.Admin;

public interface AdminDao {
	public Admin select(Admin admin);

	public int updateByPrimaryKeySelective(Admin admin);
}