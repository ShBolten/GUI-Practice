import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class Test extends JFrame{
	String ID = "";
	String Name = "";
	String Department = "";
	String ID1 = "";
	String Name1 = "";
	String Department1 = "";
	String StudentID11 = "";
	JTextField textField1 = new JTextField("");
	JTextField textField2 = new JTextField("");
	JTextField textField3 = new JTextField("");
	String str = "Search";
	String column[]={"Course ID", "Course Name","Department", "Credits"};
	DefaultTableModel tableModel = new DefaultTableModel(column, 0);
	JTable table = new JTable(tableModel);
	private JScrollPane sp;
	JTextField StuID = new JTextField("");
	JTextField StuName = new JTextField("");
	JTextField CourseID = new JTextField("");
	JTextField StudentID1 = new JTextField("");
	public void GUI1() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Course Schedule");
		frame.setLayout(new GridLayout(4,1));
	
		//panel color 
		JPanel primary = new JPanel();
		JPanel Enroll = new JPanel();
		JPanel Withdraw = new JPanel();
		primary.setBackground(Color.BLACK);
		Enroll.setBackground(Color.BLACK);
		Withdraw.setBackground(Color.BLACK);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		textField1.setEditable(true);
		textField2.setEditable(true);
		textField3.setEditable(true);
		tableModel.setRowCount(0);
		sp =new JScrollPane(table);
		//panel 1 attributes
		JPanel subPanel1 = new JPanel();
		subPanel1.setBackground(Color.WHITE);
		JLabel label1 = new JLabel("Course ID");
		subPanel1.add(label1);
		subPanel1.setPreferredSize(new Dimension(200, 100));
		subPanel1.add(textField1);
		textField1.setColumns(20);
		
		//panel 2 attributes
		JPanel subPanel2 = new JPanel();
		subPanel2.setBackground(Color.WHITE);
		JLabel label2 = new JLabel("Course Name");
		subPanel2.add(label2);
		subPanel2.setPreferredSize(new Dimension(200, 100));
		subPanel2.add(textField2);
		textField2.setColumns(20);
		
		//panel 3 attributes
		JPanel subPanel3 = new JPanel();
		subPanel2.setBackground(Color.WHITE);
		JLabel label3 = new JLabel("Department");
		subPanel3.add(label3);
		subPanel3.setPreferredSize(new Dimension(200, 100));
		subPanel3.add(textField3);
		textField3.setColumns(20);
		
		//JButton addition
		JButton enterButton1 = new JButton(str);
		enterButton1.addActionListener(new ButtonClickListener());
		enterButton1.setActionCommand(str);
		String with = "Withdraw";
		JPanel subPanel5 = new JPanel();
		subPanel5.setBackground(Color.BLACK);
		JButton withdrawButton = new JButton(with);
		withdrawButton.addActionListener(new ButtonClickListener());
		subPanel5.add(withdrawButton);
		String enr = "Enroll";
		JPanel subPanel6 = new JPanel();
		subPanel6.setBackground(Color.BLACK);
		JButton enrollButton = new JButton(enr);
		enrollButton.addActionListener(new ButtonClickListener());
		subPanel6.add(enrollButton);
		JPanel subPanel4 = new JPanel();
		subPanel4.setBackground(Color.BLACK);
		JLabel label4 = new JLabel("Search");
		subPanel4.add(enterButton1);
		textField1.addActionListener(new TextFieldListener());
		textField2.addActionListener(new TextFieldListener());
		textField3.addActionListener(new TextFieldListener());
		StuID.addActionListener(new TextFieldListener());
		StuName.addActionListener(new TextFieldListener());
		CourseID.addActionListener(new TextFieldListener());
		JPanel enr1 = new JPanel ();
		JPanel enr2 = new JPanel ();
		JPanel enr3 = new JPanel ();
		enr1.setBackground(Color.WHITE);
		enr2.setBackground(Color.WHITE);
		enr3.setBackground(Color.WHITE);
		JLabel enL1 = new JLabel("Student ID");
		JLabel enL2 = new JLabel("Student Name");
		JLabel enL3 = new JLabel("Course ID");
		enr1.setPreferredSize(new Dimension(200, 100));
		enr2.setPreferredSize(new Dimension(200, 100));
		enr3.setPreferredSize(new Dimension(200, 100));
		JPanel with1 = new JPanel ();
		with1.setBackground(Color.WHITE);
		JLabel withh1 = new JLabel("Student ID");
		with1.setPreferredSize(new Dimension(200, 100));
		StudentID1.setColumns(20);
		with1.add(withh1);
		StuID.setColumns(20);
		StuName.setColumns(20);
		CourseID.setColumns(20);
		with1.add(StudentID1);
		enr1.add(enL1);
		enr2.add(enL2);
		enr3.add(enL3);
		enr1.add(StuID);
		enr2.add(StuName);
		enr3.add(CourseID);
		Enroll.add(enr1);
		Enroll.add(enr2);
		Enroll.add(enr3);
		StudentID1.addActionListener(new TextFieldListener());
		//adding to the main frame
		primary.add(subPanel1);
		primary.add(subPanel2);
		primary.add(subPanel3);
		primary.add(subPanel4);
		
		
		Enroll.add(subPanel6);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.add(primary);
		frame.add(Enroll);
		Withdraw.add(with1);
		Withdraw.add(subPanel5);
		frame.add(Withdraw);
		frame.pack();
		frame.add(sp);
		frame.setVisible(true);
		
	}
	private class TextFieldListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		JTextField source = (JTextField)e.getSource();
		if (source == textField1)
			ID = textField1.getText();
		else if(source == textField2)
			Name = textField2.getText();
		else if (source == textField3)
			Department = textField3.getText();
		else if (source == StuID)
			ID1 = StuID.getText();
		else if(source == StuName)
			Name1 = StuName.getText();
		else if (source == CourseID)
			Department1 = CourseID.getText();
		else if (source == StudentID1)
			StudentID11 = StudentID1.getText();
		}
}
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			   String command = e.getActionCommand();
			   if (command.equals("Search")) {
		           Scanner scan = null;
		           try
		           {
		               File file = new File("Courses.txt");
		               scan = new Scanner(file);
		           }
		           catch(FileNotFoundException f)
		           {
		               System.out.println("File Not Found Exception" + f);
		           }
		           if (ID.equals("") && Name.equals("") && Department.equals(""))
		        	   JOptionPane.showMessageDialog(null, "Enter criteria to search");
		           else
			           while (scan.hasNextLine()) 
			           	{
			               String [] word;
			               String line = scan.nextLine();
			               word = line.split(",");
			               if(word[0].contains(ID) && word[1].contains(Name) && word[2].contains(Department)){
			            	   tableModel.addRow(word);
			               }
		           }
		       
			   }
			   else if (command.equals("Enroll")) {
				   File file_out = new File("Enrollment.txt");
				   Scanner scan = null;
				   try
				   {
		               scan = new Scanner(file_out);
		           }
		           catch(FileNotFoundException f)
		           {
		               System.out.println("File Not Found Exception" + f);
		           }
		           if (ID1.equals("") && Name1.equals("") && Department1.equals(""))
		        	   JOptionPane.showMessageDialog(null, "Enter criteria to search");
				   else {
				       	FileOutputStream fo = null;
					  try {
						  fo = new FileOutputStream(file_out, true);
					} catch (FileNotFoundException e1) {
							e1.printStackTrace();
					}
					  while (scan.hasNextLine()) 
			           	{
			               String [] word;
			               String line = scan.nextLine();
			               word = line.split(",");
			               if(word[0].contains(ID1) && word[1].contains(Name1) && word[2].contains(Department1)){
			            	    PrintWriter pw2 = new PrintWriter(fo);
							    pw2.append("\n" + line);
							    pw2.close(); 
			               }
			               }
				   }
			   }
			   else if (command.equals("Withdraw")) {
				   
				   File inputFile = new File("Enrollment.txt");
				   Scanner scan = null;
				   try
				   {
		               scan = new Scanner(inputFile);
		           }
		           catch(FileNotFoundException f)
		           {
		               System.out.println("File Not Found Exception" + f);
		           }
		           if (StudentID11.equals(""))
		        	   JOptionPane.showMessageDialog(null, "Enter criteria to search");
				   else {
				       	FileOutputStream fo = null;
					  try {
						  fo = new FileOutputStream(inputFile, true);
					} catch (FileNotFoundException e1) {
							e1.printStackTrace();
					}
					  while (scan.hasNextLine()) 
			           	{
			               String [] word;
			               String str2 = "";
			               String line = scan.nextLine();
			               word = line.split(",");
			               File tempFile = new File("myTempFile.txt");
			               BufferedReader reader = null;
			               BufferedWriter writer = null;
			               if (StudentID11.contains(word[0]))
			            	   tableModel.addRow(word);
			               try {
			            	   reader = new BufferedReader(new FileReader(inputFile));
			               } catch (FileNotFoundException e2) {
			            	   e2.printStackTrace();
			               }
			               try {
			            	   writer = new BufferedWriter(new FileWriter(tempFile));
			               } catch (IOException e2) {
			            	   e2.printStackTrace();
			               }
							  	String lineToRemove = StudentID11; // the line you want to delete
							  	String currentLine;
							  	try {
							  		while((currentLine = reader.readLine()) != null) {
							  			String trimmedLine = currentLine.trim();
							  			if(trimmedLine.equals(lineToRemove)) continue;
							  				writer.write(currentLine + System.getProperty("line.separator"));
							  			}
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										   try {
											writer.close();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										   try {
											reader.close();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										   boolean successful = tempFile.renameTo(inputFile);
									   }
					   }
				   }
		}
	}
}




	

