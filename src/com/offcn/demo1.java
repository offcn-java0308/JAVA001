package com.offcn;

import java.io.FileNotFoundException;




import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
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

public class demo1 {

	public static void main(String[] args) throws IOException {
		PdfWriter writer=new PdfWriter("d:\\test\\demo1.pdf");
		//hello github
       PdfDocument pdfdocument=new PdfDocument(writer);
       //获取文档属性对象
      PdfDocumentInfo pdfdocinfo= pdfdocument.getDocumentInfo();
      //设置文档属性
      pdfdocinfo.setAuthor("offcn");
      pdfdocinfo.setCreator("you jiu ye");
      pdfdocinfo.setKeywords("java,pdf,offcn,youjiuye");
      pdfdocinfo.setSubject("doc subject");
      pdfdocinfo.setTitle("doc title");
      //设置文档纸张大小
       Document doc=new Document(pdfdocument,PageSize.A3);
     //设置字体解决中文问题
       PdfFont front=PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", false);
       doc.setFont(front);
       
       //向文档添加内容
       Paragraph pg=new Paragraph();
       pg.add("你好欢迎你来到JAVA学习班");      
       //设置背景颜色
       pg.setBackgroundColor(Color.BLUE);
       
       //设置字体
      // PdfFont front=PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
       
      
       pg.setTextAlignment(TextAlignment.CENTER);
       pg.setFontColor(Color.ORANGE);
       pg.setFontSize(28);
       doc.add(pg);
       
       doc.close();
       
	}

}
