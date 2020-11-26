package com.ibm.springboot.exportUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ColumnTitleMap 
{

	private Map<String, String> columnTitleMap = new HashMap<String, String>();
	
	private ArrayList<String> titleKeyList = new ArrayList<String>();

	public ColumnTitleMap(String datatype) 
	{
		switch (datatype) 
		{
			case "userinfo":
				initUserInfoColu();
				initUserInfoTitleKeyList();
				break;
				
			default:
				break;
		}

	}

	/**
	 * mysql用户表需要导出字段--显示名称对应集合
	 */
	private void initUserInfoColu() 
	{
		columnTitleMap.put("id", "编号");
		columnTitleMap.put("login_id", "登录id");
		columnTitleMap.put("username", "用户姓名");
		columnTitleMap.put("create_count", "创建数量");
		columnTitleMap.put("receive_count", "受到数量");
		columnTitleMap.put("modify_count", "完成数量");
		columnTitleMap.put("finished_per", "完成率");
	}

	/**
	 * mysql用户表需要导出字段集
	 */
	private void initUserInfoTitleKeyList() 
	{
		titleKeyList.add("id");
		titleKeyList.add("login_id");
		titleKeyList.add("username");
		titleKeyList.add("create_count");
		titleKeyList.add("receive_count");
		titleKeyList.add("modify_count");
		titleKeyList.add("finished_per");
	}

	public Map<String, String> getColumnTitleMap() 
	{
		return columnTitleMap;
	}

	public ArrayList<String> getTitleKeyList()
	{
		return titleKeyList;
	}
	

}
