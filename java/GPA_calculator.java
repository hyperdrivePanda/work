import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GPA_calculator extends JFrame{
	JButton calculateButton;
	JComboBox numCourses;
	JLabel credits, currentGPAl, 
			numberOfCourses, 
			nr, courseCode, creditHours, grade,
			finalGPAl, nr1, nr2, nr3, nr4, nr5, nr6;
	
	private JTextField item1, item2, item3, item4, item5, item6;
	private JComboBox hours1, hours2, hours3, hours4, hours5, hours6,
	grade1, grade2, grade3, grade4, grade5, grade6;
	
	JLabel []nrItem_L = new JLabel[10];
	
	
	JLabel itemNumber_L;
	JLabel courseCodeItem_L;
	JLabel creditHoursItem_L;
	JLabel gradeItem_L;
	JLabel empty;
	
	JPanel headerPanel, headerPanelTop, headerPanelBottom,
			coursePanel, bottomPanel, coursePanelSide;
	JTextField creditsf, currentGPAf, finalGPAf;
	
	String []numberOfCoursesArray = {"1", "2", "3", "4", "5", "6"};
	String []gradeRangeArray = { "A+ 90-100", "A 80-89", "B+ 75-79", "B 70-74", "C+ 65-69", "C 60-64", "D+ 54-59", "D 50-54", "F 0-40"};
	double []gradePointsArray = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.5};
	String []creditHoursArray = {"1", "2", "3", "4"};
	double GPAlast;
	
	JTextField []itemArray = {item1, item2, item3, item4, item5, item6};
	JComboBox []hoursArray = {hours1, hours2, hours3, hours4, hours5, hours6};
	JComboBox []gradeArray = {grade1, grade2, grade3, grade4, grade5, grade6};
	
	Box box	 = Box.createVerticalBox();
	Box box2 = Box.createVerticalBox();
	Box box3 = Box.createVerticalBox();
	Box box4 = Box.createVerticalBox();
	
	int totalCredits = 5;
	double total_gp = 4.5*6;
	double qualityPoints = 4.5*6;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GPA_calculator()
	{
		super("the title");
		headerPanel = new JPanel();
		coursePanel = new JPanel();
		bottomPanel = new JPanel();
		headerPanel = new JPanel();
		headerPanelTop = new JPanel();
		headerPanelBottom = new JPanel();
		credits = new JLabel ("Credits");
		currentGPAl = new JLabel ("Quality Points");
		currentGPAf = new JTextField (4);
		numCourses = new JComboBox (numberOfCoursesArray);
		numCourses.setSelectedIndex(5);
		numberOfCourses = new JLabel ("number of courses");
		creditsf = new JTextField (4);
		finalGPAl = new JLabel("Final GPA");
		finalGPAf = new JTextField(4);	
		courseCode = new JLabel("Course Code");
		creditHours = new JLabel ("Credit Hours");
		grade = new JLabel ("Grade");
			
		JLabel nr = new JLabel("Nr.");
		JLabel nr1 = new JLabel("1");
		JLabel nr2 = new JLabel("2");
		JLabel nr3 = new JLabel("3");
		JLabel nr4 = new JLabel("4");
		JLabel nr5 = new JLabel("5");
		JLabel nr6 = new JLabel("6");
		
		JLabel []nrArray = {nr1, nr2, nr3, nr4, nr5, nr6};				
		
		calculateButton = new JButton ("Calculate");
				
		setLayout( new BorderLayout());
	
		headerPanel.setLayout(new BorderLayout());
		headerPanelTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		coursePanel.setLayout(new GridLayout(1, 4));
		coursePanel.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);

		headerPanelTop.add(credits);
		headerPanelTop.add(creditsf);
		headerPanelTop.add(currentGPAl);
		headerPanelTop.add(currentGPAf);

		headerPanelBottom.add(numberOfCourses);
		headerPanelBottom.add(numCourses);
		
		ComboHandler comboHandler = new ComboHandler();
		numCourses.addActionListener(comboHandler);
		headerPanel.add(headerPanelTop, BorderLayout.NORTH);
		headerPanel.add(headerPanelBottom, BorderLayout.EAST);		

		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.add(finalGPAl);
		bottomPanel.add(finalGPAf);
		bottomPanel.add(calculateButton);
		
		item1 = new JTextField(2);
		item2 = new JTextField(1);
		item3 = new JTextField(1);
		item4 = new JTextField(1);
		item5 = new JTextField(1);
		item6 = new JTextField(1);
		
		coursePanel.add(box);
		coursePanel.add(box2);
		coursePanel.add(Box.createHorizontalStrut(1));
		coursePanel.add(box3);
		coursePanel.add(Box.createHorizontalStrut(1));
		coursePanel.add(box4);
		
		box.add(nr);
		box.add(Box.createVerticalStrut(30));
		for (int i = 0; i < 6; i++)
		{
			box.add(nrArray[i]);
			box.add(Box.createRigidArea(new Dimension(0,55)));
		}

		box2.add(courseCode);
		box2.add(Box.createVerticalStrut(30));
		for(int i = 0;i < 6;i++)
		{
			itemArray[i] = new JTextField();
			box2.add(itemArray[i]);
			box2.add(Box.createRigidArea(new Dimension(0,40)));
		}
	
		box3.add(creditHours);
		box3.add(Box.createVerticalStrut(30));
		
		for(int i = 0;i < 6;i++)
		{
			hoursArray[i] = new JComboBox(creditHoursArray);
			box3.add(hoursArray[i]);
			box3.add(Box.createRigidArea(new Dimension(0,40)));
		}
		
		box4.add(grade);
		box4.add(Box.createVerticalStrut(30));
		for(int i = 0;i < 6;i++)
		{
			gradeArray[i] = new JComboBox(gradeRangeArray);
			box4.add(gradeArray[i]);
			box4.add(Box.createRigidArea(new Dimension(0,40)));
		}
		
		ComboHandler handler = new ComboHandler();
		numCourses.addActionListener(handler);
		calculateButton.addActionListener(handler);
		hoursArray[1].addActionListener(handler);
		hoursArray[2].addActionListener(handler);
		hoursArray[3].addActionListener(handler);

		add(headerPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);	
		add(coursePanel, BorderLayout.WEST);
		
		nrItem_L[0]=creditHours;

	}

	public static void main(String[] args) {
		GPA_calculator frame = new GPA_calculator();
		frame.setTitle("GPA Calculator");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(600,600);
		frame.setVisible(true);
		//System.exit(0);
	}
	
	private class ComboHandler implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == numCourses)
			{	
				//enabling input under and on selected course number criteria, disabling over
				for (int i = 5; i > numCourses.getSelectedIndex(); i--)
				{
					itemArray[i].setEnabled(false);
				}
				
				for (int i = 0; i < numCourses.getSelectedIndex()+1; i++)
				{
					itemArray[i].setEnabled(true);
				}
				
				for (int i = 5; i > numCourses.getSelectedIndex();i--)
					hoursArray[i].setEnabled(false);
				
				for (int i=0; i < numCourses.getSelectedIndex()+1;i++)
					hoursArray[i].setEnabled(true);
				
				for (int i = 5; i > numCourses.getSelectedIndex();i--)
					gradeArray[i].setEnabled(false);
				
				for (int i=0; i < numCourses.getSelectedIndex()+1;i++)
					gradeArray[i].setEnabled(true);
			}
			
			if (e.getSource() == calculateButton)
			{
				
				//grade points to be divided
				totalCredits = 0;
				qualityPoints = 0;
				
				for (int i=0; i<numCourses.getSelectedIndex()+1; i++)
				{
					totalCredits += Integer.parseInt(hoursArray[i].getSelectedItem().toString());
				}
				
				creditsf.setText(String.valueOf(totalCredits));
				
				total_gp = 0;
				for (int i=0; i<numCourses.getSelectedIndex()+1; i++)
				{
					total_gp += gradePointsArray[gradeArray[i].getSelectedIndex()];
					qualityPoints += gradePointsArray[gradeArray[i].getSelectedIndex()]*Integer.parseInt(hoursArray[i].getSelectedItem().toString());
				}
				JOptionPane.showMessageDialog(null, qualityPoints + " divided by " + totalCredits);
				
				GPAlast = qualityPoints/totalCredits;
				finalGPAf.setText(String.valueOf((double)Math.round(GPAlast * 100d)/100d));
				currentGPAf.setText(String.valueOf(qualityPoints));
			}
				coursePanel.repaint();
		}

	}
	
	public void actionFormed(ActionEvent e)
	{
		bottomPanel.removeAll();
		
	}
	
	public void actionListener(ActionEvent e)
	{
		
	}
}
