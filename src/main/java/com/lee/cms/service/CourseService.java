package com.lee.cms.service;


import com.lee.cms.entity.Course;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface CourseService {

	int getTotalItemsCount(String searchKey);

	List<Course> getCourseList(Pagination<Course> page, String searchKey);

	int addCourse(Course course);

	int updateCourse(Course course);

	int deleteCourse(Course c);

	int deleteCourse(List<Integer> list);

	int getTotalItemsCountByTid(String id);

	List<Course> getCourseListByTid(Pagination<Course> page, String id);

	// 查询该学生可选课程的记录数，用于分页
	int getTotalItemsCountBySid(int isAll, String searchKey, String id);

	List<Course> getCourseListBySid(Pagination<Course> page, int isAll, String searchKey,
                                    String id);

	int completeCourse(Course course);
}
