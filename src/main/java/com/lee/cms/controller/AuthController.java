package com.lee.cms.controller;

import com.alibaba.fastjson.JSON;
import com.lee.cms.entity.Auth;
import com.lee.cms.service.AuthService;
import com.lee.cms.utils.StrUtil;
import com.lee.cms.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@ResponseBody
	@RequestMapping(value="/list")
	public String getAuthList(@RequestParam(defaultValue="0")int curr, @RequestParam(defaultValue="10")int nums,
                              @RequestParam(defaultValue="")String searchKey) {
		Pagination<Auth> page = new Pagination<Auth>();
		page.setTotalItemsCount(authService.getTotalItemsCount(searchKey));
		page.setPageSize(nums);
		page.setPageNum(curr);
		List<Auth> list = authService.getAuthList(page, searchKey);
		
		String jsonStr = StrUtil.RETURN_JONS_PRE_STR + page.getTotalItemsCount()
				+ StrUtil.RETURN_JONS_MID_STR
				+ JSON.toJSONString(list) + StrUtil.RETURN_JONS_END_STR;
		
		return jsonStr;
	}
	
	@ResponseBody
	@RequestMapping(value="/setting")
	public String setting(Auth auth, String type, Byte val) {
		if ("teacherAuth".equals(type)) {
			auth.setTeacherAuth(val);
		} else {
			auth.setStudentAuth(val);
		}
		System.out.println(auth.toString());
		if (authService.update(auth) > 0) return StrUtil.RESULT_TRUE;
		return "操作失败！";
	}
	
	
}
