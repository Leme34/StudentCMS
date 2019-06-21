package com.lee.cms.service.impl;

import com.lee.cms.dao.NoticeDao;
import com.lee.cms.entity.Notice;
import com.lee.cms.entity.Student;
import com.lee.cms.service.NoticeService;
import com.lee.cms.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public int getTotalItemsCount(Integer authA, String searchKey) {
		return noticeDao.getTotalItemsCount(authA, searchKey);
	}

	@Override
	public List<Notice> getNoticeList(Pagination<Student> page, Integer auth,
									  String searchKey) {
		return noticeDao.getNotice(page, auth, searchKey);
	}

	@Override
	public int deleteNotice(Notice notice) {
		return noticeDao.deleteByPrimaryKey(notice.getId());
	}

	@Override
	public int deleteNotice(List<Integer> list) {
		return noticeDao.deleteBatch(list);
	}

	@Override
	public int addNotice(Notice notice) {
		return noticeDao.insert(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.updateByPrimaryKeySelective(notice);
	}

	@Override
	public Notice getNotice(Integer nId) {
		return noticeDao.selectByPrimaryKey(nId);
	}

}
