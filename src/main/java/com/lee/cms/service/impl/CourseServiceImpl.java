package com.lee.cms.service.impl;

import com.lee.cms.dao.CourseDao;
import com.lee.cms.entity.Course;
import com.lee.cms.service.CourseService;
import com.lee.cms.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public int getTotalItemsCount(String searchKey) {
		return courseDao.getTotalItemsCount(searchKey);
	}

	@Override
	public List<Course> getCourseList(Pagination<Course> page, String searchKey) {
		return courseDao.getCourseList(page, searchKey);
	}

	@Override
	public int addCourse(Course course) {
		if (course.getStartDate() != null && course.getStartDate().equals("")) {
			course.setStartDate(null);
		}
		if (course.getEndDate() != null && course.getEndDate().equals("")) {
			course.setEndDate(null);
		}
		return courseDao.insertSelective(course);
	}

	@Override
	public int updateCourse(Course course) {
		return courseDao.updateByPrimaryKeySelective(course);
	}

	@Override
	public int deleteCourse(Course c) {
		return courseDao.deleteByPrimaryKey(c.getId());
	}

	@Override
	public int deleteCourse(List<Integer> list) {
		return courseDao.deleteInList(list);
	}

	@Override
	public int getTotalItemsCountByTid(String id) {
		return courseDao.getTotalItemsCountByTid(id);
	}

	@Override
	public List<Course> getCourseListByTid(Pagination<Course> page, String id) {
		return courseDao.getCourseListByTid(page, id);
	}

	@Override
	public int getTotalItemsCountBySid(int isAll, String searchKey, String id) {
		return courseDao.getTotalItemsCountBySid(isAll, searchKey, id);
	}

	@Override
	public List<Course> getCourseListBySid(Pagination<Course> page, int isAll, 
			String searchKey, String id) {
		return courseDao.getCourseListBySid(page, isAll, searchKey, id);
	}

	@Override
	public int completeCourse(Course course) {
		Course c = new Course();
		c.setId(course.getId());
		c.setComplete(1);
		return courseDao.updateByPrimaryKeySelective(c);
	}
}
