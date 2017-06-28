package com.offcn;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class demo4 {

	public static void main(String[] args) throws IOException {
		// ����PDFwriter
		PdfWriter writer = new PdfWriter("d:\\test\\demo3.pdf");
		// ����PDFdocument
		PdfDocument pdf = new PdfDocument(writer);
		// ����document
		Document doc = new Document(pdf, PageSize.A4.rotate());
		// ������������
		PdfFont sysFont = PdfFontFactory.createFont("STSong-Light",
				"UniGB-UCS2-H", false);
		String Image = "d:\\test\\1.jpg";// ͼƬ·��
		Table tab = new Table(new float[] { 6, 3 });
		tab.setWidthPercent(80);
		tab.setHorizontalAlignment(HorizontalAlignment.CENTER);
		Image Img = new Image(ImageDataFactory.create(Image));
		
		//����
		Image Imggz = new Image(ImageDataFactory.create("d:\\test\\gz.png"),50,50);
		Cell cellimg = new Cell().add(Img.setAutoScale(true))// ���һ����������ͼƬ
				.setBorder(new SolidBorder(new DeviceRgb(148, 0, 211), 3));
		// .setBorder(Border.NO_BORDER);
		tab.addCell(cellimg);
		Cell cell = new Cell();
		// ������ʽ
		Text text1 = new Text("����ĺ���").setFont(sysFont)
				.setFontSize((float) 7.41)
				.setFontColor(new DeviceRgb(46, 46, 46)).setBold();// setBold()����Ϊ�Ӵ�
		Text text2 = new Text("�������������ǹ�ͬ������,������һ��Ŭ���������ǵĵ��������")
				.setFont(sysFont).setFontSize((float) 7.41)
				.setFontColor(new DeviceRgb(46, 46, 46));

		cell.setTextAlignment(TextAlignment.LEFT)
				// �������
				.add(new Paragraph().add(text1).add("\n").add(text2)
						.setFixedLeading(15))// setFixedLeadingΪ�����м��
				.setBorder(new SolidBorder(new DeviceRgb(139, 0, 139), 3))// �߽���ɫ���߽���
				.setBackgroundColor(new DeviceRgb(244, 248, 250));

		tab.addCell(cell);
		doc.add(tab.setHorizontalAlignment(HorizontalAlignment.LEFT));// �����������ĵ���ҳ�����
		doc.add(Imggz);
		doc.close();
		doc.close();

	}

}
