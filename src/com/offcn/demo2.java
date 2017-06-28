package com.offcn;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class demo2 {
public static void main(String[] args) throws IOException {
	 //����PDFwriter
    PdfWriter writer = new PdfWriter("d:\\test\\demo2.pdf");

    //����PDFdocument
    PdfDocument pdf = new PdfDocument(writer);

    //����document
    Document document = new Document(pdf, PageSize.A4.rotate());
    //����ҳ�߾�
    document.setMargins(20, 20, 20, 20);
   //������������
    PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", false);
    
    //����������
    Table table = new Table(new float[]{4, 2, 2, 4});
   
    table.setWidthPercent(100);
    //������Ԫ����󣬿�1��4��
    Cell headcell=new Cell(1,4);
    //���õ�Ԫ�񱳾���ɫ
    headcell.setBackgroundColor(Color.ORANGE);
    //���������ӱ�ͷ��Ԫ������������� ,���þ��С��Ӵ�
    table.addHeaderCell(headcell.add(new Paragraph("���˼���").
    		setTextAlignment(TextAlignment.CENTER).setFont(font).setBold()));
    
     //���������ӵ�Ԫ��,�����µĵ�Ԫ���������Ϊ one��tow��three��four
    table.addCell(new Cell().add(new Paragraph("one").setFont(font)));
    table.addCell(new Cell().add(new Paragraph("tow").setFont(font)));
    table.addCell(new Cell().add(new Paragraph("three").setFont(font)));
    table.addCell(new Cell().add(new Paragraph("four").setFont(font)));    
    //ѭ�������������17����Ԫ��ÿ����Ԫ������Ϊ1-17���������
    for(int i=1;i<17;i++){
    	table.addCell(new Cell().add(new Paragraph(i+"").setFont(font)));
    }
    //����һ����2��1�еĵ�Ԫ�񣬱���ɫ����Ϊ��ɫ
    Cell bootcell=new Cell(2,1);
    bootcell.setBackgroundColor(Color.GREEN);    
    table.addCell(bootcell);
    //ѭ������������6����Ԫ�񣬱�������Ϊ�ۺ�ɫ������Ϊ����1-6
    for(int i=1;i<7;i++){
    table.addCell(new Cell().setBackgroundColor(Color.PINK).
    		add(new Paragraph(""+i).setFont(font)));
    }
    //�ѱ����ӵ��ĵ�����
    document.add(table);

    //Close document
    document.close();

}
}
