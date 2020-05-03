package com.navkar.billGeneratorUI;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.navkar.helper.DateLabelFormatter;

public class UIUtilis {
	
	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
	        double... percentages) {
	    double total = 0;
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        total += percentages[i];
	    }
	 
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        TableColumn column = table.getColumnModel().getColumn(i);
	        column.setPreferredWidth((int)
	                (tablePreferredWidth * (percentages[i] / total)));
	        //table.getColumnModel().setColumn(column);
	    }
	}
	
	
	public static JDatePickerImpl createDatePicker(){
		Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
	}
	
	public static void createPdf(boolean shapes , JTable table) {
		   Document document = new Document();
		   try {
		      PdfWriter writer;
		      if (shapes)
		         writer = PdfWriter.getInstance(document,
		            new FileOutputStream("/home/himankjain/Videos/mj/my_jtable_shapes.pdf"));
		      else
		         writer = PdfWriter.getInstance(document,
		            new FileOutputStream("/home/himankjain/Videos/mj/my_jtable_fonts.pdf"));
		      document.open();
		      PdfContentByte cb = writer.getDirectContent();
		      PdfTemplate tp = cb.createTemplate(1000, 1000);
		      Graphics2D g2;
		      if (shapes)
		         g2 = tp.createGraphicsShapes(1000, 1000);
		      else
		         g2 = tp.createGraphics(500, 500);
		      table.print(g2);
		      g2.dispose();
		      cb.addTemplate(tp, 30, 300);
		      } catch (Exception e) {
		      System.err.println(e.getMessage());
		   }
		   document.close();
		}

	public static void convertPanelToPdf(JPanel panel,
	   int width, int height, String filename) {
	   Document document = new Document(new Rectangle(width, height));
	   try {
	      PdfWriter writer;
	      writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
	      document.open();
	      PdfContentByte cb = writer.getDirectContent();
	      PdfTemplate tp = cb.createTemplate(width, height);
	      Graphics2D g2d = tp.createGraphics(width, height, new DefaultFontMapper());
//	      Rectangle2D r2d = new Rectangle2D.Double(0, 0, width, height);
	      panel.printAll(g2d);//(g2d, r2d);
	      g2d.dispose();
	      cb.addTemplate(tp, 0, 0);
	   }
	   catch(Exception e) {
	      e.printStackTrace();
	   }
	   document.close();
	}
	
	private void PritnActionPerformed(java.awt.event.ActionEvent evt) {
	    Component jPanel1 = null;
	    JFrame jFrame = null;
	    
	    //actual code
		// TODO add your handling code here:
	    Toolkit tkp = jPanel1.getToolkit();
	    PrintJob pjp = tkp.getPrintJob(jFrame, null, null);
	    Graphics g = pjp.getGraphics();
	    jPanel1.print(g);
	    g.dispose();
	    pjp.end();
	}
}
