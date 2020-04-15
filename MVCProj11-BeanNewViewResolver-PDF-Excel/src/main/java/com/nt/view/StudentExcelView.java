package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.dto.StudentDTO;

public class StudentExcelView extends AbstractXlsView {

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, 
			                                                               HttpServletRequest req,HttpServletResponse res)throws Exception {
		List<StudentDTO> listDTO=null;
		Sheet sheet=null;
		Row row=null;
		int i=0;
	
		//Read Model Attributes
		listDTO=(List<StudentDTO>) map.get("listDTO");
		//create WorkSheet
		sheet=workbook.createSheet("Students Report");
		//add rows with cells having DTO class objects data in cells
		for(StudentDTO dto:listDTO) {
			
			row=sheet.createRow(i);
			row.createCell(0).setCellValue(dto.getSno());
			row.createCell(1).setCellValue(dto.getSname());
			row.createCell(2).setCellValue(dto.getSadd());
			row.createCell(3).setCellValue(dto.getAvg());
			row.createCell(4).setCellValue(dto.getCourse());
			i++;
			
		}//for
		

	}//buildExcelDocument(-,-,-)

}
