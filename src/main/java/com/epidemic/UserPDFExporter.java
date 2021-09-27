package com.epidemic;

import java.util.List;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import com.epidemic.model.ContactList;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
 

public class UserPDFExporter {
	private List<ContactList> contactList;
    
    public UserPDFExporter(List<ContactList> listUsers) {
        this.contactList = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Patient ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("City", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("State", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Pincode", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Mobile", font));
        table.addCell(cell);    
        
        cell.setPhrase(new Phrase("Contact Date", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
        for (ContactList user : contactList) {
            table.addCell(String.valueOf(user.getpatientId()));
            table.addCell(user.getCity());
            table.addCell(user.getState());
            table.addCell(user.getPincode()+"");
            table.addCell(user.getMobile()+"");
            table.addCell(user.getContactDate()+"");
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Contacts", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
