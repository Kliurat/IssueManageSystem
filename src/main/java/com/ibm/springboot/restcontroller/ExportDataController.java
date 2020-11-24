package com.ibm.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.springboot.exportUtils.ColumnTitleMap;
import com.ibm.springboot.exportUtils.ExportDataService;
import com.ibm.springboot.service.IssueService;

@RestController
public class ExportDataController {

	@Autowired
	IssueService issueService;

	@Autowired
	ExportDataService exportDataService;

	/**
	 * @api: /apios/exportdata/excel/
	 * @method: GET
	 * @desc: 导出数据，生成xlsx文件
	 * @param response   返回对象
	 */
	@GetMapping(value = "/excel")
	public void getUserInfoEx(HttpServletResponse response/*,@RequestParam String date_start,@RequestParam String date_end*/) 
	{
		try 
		{
			List<Map<String, Object>> userList = issueService.queryUserInfoResultListMap();
			ArrayList<String> titleKeyList = new ColumnTitleMap("userinfo").getTitleKeyList();
			Map<String, String> titleMap = new ColumnTitleMap("userinfo").getColumnTitleMap();
			exportDataService.exportDataToEx(response, titleKeyList, titleMap, userList);
		} 
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
