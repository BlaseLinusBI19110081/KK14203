import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FlowLayout flow;
	private JLabel lblCourse, lblResult, output;
	private JComboBox<String> courseCode;
	private JTextField mark;
	private JScrollPane scrollPane;
	private String[] courseList = {"KT14403 Struktur Diskrit", "UW00102 Hubungan Etnik", "UC01502 Makna Dalam Komunikasi"};
	private int[] creditHour = {4 , 4 , 4};
	private String matric;
	
	private ReadWrite RW;
	
	public JButton save, total, clear;
	
	public Panel() {
		flow = new FlowLayout(FlowLayout.LEFT);
		setLayout(flow);
		
		lblCourse = new JLabel("Course code : ");
		lblCourse.setPreferredSize(new Dimension(90, 20));
		add(lblCourse);
		
		 RW = new ReadWrite(courseList, creditHour);
		
		courseCode = new JComboBox<String>(RW.getCourseList());
		courseCode.setPreferredSize(new Dimension(265, 20));
		add(courseCode);
		courseCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				RW.setCourse(courseCode.getSelectedItem().toString());
			}
		});
		
		
		lblResult = new JLabel("Carry Mark    : ");
		lblResult.setPreferredSize(new Dimension(150, 20));
		add(lblResult);
		
		mark = new JTextField();
		mark.setPreferredSize(new Dimension(150, 25));
		mark.setHorizontalAlignment(JTextField.CENTER);
		add(mark);
		
		save = new JButton("Save");
		save.setPreferredSize(new Dimension(80, 25));
		add(save);
		
		clear = new JButton("Clear ALL");
		save.setPreferredSize(new Dimension(80, 25));
		add(clear);
		
		total = new JButton("Final Total");
		total.setPreferredSize(new Dimension(125, 25));
		add(total);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		output = new JLabel();
		output.setBorder(border);
	    output.setVerticalAlignment(JLabel.TOP);
	    System.out.print(RW.getCourseQuantity());
		
		scrollPane = new JScrollPane(output);
		scrollPane.setPreferredSize(new Dimension(375, 375));
		scrollPane.getViewport().setBackground(Color.getHSBColor(185, 33, 86));
		add(scrollPane);
		
		
	}
	
	public void setMatric(String matric) {
		this.matric = matric;
	}
	
	public void setOutput(String output) {
		this.output.setText(output);
		scrollPane.getViewport().revalidate();
	}
	
	public void transferMatric() {
		RW.setMatric(matric);
	}
	
	public void transferMark() {
		double dnum = Double.parseDouble(mark.getText());
		RW.setMark(dnum);
		RW.setGrade(dnum);
	}
	
	public void printOutput() {
		output.setText(RW.getOutput());
		scrollPane.getViewport().revalidate();
	}
	
	public void printOverallOutput() {
		output.setText(RW.getOverallOutput());
		scrollPane.getViewport().revalidate();
	}

	public void clear() {
		RW.clear();
		output.setText("Please re-Enter all data from the begining");
	}
	
	public void writeIndividualData() {
		RW.writeIndividual();
	}
	
	public void writeData() {
		RW.writeOverall();
	}
}
