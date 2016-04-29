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
import com.spring.forensic.pojo.Drugs;
import com.spring.forensic.pojo.UserAccounts;

public class PdfView extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map mapModel, Document pdfDocument,
			PdfWriter pdfWriter, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	 
			List drugList = (List)mapModel.get("drugList");
			
			HttpSession requestSession = req.getSession();
			UserAccounts userAccount = (UserAccounts)requestSession.getAttribute("user");
			
			Table tab = new Table(5);
			tab.addCell("Drug ID");
			tab.addCell("Drug Name");
			tab.addCell("Drug Quantity");
			tab.addCell("Enterprise Name");
			tab.addCell("ExpiryDate");
	 
			for (Object obj : drugList)
			{
				Drugs drug = (Drugs)obj;
				tab.addCell(drug.getDrugId()+"");
				tab.addCell(drug.getDrugName());
				tab.addCell(drug.getQuantity()+"");
				tab.addCell(drug.getEnterprise().getEnterpriseName());
				tab.addCell(drug.getExpiryDate());
	        }
			
			// formatting of table
			tab.enableBorderSide(10);
			tab.setBorder(5);
			tab.setAutoFillEmptyCells(true);
			tab.setCellsFitPage(true);
			tab.setComplete(true);
			tab.setTableFitsPage(true);
			tab.setBorderWidth(5);
			tab.setCellsFitPage(true);
			tab.setComplete(true);
			tab.setPadding(2);
			
	        pdfDocument.add(new Paragraph(new java.util.Date().toString())); 
			pdfDocument.add(new Paragraph("Welcome : "+ userAccount.getFirstName()+" "+ userAccount.getLastName())) ;
			pdfDocument.add(new Paragraph("Enterprise DRUG Inventory",FontFactory.getFont(FontFactory.HELVETICA,24,Font.BOLD,Color.GRAY)));
			pdfDocument.add(tab);
			
			//For adding metadata to PDF document
			pdfDocument.addAuthor("Hari Panjwani");
			pdfDocument.addHeader("PDF", "View");
			pdfDocument.addSubject("Subject");
			pdfDocument.addTitle("title");
			pdfDocument.right(10);
			pdfDocument.left(20);
			pdfDocument.top(20);
			
		}

}
