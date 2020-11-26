package com.ibm.springboot.restcontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.springboot.entity.CommonResult;
import com.ibm.springboot.entity.User;
import com.ibm.springboot.service.UserService;
import com.ibm.springboot.util.UserDataUtil;

@RestController
@CrossOrigin
//@CrossOrigin(allowCredentials = "true")
public class UserController {

	@Autowired
	private UserService userService;

	// 注册新用户
	@PostMapping("/register/user")
	public int insertUser(User user) {

		// 注册前要先判断用户是否存在，查询出所有的用户ID进行判断
		List<User> list = userService.selectAll();
		for (User user2 : list) {
			if (user2.getLoginID().equals(user.getLoginID())) {
				// 该用户ID已经被使用过了
				System.out.println("注册失败，用户ID已经被使用过了");
				return -1;
			}
		}

		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");// 设置日期格式
			user.setRegisteDate(df.parse(df.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int insert = userService.insert(user);

		System.out.println("用户成功注册");

		return insert;

	}

	// 查询所有的用户
	@RequestMapping("/selectAll/user")
	public List<User> selectAll(HttpServletResponse response,
			@RequestParam(required = false, value = "loginID") String loginID) {
		if (loginID == null) {
			List<User> list = userService.selectAll();
			return list;
		} else {
			List<User> list = userService.selectAllBesideLoginID(loginID);
			return list;
		}

	}

	// 修改个人信息
	@PutMapping("/update/user")
	public int update(@RequestBody Map<String, String> map) {
		// 前端传输一个Map过来，将map中的值取出，并创建User
		String loginID = map.get("loginID");
		String username = map.get("username");
		String email = map.get("email");
		String password = map.get("password");

		User user = new User(loginID, username, email, password);

		int update = userService.update(user);

		return update;
	}

	// 根据用户姓名查询用户
	@GetMapping("/selectByName/{name}")
	List<User> selectByName(@PathVariable("name") String name) {
		// 可能存在同名的用户，所以用 List 接收
		List<User> list = userService.selectByName(name);
		return list;
	}

	// 根据用户ID或者用户姓名查询用户信息 --- 管理员用户的模糊查询
	@RequestMapping("/selectUser")
	@CrossOrigin(origins = "http://192.168.3.30:8080", maxAge = 3600, allowCredentials = "true")
	List<User> selectUser(@RequestParam(value = "loginID", required = false) String loginID,
			@RequestParam(value = "username", required = false) String username) {

		System.out.println("loginID的值为：" + loginID);
		System.out.println("username的值为：" + username);

		User user = new User(loginID, username);

		List<User> list = userService.selectUser(user);

		for (User user2 : list) {
			System.out.println(user2);
		}

		return list;
	}

	// Admin对用户的注销，
	// 将 user 表的用户状态修改为0，即 status = 0;
	@RequestMapping("/update/statusAndrole")
	public List<User> updateStatusAndRole(@RequestParam(value = "loginID", required = false) String loginID,
			@RequestParam(value = "role", required = false) Integer role,
			@RequestParam(value = "status", required = false) Integer status) {

		User user = new User(loginID, status, role);
		System.out.println("loginID：" + loginID);
		System.out.println("role：" + role);
		System.out.println("status：" + status);
		System.out.println("user为：" + user);

		if (role == null && status != null) // 注销用户
		{
			userService.updateStatus(user);
		} else if (role != null && status == null) // 改变用户角色 普通用户和经理之间的相互转变
		{
			userService.updateRole(user);
		}

//		userService.updateStatusAndRole(user);

		// 返回全用户列表给前端
		return userService.selectAll();

	}

	/**
	 * 登录判断方法
	 * 
	 * @param loginId  传入三个参数
	 * @param password
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	public CommonResult login(@RequestParam("loginId") String loginId, @RequestParam("password") String password,
			HttpSession session) {

		System.out.println("登陆的sessionID为：" + session.getId()); // 暂时弃用

		return userService.login(loginId, password, session);

	}

	// 退出登录方法
	@GetMapping("/logout")
	public CommonResult logout(HttpSession session) {
		session.removeAttribute("user"); // 暂时弃用
		return new CommonResult<String>(200, "您已退出登陆，期待您下次的到来", null);
	}

	// 导入用户列表，批量注册
	@PostMapping("/users/import")
	public CommonResult importStudents(@RequestParam("file") MultipartFile file) {

		List<User> users = null;
		try {
//			Thread.sleep(100);
			users = UserDataUtil.excelToUsers(file.getInputStream());
			for (User user : users) {
				userService.insert(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new CommonResult<String>(400, "数据异常，请检查编号是否重复或格式是否正确", null);

		}

		System.out.println("从Excel文件读取到的数据：" + users);

		return new CommonResult<String>(200, "批量注册成功", null);

	}

}
