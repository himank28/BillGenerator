package com.navkar.billGeneratorUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.navkar.faltu.AdministratorForm;
import com.navkar.helper.DateLabelFormatter;

import antlr.collections.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReceiptWindowUI extends JFrame {

	private JButton resetBtn;
	private JTextField companyNameValue;
	private JLabel companyName;
	private JLabel date;
	private JButton backBtn;
	private JButton printBtn;
	private JTable jtable;
	private JPanel topPanel;
	private JPanel tablePanel;
	private JPanel bottomPanel;
	private JTextField dateValue;
	private JLabel advance;
	private JLabel balance;
	private JLabel totalAmount;
	private JTextField advValue;
	private JTextField balValue;
	private JTextField totalValue;
	private JButton addRow;
	private JButton saveAs;
	private JButton submit;
	private JTextField addRowValue;
	
	public ReceiptWindowUI() {
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents(){
		
		resetBtn = new javax.swing.JButton();
        companyNameValue = new javax.swing.JTextField(100);
        companyName = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        printBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        dateValue = new JTextField(100);
        advance = new JLabel();
        balance = new JLabel();
        totalAmount = new JLabel();
        advValue = new JTextField(15);
        balValue = new JTextField(15);
        totalValue = new JTextField(15);
        addRow = new JButton();
        saveAs = new JButton();
        submit = new JButton();
        addRowValue = new JTextField(10);
        
        //creating date picker
        JDatePickerImpl datePicker = UIUtilis.createDatePicker();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(topPanel);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(companyName)
        					.addComponent(date))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(backBtn)
        					.addGap(26)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(resetBtn)
        					.addGap(26)
        					.addComponent(printBtn))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        					.addComponent(companyNameValue, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(366, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(20, Short.MAX_VALUE)
        			)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(companyName)
        				.addComponent(companyNameValue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(date)
        				.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addGap(47)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(resetBtn)
        				.addComponent(backBtn)
        				.addGap(25)
        				.addComponent(printBtn))
        			.addGap(25))
        );
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        resetBtn.setText("RESET");
        resetBtn.setActionCommand("RESET");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        companyName.setText("COMPANY NAME :");
        date.setText("DATE :");


        printBtn.setText("PRINT");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        
		topPanel.setLayout(layout);
        
		
        //The code for table starts from here
        String [] colNames  = {"SrNo","Particulars","Quantity","Amount"};
        String [][] rowData = new String[8][4];
		
        final DefaultTableModel tableModel = new DefaultTableModel(rowData, colNames) {
        	boolean[] canEdit = new boolean[]{false, true, true, true };
        	
        	@Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jtable = new JTable(tableModel);
        jtable.setFont(getFont());
        jtable.setRowHeight(30);
        jtable.getTableHeader().setPreferredSize(new Dimension(100, 30));
        UIUtilis.setJTableColumnsWidth(jtable, 500, 2, 82, 8, 8);
		tablePanel = new JPanel(new GridLayout(1,1));
		tablePanel.add(jtable); 
		tablePanel.setVisible(true);
		tablePanel.add(new JScrollPane(jtable));
		
		
		//code for bottomPanel starts here
		GroupLayout bottomLayout = new javax.swing.GroupLayout(bottomPanel);
		

		//attempt2
		advance.setText("Advance");
		balance.setText("Balance");
		totalAmount.setText("Total");
		addRow.setText("Add Rows : ");
		addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowBtnActionPerformed(evt,tableModel);
            }

        });
		saveAs.setText("SAVE AS");
		saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsBtnActionPerformed(e);
			}
		});
		submit.setText("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitBtnActionPerformed(e);
			}
		});
		bottomLayout.setAutoCreateGaps(true);
		bottomLayout.setAutoCreateContainerGaps(true);
		
		bottomLayout.setHorizontalGroup(
				bottomLayout.createSequentialGroup()
				.addGap(100)
				  .addGroup(bottomLayout.createSequentialGroup()
						  .addComponent(saveAs).addGap(25)
						  .addComponent(submit).addGap(25)
						  .addComponent(addRow).addGap(2)
						  .addComponent(addRowValue).addGap(25)
						  .addGroup(bottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								  .addComponent(advance)
								  .addComponent(balance)
								  .addComponent(totalAmount)))
			      .addGroup(bottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			    		  .addComponent(advValue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
			    		  .addComponent(balValue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
			    		  .addComponent(totalValue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
			      );
		
		bottomLayout.setVerticalGroup(
				bottomLayout.createSequentialGroup()
					.addGroup(bottomLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(saveAs,GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(submit,GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(addRow,GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(addRowValue,GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(advance)
							.addComponent(advValue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGroup(bottomLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(balance)
							.addComponent(balValue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGroup(bottomLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(totalAmount)
							.addComponent(totalValue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				);
		
		bottomPanel.setLayout(bottomLayout);
		
		getContentPane().add(topPanel,BorderLayout.NORTH);
		getContentPane().add(tablePanel,BorderLayout.CENTER);
		getContentPane().add(bottomPanel,BorderLayout.SOUTH);
		getContentPane().setSize(1300, 700);
        pack();
	}
	
	protected void saveAsBtnActionPerformed(ActionEvent e) {
		System.out.println(" evt.getActionCommand() : "+e.getActionCommand());
		UIUtilis.convertPanelToPdf(tablePanel,900,2000,"/home/himankjain/Videos/mj/my_panel_pdf.pdf");
	}

	protected void submitBtnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setAllDataDields(ReceiptWindow receiptWindow){
		if(receiptWindow==null){
		return;
		}
	}
	
	private void resetBtnActionPerformed(ActionEvent evt) {
		System.out.println(" evt.getActionCommand() : "+evt.getActionCommand());
		companyNameValue.setText("");
		dateValue.setText("");
	}
	
	private void printBtnActionPerformed(ActionEvent evt) {
		System.out.println(" evt.getActionCommand() : "+evt.getActionCommand());
	}
	
	private void backBtnActionPerformed(ActionEvent evt) {
		HelloWorld a=new HelloWorld();
		a.frame.setVisible(true);
		this.setVisible(false);
	}
	
	private void addRowBtnActionPerformed(ActionEvent evt,final DefaultTableModel model){ 
		String s = addRowValue.getText();
		int numRowToAdd = Integer.parseInt(s.trim());
		if(numRowToAdd>15){
			JOptionPane.showMessageDialog(null,"The Number of rows should not be more than 15 rows at a time.");	
		}else{
			for(int i=0;i<numRowToAdd;i++)
			model.insertRow(1, new String [3]); 
		}
	}
}
