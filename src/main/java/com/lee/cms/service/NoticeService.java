package com.lee.cms.service;


import com.lee.cms.entity.Notice;
import com.lee.cms.entity.Student;
import com.lee.cms.utils.page.Pagination;

import java.util.List;

public interface NoticeService {

	int getTotalItemsCount(Integer authA, String searchKey);

	List<Notice> getNoticeList(Pagination<Student> page, Integer auth,
							   String searchKey);

	int deleteNotice(Notice notice);

	int deleteNotice(List<Integer> list);

	int addNotice(Notice notice);

	int updateNotice(Notice notice);

	Notice getNotice(Integer nId);
	
}
