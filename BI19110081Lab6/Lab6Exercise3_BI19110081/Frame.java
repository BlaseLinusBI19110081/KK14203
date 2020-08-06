import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame{
	private static final Dimension SIZE = new Dimension(990, 240);
	
	public  void createFrame() {
		this.setTitle("Cake Order!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		
		FormPanel form = new FormPanel();
		form.cake = new BlackForest("Black Forest");
	    form.order = new ArrayList<String>();
	    String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
	    form.cake.setCake(topping, 45.00, 65.00, 80.00); 
		form.showMenu();
		form.updateCB(topping);
		
		this.getContentPane().add(form);
	    this.pack();
		
		this.setVisible(true);
	}
	
	
	public Frame() {
		createFrame();
	}
	

	

}

