package com.ibm.springboot.util;

/**
 * 常量工具类
 * 
 * @author 赖炎林
 *
 */
public class ConstantUtil {

	public final static Integer PAGE_SIZE_5 = 5;

	public final static Integer PAGE_SIZE_8 = 8;

	public final static Integer PAGE_SIZE_10 = 10;

	public final static Integer PAGE_SIZE_15 = 15;

	public final static String NO_PRIVILEGE = "您没有权限访问，请向管理员申请权限";

	public final static String DATE_FORMAT_ONE_STRING = "yyyy-MM-dd HH:mm:ss";

	public final static String DATE_FORMAT_TWO_STRING = "yyyy-MM-dd HH:mm:ss";

	public final static int ISSUE_CLOSED = -1;

	public final static int ISSUE_SOLVING = 0; // 待解决

	public final static int ISSUE_VERIFYING = 1; // 待验证

	public final static int ROLE_MANAGER = 1; // 经理

	public final static int ROLE_ORDINARY_USER = 0; // 普通用户

}
