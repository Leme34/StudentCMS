package com.lee.cms.dao;


import com.lee.cms.entity.Course;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface CourseDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

	List<Course> getCourseList(Pagination<Course> page, String searchKey);

	int getTotalItemsCount(String searchKey);

	int deleteInList(List<Integer> list);

	int getTotalItemsCountByTid(String id);

	List<Course> getCourseListByTid(Pagination<Course> page, String id);

	int getTotalItemsCountBySid(int isAll, String searchKey, String id);

	List<Course> getCourseListBySid(Pagination<Course> page, int isAll, String searchKey,
                                    String id);
}