package com.ibm.springboot.exportUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.ibm.springboot.entity.Issue;

public class ExcelToStudent {

	// 根据传入的文件输入流，将excel表中的信息读取出来并返回
	public static List<Issue> excelToStudents(InputStream is) {

		try {

			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.iterator();

			List<Issue> students = new ArrayList<Issue>();

			int rowNumber = 0;

			while (rows.hasNext()) {

				Row currentRow = rows.next();

				// 跳过表头
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Issue issue = new Issue();

				int cellIdx = 0;

				while (cellsInRow.hasNext()) {

					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {

					case 0:
						break;

					case 1:
						issue.setIssueNo(currentCell.getStringCellValue());
						break;

					case 2:
						issue.setIssueType(currentCell.getStringCellValue());;
						break;
						
					case 3:
						issue.setTitle(currentCell.getStringCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}

				students.add(issue);

			}
			workbook.close();

			return students;
		} 
		catch (IOException e)
		{
			throw new RuntimeException("Excel文件解析异常： " + e.getMessage());
		}
		
	}

}
