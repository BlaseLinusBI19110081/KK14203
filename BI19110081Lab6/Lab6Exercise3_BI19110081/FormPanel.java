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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FormPanel extends JPanel implements ActionListener{
	   JButton orderButton, addButton;
	   JTextArea textbox1, textbox2;
	   JComboBox listOfItems;
	   JLabel cakeMenu, Topping;
	   
	   private static final Dimension SIZE = new Dimension(935, 320);
	   
	   static BlackForest cake;
	   static ArrayList<String> order;
	   
	   
	   String filePath = "lab6.txt";

	   public FormPanel() {
		   
	      
	      String[] Items = {"[Select]"};
	   
	      orderButton = new JButton ("Order");
	      addButton = new JButton ("Add Topping");
	      textbox1 = new JTextArea (5, 5);
	      textbox2 = new JTextArea (5, 5);
	      JScrollPane textbox1SP = new JScrollPane(textbox1);
	      JScrollPane textbox2SP = new JScrollPane(textbox2);
	      listOfItems = new JComboBox (Items);
	      Topping = new JLabel ("Topping Selection");
	      cakeMenu = new JLabel ("Cake Menu");
	      
	      addButton.addActionListener(this);
	      orderButton.addActionListener(this);
	      
	      setPreferredSize (SIZE);
	      setLayout (null);
	   
	      //add components
	      add (addButton);
	      add (orderButton);
	      add (textbox1SP);
	      add (textbox2SP);
	      add (listOfItems);
	      add (Topping);
	      add (cakeMenu);
	   
	      addButton.setBounds (325, 80, 125, 30);
	      orderButton.setBounds(325, 120, 125, 30);
	      textbox2SP.setBounds (50, 25, 265, 175);
	      textbox1SP.setBounds (460, 25, 425, 255);
	      listOfItems.setBounds (180, 210, 125, 30);
	      Topping.setBounds (50, 210, 125, 30);
	      cakeMenu.setBounds (50, 0, 100, 25);
	   }
	   
	   
	   public void actionPerformed(ActionEvent ae){
	      String command = ae.getActionCommand(); 
	      
	      if(command.equals("Add Topping")){
	         order.add(listOfItems.getSelectedItem().toString());      
	         textbox1.append(listOfItems.getSelectedItem().toString() + "\n");   
	      }
	      else if(command.equals("Order")){
	         
	         String orderList[] = new String[order.size()]; 
	      
	         // ArrayList to Array Conversion 
	         for (int j = 0; j < order.size(); j++) { 
	            // Assign each value to String array 
	            orderList[j] = order.get(j); 
	         }
	        
	         cake.orderCake(orderList, 1, 2);
	         String orderLine = cake.printOrder_GUI();
	         textbox1.append(orderLine);
	         modifyFile(orderLine);
	      }    
	   }
	   
	   public void showMenu(){
	   
	      String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
	      String text = cake.name + " cake with available toppings:\n";
	      for(int i=0; i<topping.length; i++){
	         text += "\n" + (i+1) + ")  " + topping[i] + "\n";
	      } 
	      text += "\nPrice:\n";
	      text += "[1] Small : RM45.0 \n";
	      text += "[2] Medium: RM65.0 \n";
	      text += "[3] Big   : RM80.0 \n";
	      textbox2.append(text);
	      
	   }

	       
	   public void updateCB(String[] topping){
	      for(int i=0; i<topping.length; i++){
	         listOfItems.addItem(topping[i]);
	      }      
	   }
	   
	   private void modifyFile(String line){
	    	File fileToBeModify = new File("data\\ScoreList.txt");
	    	PrintWriter update;
	    	try {
				update = new PrintWriter(new BufferedWriter(new FileWriter(fileToBeModify, true)));
				update.println(line);
				update.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    }
	   

	}
