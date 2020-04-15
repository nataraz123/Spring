package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.StudentDTO;

public class StudentPdfView extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest  req, HttpServletResponse res) throws Exception {
		List<StudentDTO> listDTO=null;
		Paragraph p=null;
		Table t=null;
		//get Model Attribute data
		listDTO=(List<StudentDTO>)map.get("listDTO");
		//add paragraph
		p=new Paragraph("Students Report",new Font(Font.BOLD));
		doc.add(p);
		// add table
		t=new Table(5,listDTO.size());  // cols ,rows
		for(StudentDTO dto:listDTO){
			t.addCell(String.valueOf(dto.getSno()));
			t.addCell(dto.getSname());
			t.addCell(dto.getSadd());
			t.addCell(String.valueOf(dto.getAvg()));
			t.addCell(dto.getCourse());
		}
	  doc.add(t);
		
	}//buildPdfDocument(-,-,-,-)
}//class
