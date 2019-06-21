package com.lee.cms.dao;


import com.lee.cms.entity.Teacher;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface TeacherDao {
	
    int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

	Teacher selectTeacher(Teacher teacher);

	int getTotalItemsCount(String searchKey);

	int deleteInList(List<String> list);

	int insertBatch(List<Teacher> list);

	List<Teacher> getTeacher(Pagination<Teacher> page, String searchKey);

	List<Teacher> getTeacherForSelect(String searchKey);

}