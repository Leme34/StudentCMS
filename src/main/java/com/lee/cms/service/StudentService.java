package com.lee.cms.service;

import com.lee.cms.entity.Student;
import com.lee.cms.utils.page.Pagination;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface StudentService {

	int getTotalItemsCount(String searchKey);

	List<Student> getStudentList(Pagination<Student> page, String searchKey);

	Student selectStudent(Student stu);

	int addStudent(Student stu) throws Exception;

	int updateStudent(Student stu);
	
	int deleteStudent(Student stu);
	
	int deleteStudent(List<String> ids);

	int importExcelInfo(InputStream in, MultipartFile file) throws Exception;

	int getTotalItemsCountByTid(String id, Integer cId);

	List<Student> getStudentListByTid(Pagination<Student> page, String tid,
                                      Integer cId);

}
