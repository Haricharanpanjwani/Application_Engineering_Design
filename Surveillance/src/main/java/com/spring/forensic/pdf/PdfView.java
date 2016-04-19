package com.spring.forensic.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.forensic.pojo.Drug;
import com.spring.forensic.pojo.UserAccount;

public class PdfView extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 
			List list = (List)model.get("drugList");
			
			HttpSession session = request.getSession();
			UserAccount ua = (UserAccount)session.getAttribute("userAccount");
			
			Table table = new Table(5);
			table.addCell("DrugID");
			table.addCell("DrugName");
			table.addCell("Quantity");
			table.addCell("Enterprise");
			table.addCell("ExpiryDate");
	 
			for (Object o : list)
			{
				Drug drug = (Drug)o;
				table.addCell(drug.getDrugId()+"");
				table.addCell(drug.getDrugName());
				table.addCell(drug.getQuantity()+"");
				table.addCell(drug.getEnterprise().getEnterpriseName());
				table.addCell(drug.getExpiryDate());
	        }
			
			
			table.enableBorderSide(10);
			table.setBorder(5);
			table.setAutoFillEmptyCells(true);
			table.setCellsFitPage(true);
			table.setComplete(true);
			table.setTableFitsPage(true);
			table.setBorderWidth(5);
			table.setCellsFitPage(true);
			table.setComplete(true);
			table.setPadding(2);
			
	        document.add(new Paragraph(new java.util.Date().toString())); 
			document.add(new Paragraph("You Are : "+ua.getFirstName()+" "+ua.getLastName())) ;
			document.add(new Paragraph("                                      Enterprise DRUG Inventory",FontFactory.getFont(FontFactory.HELVETICA,22,Font.BOLD,Color.GRAY)));
			document.add(table);
			document.addAuthor("Hari Panjwani");
			document.addHeader("PDF", "View");
			document.addSubject("Subject");
			document.addTitle("title");
			document.right(10);
			document.left(20);
			document.top(20);
			
		}

}
