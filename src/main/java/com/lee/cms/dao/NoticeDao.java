package com.lee.cms.dao;


import com.lee.cms.entity.Notice;
import com.lee.cms.entity.Student;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface NoticeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

	int deleteBatch(List<Integer> list);

	List<Notice> getNotice(Pagination<Student> page, Integer auth,
                           String searchKey);

	int getTotalItemsCount(Integer authA, String searchKey);
}