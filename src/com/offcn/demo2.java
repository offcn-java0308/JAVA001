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
	 //创建PDFwriter
    PdfWriter writer = new PdfWriter("d:\\test\\demo2.pdf");

    //创建PDFdocument
    PdfDocument pdf = new PdfDocument(writer);

    //创建document
    Document document = new Document(pdf, PageSize.A4.rotate());
    //设置页边距
    document.setMargins(20, 20, 20, 20);
   //设置中文字体
    PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", false);
    
    //创建表格对象：
    Table table = new Table(new float[]{4, 2, 2, 4});
   
    table.setWidthPercent(100);
    //创建单元格对象，跨1行4列
    Cell headcell=new Cell(1,4);
    //设置单元格背景颜色
    headcell.setBackgroundColor(Color.ORANGE);
    //向表格对象添加表头单元格，里面包含内容 ,设置居中、加粗
    table.addHeaderCell(headcell.add(new Paragraph("个人简历").
    		setTextAlignment(TextAlignment.CENTER).setFont(font).setBold()));
    
     //向表格对象添加单元格,创建新的单元格，添加内容为 one、tow、three、four
    table.addCell(new Cell().add(new Paragraph("one").setFont(font)));
    table.addCell(new Cell().add(new Paragraph("tow").setFont(font)));
    table.addCell(new Cell().add(new Paragraph("three").setFont(font)));
    table.addCell(new Cell().add(new Paragraph("four").setFont(font)));    
    //循环向表格对象增加17个单元格，每个单元格内容为1-17的序号数字
    for(int i=1;i<17;i++){
    	table.addCell(new Cell().add(new Paragraph(i+"").setFont(font)));
    }
    //创建一个跨2行1列的单元格，背景色设置为绿色
    Cell bootcell=new Cell(2,1);
    bootcell.setBackgroundColor(Color.GREEN);    
    table.addCell(bootcell);
    //循环向表格对象添加6个单元格，背景设置为粉红色，内容为数组1-6
    for(int i=1;i<7;i++){
    table.addCell(new Cell().setBackgroundColor(Color.PINK).
    		add(new Paragraph(""+i).setFont(font)));
    }
    //把表格添加到文档对象
    document.add(table);

    //Close document
    document.close();

}
}
