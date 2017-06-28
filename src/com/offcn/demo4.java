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
		// 创建PDFwriter
		PdfWriter writer = new PdfWriter("d:\\test\\demo3.pdf");
		// 创建PDFdocument
		PdfDocument pdf = new PdfDocument(writer);
		// 创建document
		Document doc = new Document(pdf, PageSize.A4.rotate());
		// 设置中文字体
		PdfFont sysFont = PdfFontFactory.createFont("STSong-Light",
				"UniGB-UCS2-H", false);
		String Image = "d:\\test\\1.jpg";// 图片路径
		Table tab = new Table(new float[] { 6, 3 });
		tab.setWidthPercent(80);
		tab.setHorizontalAlignment(HorizontalAlignment.CENTER);
		Image Img = new Image(ImageDataFactory.create(Image));
		
		//公章
		Image Imggz = new Image(ImageDataFactory.create("d:\\test\\gz.png"),50,50);
		Cell cellimg = new Cell().add(Img.setAutoScale(true))// 向第一个表格中添加图片
				.setBorder(new SolidBorder(new DeviceRgb(148, 0, 211), 3));
		// .setBorder(Border.NO_BORDER);
		tab.addCell(cellimg);
		Cell cell = new Cell();
		// 文字样式
		Text text1 = new Text("人类的海洋").setFont(sysFont)
				.setFontSize((float) 7.41)
				.setFontColor(new DeviceRgb(46, 46, 46)).setBold();// setBold()字体为加粗
		Text text2 = new Text("保护地球是我们共同的责任,让我们一起努力，让我们的地球更美好")
				.setFont(sysFont).setFontSize((float) 7.41)
				.setFontColor(new DeviceRgb(46, 46, 46));

		cell.setTextAlignment(TextAlignment.LEFT)
				// 字体居左
				.add(new Paragraph().add(text1).add("\n").add(text2)
						.setFixedLeading(15))// setFixedLeading为设置行间距
				.setBorder(new SolidBorder(new DeviceRgb(139, 0, 139), 3))// 边界颜色，边界宽度
				.setBackgroundColor(new DeviceRgb(244, 248, 250));

		tab.addCell(cell);
		doc.add(tab.setHorizontalAlignment(HorizontalAlignment.LEFT));// 将表格添加入文档并页面居中
		doc.add(Imggz);
		doc.close();
		doc.close();

	}

}
