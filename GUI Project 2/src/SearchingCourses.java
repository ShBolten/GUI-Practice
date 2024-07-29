	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.BorderLayout;
	import java.util.*;
	import java.io.*;
	import javax.swing.table.DefaultTableModel;

	public class SearchingCourses extends JFrame{
	   JTextField Department = new JTextField("Enter Department Here");
	   JTextField CourseID = new JTextField("Enter Course ID");
	   JTextField CourseName = new JTextField("Enter Course Name");
	   JButton searchBTN;
	   JPanel displayResult;
	   JTable courseTable;
	   DefaultTableModel tableModel;
	  
	   public void displaySearch() {
	      
	       //create frame and set layout and dimensions
	       //create two panels that will be added to the frame
	       JFrame frame = new JFrame("Searching Courses");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setLayout(new BorderLayout());
	       frame.setSize(new Dimension(300,100));
	       JPanel left = new JPanel();
	       JPanel right = new JPanel();
	      
	      
	      
	       //create labels that will have a set text to know what inputs to place
	       JLabel Department1 = new JLabel("Department:");
	       JLabel CourseID1 = new JLabel("Course ID:");
	       JLabel CourseName1 = new JLabel("Course Name:");
	      
	      
	      
	       //textFields that will be editable and will have actionListener
	       //button that will collect data and on click display results wanted
	       JTextField Department = new JTextField("Enter Department Here");
	       Department.setEditable(true);
	       Department.addActionListener(new TextFieldListener());
	       JTextField CourseID = new JTextField("Enter Course ID");
	       CourseID.setEditable(true);
	       CourseID.addActionListener(new TextFieldListener());
	       JTextField CourseName = new JTextField("Enter Course Name");
	       CourseName.setEditable(true);
	       CourseName.addActionListener(new TextFieldListener());
	      
	       JButton searchBTN = new JButton("SEARCH");
	       searchBTN = new JButton("SEARCH");
	       searchBTN.addActionListener(new ButtonClickListener());

	      
	       //creating table from text files
	       String [] column = {"CourseID", "CourseName", "Department", "Credits"};
	       tableModel = new DefaultTableModel(column,0);
	       tableModel.setRowCount(0);
	       courseTable = new JTable(tableModel);
	      
	      
	      
	       //add all fields, labels to correct panel
	       left.add(Department1);
	       left.add(CourseID1);
	       left.add(CourseName1);
	       right.add(Department);
	       right.add(CourseID);
	       right.add(CourseName);
	      
	       //add panels and btns to correct locations and set window to be visible
	       frame.add(left,BorderLayout.LINE_START);
	       frame.add(right,BorderLayout.LINE_END);
	       frame.add(searchBTN, BorderLayout.CENTER);
	       frame.add(displayResult, BorderLayout.PAGE_END);
	       frame.pack();
	       frame.setVisible(true);
	   }
	  
	  
	   private class TextFieldListener implements ActionListener{
	  
	       public void actionPerformed(ActionEvent e) {
	          
	           JTextField field = (JTextField)e.getSource();
	           String result = "";
	           if(field == Department)
	               result = Department.getText();
	           else if (field == CourseID)
	               result = CourseID.getText();
	           else if (field == CourseName)
	               result = CourseName.getText();
	              
	       }
	      
	       }
	  
	   private class ButtonClickListener implements ActionListener{
	       //use line spitting to comapre inputs to txt files
	       //getSOurce to read what textField was used and take that input to then
	       //   apply to
	       public void actionPerformed(ActionEvent e) {
	          
	           //String command = e.getActionCommand();
	           String dept = Department.getText();
	           String cid = CourseID.getText();
	           String cname = CourseName.getText();
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
	             
	           while (scan.hasNextLine())
	              
	           {
	               String [] word;
	               String line = scan.nextLine();
	               //System.out.println(scan.nextLine());
	               word = line.split(",");
	               if(dept.equals("")|| cid.equals("") || cname.equals("")){
	               tableModel.addRow(word);
	               }
	               else{
	                   if(word[0].equals(dept)&&word[1].equals(cid)&&word[2].equals(cname))
	                   tableModel.addRow(word);
	               }
	           }
	           /*
	           if (((String)result) == "Department")
	           {
	              
	           }
	           */
	             
	           /* if(e.getSource == searchBTN)
	           {
	               if (sourceField.equals())
	           }
	               */
	       }
	      
	       }
	  
	}

