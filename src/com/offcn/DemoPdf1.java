package com.offcn;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

public class DemoPdf1 {

	public static void main(String[] args) throws IOException {
		// pdfWrite
		PdfWriter write = new PdfWriter("d:\\test\\demo111.pdf");

		// pdfDocument
		PdfDocument pdf = new PdfDocument(write);
		
		//����һ��֧�����ĵ�����
		 PdfFont font=PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", true);
		// document
		Document doc = new Document(pdf, PageSize.B5);
		//�趨����
        doc.setFont(font);
		// д������
		Paragraph p = new Paragraph("���JAVA");
		p.setTextAlignment(TextAlignment.CENTER);
       //�������ֵ���ɫ
       p.setFontColor(Color.PINK);
       p.setFontSize(25);
		doc.add(p);
		// ��ȡPDF�ĵ����Զ���
		PdfDocumentInfo info = pdf.getDocumentInfo();
		info.setTitle("Title:java0308 2017year 6month");
		info.setSubject("Subject:study java");
		info.setAuthor("you jiu ye");
		info.setCreator("Teacher");
		info.setKeywords("java,itext,pdf,jsp,j2ee");
		doc.close();

	}

}
