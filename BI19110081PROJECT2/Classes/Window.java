import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window {
	
	private String matric;
	private Entry entry;
	private Panel panel;

	public Window(int width,int height, String title, MainProject project) {
		JFrame frm = new JFrame(title);
		
		frm.setPreferredSize(new Dimension(width, height));
		frm.setMaximumSize(new Dimension(width, height));
		frm.setMinimumSize(new Dimension(width, height));
		
		Header header = new Header("Course Peformance v.0.1b by Blase");
		panel = new Panel();
		entry = new Entry();
		
		System.out.print(matric);
		frm.add(header, BorderLayout.NORTH);
		frm.add(panel, BorderLayout.CENTER);
		
		panel.save.addActionListener(new Button());
		panel.clear.addActionListener(new Button());
		panel.total.addActionListener(new Button());
		
		JMenuBar menuBar = new JMenuBar(); 
		JMenu menu = new JMenu("Menu"); 
		
		JMenuItem data = new JMenuItem("View Data");
		data.addActionListener(new MenuActionListener());
		
		JMenuItem exit = new JMenuItem("Exit");  
	    exit.addActionListener((event) -> System.exit(0));
	    
	    menu.add(data);
	    menu.add(exit);
	    
	    menuBar.add(menu);
	    
	    frm.setJMenuBar(menuBar);  
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(false);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
	}
	
	public String getMatric() {
		return matric;
	}
	
	private class Button implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == panel.save) {
				panel.setMatric(entry.getMatric());
				panel.transferMatric();
				panel.transferMark();
				panel.printOutput();
				panel.writeIndividualData();
			} else if(e.getSource() == panel.clear) {
				panel.clear();
			} else if(e.getSource() == panel.total) {
				panel.writeData();
				panel.printOverallOutput();
			} 
			
		}	
	}
	
	private class MenuActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			BufferedReader reader;
			   try {
				   
					reader = new BufferedReader(new FileReader("database.txt"));
					String line = reader.readLine();
					String output="<html>";
					while (line != null) {
						output += line + "<br>";
						line = reader.readLine();
					}
					output += "<br>";
					panel.setOutput(output);
					reader.close();
					
				} catch (IOException io) {
					io.printStackTrace();
					panel.setOutput(io.toString());
				}
			
		}	
	}
}

class Header extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Header(String headerTitle) {
		JLabel header = new JLabel(headerTitle);
		add(header);
	}
	
}