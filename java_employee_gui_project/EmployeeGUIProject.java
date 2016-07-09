package java_employee_gui_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.*;


public class EmployeeGUIProject extends JFrame implements ActionListener{

	JButton semp,bscemp,hemp,empdet,compname;

	//	Default company name
	static String str=new String("RKP INDUSTRIES:");
	Company c=new Company(str);

	//	Defualt constructor call to 
	public EmployeeGUIProject(){

		initComponents();
	}

	/*
		Function to create the graphical user elements, adding them
			on the window and adding action listeners to the elements
	*/
	private void initComponents(){

		semp=new JButton();
		bscemp=new JButton();
		hemp=new JButton();
		empdet=new JButton();
		compname=new JButton();
		JPanel temp1=new JPanel();


		Border outline = BorderFactory.createLineBorder(Color.black);
		temp1.setBorder(outline);
		temp1.setLayout(new BoxLayout(temp1,BoxLayout.PAGE_AXIS));
		temp1.setPreferredSize(new Dimension(400,400));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(str);

		setLocationRelativeTo(null);

		compname.setText("Company Name");
		compname.setBackground(Color.GREEN);

		semp.setText("Salaried Employee");
		semp.setBackground(Color.RED);
		bscemp.setText("Base Salaried and Commission Employee");
		bscemp.setBackground(Color.ORANGE);
		hemp.setText("Hourly paid Employee");
		hemp.setBackground(Color.YELLOW);
		empdet.setText("Employee Details");

		JLabel q1=new JLabel("Click below to change the Company Name:");
		temp1.add(q1,BorderLayout.NORTH);
		Dimension combosize=new Dimension(1200,1000);
		compname.setMaximumSize(combosize);
		temp1.add(compname);
		JLabel q2=new JLabel("Choose the type of Employee in the Company:");
		temp1.add(q2,BorderLayout.NORTH);
		semp.setMaximumSize(combosize);
		temp1.add(semp);
		bscemp.setMaximumSize(combosize);
		temp1.add(bscemp);
		hemp.setMaximumSize(combosize);
		temp1.add(hemp);
		JLabel q3=new JLabel("Click below to display the Employee Details:");
		temp1.add(q3,BorderLayout.NORTH);
		empdet.setMaximumSize(combosize);
		temp1.add(empdet);
		add(temp1,BorderLayout.CENTER);
		pack();

		compname.addActionListener(this);
		semp.addActionListener(this);
		bscemp.addActionListener(this);
		hemp.addActionListener(this);
		empdet.addActionListener(this);


	}

	/*
		Define the actions that need to be performed on interacting with the on-screen elements
	*/
	@Override
	public void actionPerformed(ActionEvent e){

		SalariedEmployee s[];
		BaseSalariedCommissionEmployee b[];
		HourlyEmployee h[];  
		String name;
		int id;
		int i,j;
		final  String newline = "\n";
		double sal,sales,hours,rate;
		JTextField nameField = new JTextField(10);
		JTextField idField = new JTextField(10);
		JTextField salField=new JTextField(10);
		JLabel temp=new JLabel();
		int result=0;
		JPanel myPanel = new JPanel();
		myPanel.setBounds(100,200 ,100,200);
		if(e.getSource()==compname)
		{

			JLabel l8=new JLabel("Do you want to really change the Company Name?");
			myPanel.setPreferredSize(new Dimension(300,100));
			myPanel.setBackground(Color.GREEN);
			myPanel.add(l8,BorderLayout.NORTH);
			result = JOptionPane.showConfirmDialog(null,myPanel, 
				"Change Company Name?", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {

				name=JOptionPane.showInputDialog("Company Name:");

				c.setCompanyName(name);
				setTitle(name);
			}
		}
		else	if(e.getSource()==semp){
			JLabel l1=new JLabel("You need to enter the name,id");
			JLabel l2=new JLabel("and the salary of employee!");
			myPanel.setPreferredSize(new Dimension(300,100));
			myPanel.setBackground(Color.RED);
			myPanel.add(l1,BorderLayout.NORTH);
			myPanel.add(l2,BorderLayout.NORTH);
			result = JOptionPane.showConfirmDialog(null,myPanel, 
				"Do you want a Salaried Employee?", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {

				name=JOptionPane.showInputDialog("Name:");
				id=Integer.parseInt(JOptionPane.showInputDialog("ID:"));
				sal=Double.parseDouble(JOptionPane.showInputDialog("Salary:"));
				c.createSemployee(name,id,sal);
			}
		}
		else if(e.getSource()==bscemp)
		{
			JLabel l3=new JLabel("You need to enter the name,id,base");
			JLabel l4=new JLabel("salary and sales of employee!");
			myPanel.setPreferredSize(new Dimension(300,100));
			myPanel.setBackground(Color.ORANGE);	
			myPanel.add(l3,BorderLayout.NORTH);
			myPanel.add(l4,BorderLayout.NORTH);
			result = JOptionPane.showConfirmDialog( null,myPanel, 
				"Do you want a Base Salaried & Commission Employee?", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				name=JOptionPane.showInputDialog(null,"Name:");
				id=Integer.parseInt(JOptionPane.showInputDialog(null,"ID:"));
				sal=Double.parseDouble(JOptionPane.showInputDialog(null,"Salary:"));
				sales=Double.parseDouble(JOptionPane.showInputDialog(null,"Sales"));
				c.createBSCemployee(name,id,sal,sales);

			}
		}
		else if(e.getSource()==hemp)
		{

			JLabel l5=new JLabel("You need to enter the name,id,");
			JLabel l6=new JLabel("working hours and rate per hour of employee!");
			myPanel.setPreferredSize(new Dimension(300,100));  
			myPanel.setBackground(Color.YELLOW);
			myPanel.add(l5,BorderLayout.NORTH);
			myPanel.add(l6,BorderLayout.NORTH);
			result = JOptionPane.showConfirmDialog( null,myPanel, 
				"Do you want a Hourly Paid Employee?", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				name=JOptionPane.showInputDialog(null,"Name:");
				id=Integer.parseInt(JOptionPane.showInputDialog(null,"ID:"));
				hours=Double.parseDouble(JOptionPane.showInputDialog(null,"Hours:"));
				rate=Double.parseDouble(JOptionPane.showInputDialog(null,"Rate:"));
				c.createHemployee(name,id,rate,hours);

			}
		}
		else if(e.getSource()==empdet)
		{
			result = JOptionPane.showConfirmDialog( null,myPanel, 
				"Do you want the Employee details", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION){
				JPanel panel1 = new JPanel();
				JTextArea textArea1 = new JTextArea(5, 20);
				JScrollPane scrollPane = new JScrollPane(textArea1); 
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane.setPreferredSize(new Dimension(250, 250));
				textArea1.setEditable(false);
				JLabel t1=new JLabel("Salaried Employee:");
				panel1.add(t1,BorderLayout.NORTH);
				panel1.setPreferredSize(new Dimension(300,300));
				panel1.setBackground(Color.RED);
				s=c.getSemp();
				for(i=0;i<SalariedEmployee.scount;i++)
				{
					textArea1.append(s[i].toString()+newline);
				}
				panel1.add(scrollPane,BorderLayout.NORTH);
				myPanel.add(panel1, BorderLayout.NORTH);


				JPanel panel2 = new JPanel();
				JTextArea textArea2 = new JTextArea(5, 20);
				JScrollPane scrollPane1 = new JScrollPane(textArea2); 
				textArea2.setEditable(false);
				scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane1.setPreferredSize(new Dimension(250, 250));
				JLabel t2=new JLabel("Base Salaried & Commission Employee:");
				panel2.add(t2,BorderLayout.CENTER);
				panel2.setPreferredSize(new Dimension(300,300));
				panel2.setBackground(Color.ORANGE);
				b=c.getBSCemp();
				for(i=0;i<BaseSalariedCommissionEmployee.bsccount;i++)
				{
					textArea2.append(b[i].toString()+newline);
				}
				panel2.add(scrollPane1,BorderLayout.CENTER);
				myPanel.add(panel2, BorderLayout.CENTER);

				JPanel panel3 = new JPanel();
				JTextArea textArea3 = new JTextArea(5, 20);
				JScrollPane scrollPane2 = new JScrollPane(textArea3); 
				textArea3.setEditable(false);
				scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane2.setPreferredSize(new Dimension(250, 250));
				JLabel t3=new JLabel("Hourly Paid Employee:");
				panel3.add(t3,BorderLayout.SOUTH);
				panel3.setPreferredSize(new Dimension(300,300));
				panel3.setBackground(Color.YELLOW);
				h=c.getHemp();
				for(i=0;i<HourlyEmployee.hcount;i++)
				{
					textArea3.append(h[i].toString()+newline);
				}
				panel3.add(scrollPane2,BorderLayout.SOUTH);
				myPanel.add(panel3, BorderLayout.SOUTH);
				pack();

				JOptionPane.showMessageDialog(null, myPanel);


			}
		}

	}

	/*
		Main function for making the elements visible
	*/
	public static void main(String args[]){
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				new EmployeeGUIProject().setVisible(true);
			}
		});

	}
}