package com.ibm.springboot.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ibm.springboot.entity.User;

public class UserDataUtil {

	// 从本地文件中导入用户表
	public static List<User> excelToUsers(InputStream is)
	{
		try 
		{
			Workbook workbook = new HSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			List<User> users = new ArrayList<User>();

			int rowNumber = 0;
			while (rows.hasNext()) 
			{
				Row currentRow = rows.next();

				// 跳过表头
				if (rowNumber == 0)
				{
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				User user = new User();
				String s1 = null;
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					currentCell.setCellType(CellType.STRING);
					switch (cellIdx) {
//					case 0:
//						s1 = currentCell.getStringCellValue();
//						break;

					case 0:
						s1 = currentCell.getStringCellValue();
						user.setLoginID(s1);
						break;

					case 1:
						s1 = currentCell.getStringCellValue();
						user.setUsername(s1);
						break;

					case 2:
						s1 = currentCell.getStringCellValue();
						user.setEmail(s1);
						break;

					case 3:
						s1 = currentCell.getStringCellValue();
						user.setPassword(s1);
						break;

					case 4:
						user.setStatus(Integer.valueOf(currentCell.getStringCellValue()));
						break;

					case 5:
						user.setRole(Integer.valueOf(currentCell.getStringCellValue()));
						break;

					default:
						break;
					}
					
					DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					try {
						date = fmt.parse(currentCell.getStringCellValue());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
					
					user.setRegisteDate(date);
					
					cellIdx++;
				}
				
				System.out.println("读取到的User:" + user.toString());
				
				users.add(user);
			}
			workbook.close();

			return users;
		} catch (IOException e) {
			throw new RuntimeException("Excel文件解析异常： " + e.getMessage());
		}
	}
}
