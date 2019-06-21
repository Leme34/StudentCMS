package com.lee.cms.controller;

import com.alibaba.fastjson.JSON;
import com.lee.cms.entity.Auth;
import com.lee.cms.entity.User;
import com.lee.cms.service.*;
import com.lee.cms.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	AuthService authService;
	@Autowired
	AdminService adminServiceImpl;
	@Autowired
	TeacherService teacherServiceImpl;
	@Autowired
	StudentService studentServiceImpl;
	
	@RequestMapping(value="/loginPage")
	public ModelAndView toLoginPage() {
		return new ModelAndView("login");
	}
	
	@ResponseBody
	@RequestMapping(value="/doLogin")
	public String doLogin(@RequestParam(defaultValue="") String username,
                          @RequestParam(defaultValue="") String password,
                          @RequestParam(defaultValue="0") int userType,
                          @RequestParam(defaultValue="") String verifyCode, HttpSession session) {
		//1、比较验证码
		String sessionVerifyCode = (String) session.getAttribute(StrUtil.VERIFY_CODE);
		if (sessionVerifyCode == null || !sessionVerifyCode.equals(verifyCode.toUpperCase()) ) {
			return StrUtil.CODE_ERROR;
		}
		
		LoginService loginServeice = null;
		if (userType == 1) {
			loginServeice = (LoginService) adminServiceImpl;
		} else if(userType == 2) {
			loginServeice = (LoginService) teacherServiceImpl;
		} else if(userType == 3) {
			loginServeice = (LoginService) studentServiceImpl;
		}
		//2、获得验证后user对象
		User user = loginServeice.loginValidate(username, password.toUpperCase());
		//若登录成功
		if (user != null) {
			//3、获取角色对应的可访问页面
			List<Auth> urlList = authService.getUrlList(user.getUserType());
			user.setUrlList(urlList);
			session.setAttribute(StrUtil.USER, user);
			return JSON.toJSONString(user);
		}
		return StrUtil.RESULT_FALSE;
	}
	
	@RequestMapping(value="/out")
	public ModelAndView loginOut(HttpSession session) {
		//销毁sessions
		session.invalidate();
		//请求重定向到主页（login页）
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/getVerifyCode")
	public void getVerifyCode(HttpServletResponse response, HttpSession session) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		session.setAttribute("verifyCode", drawCodeImg(output));
		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 绘出验证码
	 * @param output
	 * @return
	 */
	private String drawCodeImg(ByteArrayOutputStream output) {
		String code = "";
		for (int i = 0; i < 4; i++) {
			code += randomChar();
		}
		
		int width = 70;
		int height = 36;
		BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		Graphics2D graphics = bImage.createGraphics();
		graphics.setFont(font);
		graphics.setColor(new Color(66,2,82));
		graphics.setBackground(new Color(226,226,240));
		graphics.clearRect(0, 0, width, height);
		FontRenderContext context = graphics.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(code, context);
		double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        graphics.drawString(code, (int) x, (int) baseY);
        graphics.dispose();
        try {
			ImageIO.write(bImage, "jpg", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * 返回一个随机字符
	 * @return
	 */
	private char randomChar() {
		Random r = new Random();
		String str = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
		return str.charAt(r.nextInt(str.length()));
	}
}
