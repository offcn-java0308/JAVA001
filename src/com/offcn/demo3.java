package com.offcn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class demo3 {

	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
		
		//����PDFwriter
	    PdfWriter writer = new PdfWriter("d:\\test\\demo3.pdf");
	    //����PDFdocument
	    PdfDocument pdf = new PdfDocument(writer);
	    //����document
	    Document document = new Document(pdf, PageSize.A4.rotate());
	    //����ͼƬ����ͨ��ͼƬ���ݹ����࣬������ImageDate����
	    Image dog=new Image(ImageDataFactory.create("d:\\test\\dog.jpg"));
	    
	    //�����������ͼƬ����
	    Paragraph p=  new Paragraph("Hello dog��").add(dog).add("wang wang!");
	    document.add(p);	    
	    document.close();
	    
	    

	}

}
