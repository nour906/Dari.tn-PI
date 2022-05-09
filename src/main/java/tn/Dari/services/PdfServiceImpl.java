package tn.Dari.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.Dari.entities.LoansSimulationBank;




@Service
public class PdfServiceImpl implements PdfService {

	

	@Autowired
	private LoansService loanservice;
	
	@Override
	public String toPDF(Long idloan) 
	{
		String URL_file = null;
		
		LoansSimulationBank simulation = loanservice.getLoansById(idloan);
		

		Date d = new Date();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("yyyyMMdd_HHmmss");
		

		try {
			try {
				try {
					try {
		
		URL_file = "C:\\LoansPI\\" + idloan + "_" + formater.format(d)
		+ ".pdf";
		
		OutputStream file = new FileOutputStream(new File(URL_file));
		
		
		Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.GRAY);
		Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
		Font subFontPara13B = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
		Font subFontPara13N = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
		Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

		Document my_pdf_report = new Document();
		PdfWriter.getInstance(my_pdf_report, file);
		my_pdf_report.open();

		// Dateeee
		DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
		String dt = df.format(new Date());
		Paragraph dateStr = new Paragraph("Date: " + dt, smallBold);
		dateStr.setAlignment(Element.ALIGN_RIGHT);
		
		
		Paragraph bank = new Paragraph(simulation.getBank().getNamebank(), subFont);
		bank.setAlignment(Element.ALIGN_LEFT);
		
		Image imgBank = null;
			imgBank = Image.getInstance("C:\\LoansPI\\dari.png");
		
		imgBank.setAbsolutePosition(260, 767);
		imgBank.scalePercent(10);
		
		// espaceee
		Paragraph espace = new Paragraph(" ", subFont);
		espace.setAlignment(Element.ALIGN_LEFT);
		
		// para1
		Paragraph para1 = new Paragraph("Mr,Mms " + simulation.getUser().getFirst_name()
				+ " " + simulation.getUser().getLast_name(), catFont15B);
		para1.setAlignment(Element.ALIGN_LEFT);
		Paragraph para2 = new Paragraph(
				"Dari team is glad to provide a simulation system "
						+ "for your demande of credit .",
				subFontPara13N);
		para2.setAlignment(Element.ALIGN_LEFT);
		
		// espaceee
				

		
		// titreee
		Paragraph titre1 = new Paragraph("YOUR INFORMATION", catFont15B);
		titre1.setAlignment(Element.ALIGN_CENTER);
		
		// espaceee
				
				espace.setAlignment(Element.ALIGN_LEFT);
				
		// table declaration
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(90);
		

		//Ligne 1
		PdfPCell Cellnom = new PdfPCell(new Phrase("First Name & Last Name:\r\n " + simulation.getUser().getFirst_name() + " "
				+ simulation.getUser().getLast_name(), subFontPara13N));
		Cellnom.setBorder(Rectangle.NO_BORDER);
		Cellnom.setBackgroundColor(BaseColor.WHITE);
		table.addCell(Cellnom);
		
		//Ligne 2
		PdfPCell CellEmail = new PdfPCell(new Phrase("Email :\r\n" + simulation.getUser().getEmail(), subFontPara13N));
		CellEmail.setBorder(Rectangle.NO_BORDER);
		CellEmail.setBackgroundColor(BaseColor.WHITE);
		table.addCell(CellEmail);
		
		//Ligne 3
		PdfPCell Celsal = new PdfPCell(new Phrase("Salary :\r\n" + simulation.getSalaire(), subFontPara13N));
		Celsal.setBorder(Rectangle.NO_BORDER);
		Celsal.setBackgroundColor(BaseColor.WHITE);
		table.addCell(Celsal);
		
		//break
		Paragraph separator = new Paragraph("_____________________________________________________________________",
				catFont15B);
		separator.setAlignment(Element.ALIGN_CENTER);
		
		// titreee
		Paragraph titre2 = new Paragraph("BANK", catFont15B);
		titre2.setAlignment(Element.ALIGN_CENTER);
		
		// espaceee
				
				espace.setAlignment(Element.ALIGN_LEFT);
		//table 2
		PdfPTable table1 = new PdfPTable(5);
		table1.setWidthPercentage(90);
		
		//ligne1
		PdfPCell Celbankname = new PdfPCell(new Phrase("Bank :\r\n" + simulation.getBank().getNamebank(), subFontPara13N));
		Celbankname.setBorder(Rectangle.NO_BORDER);
		Celbankname.setBackgroundColor(BaseColor.WHITE);
		table1.addCell(Celbankname);
		
		//ligne2
		PdfPCell Celagentname = new PdfPCell(new Phrase("Agent :\r\n" + simulation.getBank().getAgent().getFirstname() + "   " +simulation.getBank().getAgent().getLastname(),subFontPara13N));
		Celagentname.setBorder(Rectangle.NO_BORDER);
		Celagentname.setBackgroundColor(BaseColor.WHITE);
		table1.addCell(Celagentname);
		
		//ligne3
				PdfPCell Celbankadd = new PdfPCell(new Phrase("Bank Address :\r\n" + simulation.getBank().getAdressbank() ,subFontPara13N));
				Celbankadd.setBorder(Rectangle.NO_BORDER);
				Celbankadd.setBackgroundColor(BaseColor.WHITE);
				table1.addCell(Celbankadd);
		//ligne4
				PdfPCell Celtm = new PdfPCell(new Phrase("Avarage Margin Rate :\r\n" + simulation.getBank().getTaux() ,subFontPara13N));
				Celtm.setBorder(Rectangle.NO_BORDER);
				Celtm.setBackgroundColor(BaseColor.WHITE);
				table1.addCell(Celtm);
				
		//ligne5
				PdfPCell Celmarg = new PdfPCell(new Phrase("Interet Bank Margin:\r\n" + simulation.getBank().getMargeInteretbank() , subFontPara13N));
				Celmarg.setBorder(Rectangle.NO_BORDER);
				Celmarg.setBackgroundColor(BaseColor.WHITE);
				table1.addCell(Celmarg);	
				
				//break
				Paragraph separator2 = new Paragraph("_____________________________________________________________________\r\n",catFont15B);
				
				espace.setAlignment(Element.ALIGN_LEFT);

			//title
				Paragraph titre21 = new Paragraph("ESTIMATION", catFont15B);
				titre21.setAlignment(Element.ALIGN_CENTER);		
				
				espace.setAlignment(Element.ALIGN_LEFT);
//table 3	
				PdfPTable table3 = new PdfPTable(4);
				table3.setWidthPercentage(100);
				
		//ligne6
				PdfPCell Celtaux = new PdfPCell(new Phrase("Rate :\r\n" + simulation.getTaux() , subFontPara13N));
				Celtaux.setBorder(Rectangle.NO_BORDER);
				Celtaux.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celtaux);	
		//ligne7
				PdfPCell Celmtaux = new PdfPCell(new Phrase("Monthly rate :\r\n" + simulation.getMensuel() , subFontPara13N));
				Celmtaux.setBorder(Rectangle.NO_BORDER);
				Celmtaux.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celmtaux);	
		//ligne8
				PdfPCell Celcapacity = new PdfPCell(new Phrase("Repayment capacity :\r\n" + simulation.getCapaciteRembouresement() , subFontPara13N));
				Celcapacity.setBorder(Rectangle.NO_BORDER);
				Celcapacity.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celcapacity);	
		//ligne9
				PdfPCell Celmp= new PdfPCell(new Phrase("Monthly payment :\r\n" + simulation.getCapaciteRembouresement() , subFontPara13N));
				Celmp.setBorder(Rectangle.NO_BORDER);
				Celmp.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celmp);		
				
				espace.setAlignment(Element.ALIGN_LEFT);
		//lligne10
				PdfPCell CelBI= new PdfPCell(new Phrase("Bank interest :\r\n" + simulation.getInteret() , subFontPara13N));
				CelBI.setBorder(Rectangle.NO_BORDER);
				CelBI.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(CelBI);	
		//lligne11
				PdfPCell Celp= new PdfPCell(new Phrase("princper :\r\n" + simulation.getPrincipale() , subFontPara13N));
				Celp.setBorder(Rectangle.NO_BORDER);
				Celp.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celp);	
		//lligne12
				PdfPCell CelRA= new PdfPCell(new Phrase("Refund Amount :\r\n" + simulation.getMontantRemb() , subFontPara13N));
				CelRA.setBorder(Rectangle.NO_BORDER);
				CelRA.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(CelRA);
		//lligne13
				PdfPCell CelBIT= new PdfPCell(new Phrase("Bank Total interest :\r\n" + simulation.getInteretall() , subFontPara13N));
				CelBIT.setBorder(Rectangle.NO_BORDER);
				CelBIT.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(CelBIT);
				
				Paragraph titrefin = new Paragraph("THANK YOU FOR\r\nUSING OUR SERVICE.", subFont);
				titrefin.setAlignment(Element.ALIGN_LEFT);	
				
				
				// fiin P1
				Paragraph finPage1 = new Paragraph(" Page 1/1", smallBold);
				finPage1.setAlignment(Element.ALIGN_RIGHT);	
				
		
						
				my_pdf_report.add(bank);
				my_pdf_report.add(dateStr);
				my_pdf_report.add(imgBank);
			
				my_pdf_report.add(espace);

				my_pdf_report.add(para1);
				my_pdf_report.add(para2);
				my_pdf_report.add(espace);
				
				
				my_pdf_report.add(separator);
				my_pdf_report.add(espace);
				my_pdf_report.add(titre1);
				
				my_pdf_report.add(espace);
				my_pdf_report.add(table);
				my_pdf_report.add(espace);
				
				
				my_pdf_report.add(separator);
				my_pdf_report.add(espace);
				my_pdf_report.add(titre2);
				

				my_pdf_report.add(espace);
				my_pdf_report.add(table1);
				my_pdf_report.add(espace);
				
				
				my_pdf_report.add(separator);
				my_pdf_report.add(espace);
				my_pdf_report.add(titre21);
			

				my_pdf_report.add(espace);
				my_pdf_report.add(table3);
				
				my_pdf_report.add(espace);
				my_pdf_report.add(espace);
			
				my_pdf_report.add(espace);
				my_pdf_report.add(titrefin);
				my_pdf_report.add(espace);
				my_pdf_report.add(espace);
				my_pdf_report.add(espace);
				my_pdf_report.add(espace);
				my_pdf_report.add(finPage1);

				my_pdf_report.close();
				file.close();
				
				Runtime.getRuntime()
				.exec("rundll32 url.dll,FileProtocolHandlerC:\\LoansPI"
						+ idloan + "_" + formater.format(d) + ".pdf");
					//p.waitFor(2, TimeUnit.SECONDS);
				
						} catch (FileNotFoundException e) {
						e.printStackTrace();
						}
			} catch (DocumentException e) {
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
		return "" + idloan + "_" + formater.format(d) + ".pdf";
	}
}