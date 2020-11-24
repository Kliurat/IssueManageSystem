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
		columnTitleMap.put("issue_no", "Issue编号");
		columnTitleMap.put("issue_type", "Issue类型");
		columnTitleMap.put("title", "Issue标题");
	}

	/**
	 * mysql用户表需要导出字段集
	 */
	private void initUserInfoTitleKeyList() 
	{
		titleKeyList.add("issue_no");
		titleKeyList.add("issue_type");
		titleKeyList.add("title");
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
