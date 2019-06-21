package com.lee.cms.controller;

import com.lee.cms.entity.Admin;
import com.lee.cms.entity.Student;
import com.lee.cms.entity.Teacher;
import com.lee.cms.entity.User;
import com.lee.cms.service.AdminService;
import com.lee.cms.service.StudentService;
import com.lee.cms.service.TeacherService;
import com.lee.cms.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/pswd")
public class PasswordController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/page")
	public ModelAndView toPswdPage(ModelAndView mav) {
		mav = new ModelAndView("changePwd");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/setting")
	public String setting(HttpSession session, String oldPswd, String newPswd) {
		oldPswd = oldPswd.toUpperCase();
		newPswd = newPswd.toUpperCase();
		User user = (User) session.getAttribute(StrUtil.USER);
		int res = 0;
		if (StrUtil.ADMIN.equals(user.getUserType())) {
			Admin admin = (Admin)user;
			if(admin.getPassword().equals(oldPswd)) {
				admin.setPassword(newPswd);
				session.setAttribute(StrUtil.USER, admin);
				res = adminService.update(admin);
				if (res > 0) return StrUtil.RESULT_TRUE;
			} else {
				return "密码错误！";
			}
		} else if (StrUtil.TEACHER.equals(user.getUserType())) {
			Teacher t = (Teacher)user;
			if(t.getPassword().equals(oldPswd)) {
				t.setPassword(newPswd);
				res = teacherService.updateTeacher(t);
				if (res > 0) return StrUtil.RESULT_TRUE;
			} else {
				return "密码错误！";
			}
		} else {
			Student stu = (Student)user;
			if(stu.getPassword().equals(oldPswd)) {
				stu.setPassword(newPswd);
				res = studentService.updateStudent(stu);
				if (res > 0) return StrUtil.RESULT_TRUE;
			} else {
				return "密码错误！";
			}
		}
		return "操作失败！";
	}
	
}
