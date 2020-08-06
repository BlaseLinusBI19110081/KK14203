import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

class Lab6_1{
   public static void main(String[] args){
      Form x = new Form();
   }
   
}

class Form extends JFrame implements ActionListener, ItemListener{
   private JPanel panel;
   private JLabel header, output; 
   private JTextField name, nameBox, matric, matricBox, course, rating, outcome;
   private JFrame jfrm;
   private JComboBox courseB;
   private JRadioButton a, b, c, d, e, f;
   private ButtonGroup rate;
   private JCheckBox basic, adv;
   private JButton submit;
   private static String[] courseList = {"KP14203", "KT20363", "KK14203", "UJ00202"};
   
   
   JScrollPane jsp;
   String systemOutput = " ";
   String codeSelection = " ";
   String ratingScore = " ";
   String outcomeSelection = " ";
   String filePath = "Database.txt";
   
   //constructor
   Form(){
      //Frame
      setSize(480, 400);
      setTitle("Frame Title");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   
      //Panel
      panel = new JPanel();
      add(panel);
      panel.setLayout(null);
      
      //header
      header = new JLabel("Course Evaluation Form");
      header.setBounds(165, 10, 150, 20);
      panel.add(header);
      
      //name
      name = new JTextField("Name");
      name.setEditable(false);
      name.setBounds(20, 40, 150, 20);
      panel.add(name);
      nameBox = new JTextField();
      nameBox.setBounds(175, 40, 235, 20);
      panel.add(nameBox);
      
      //Matric No.
      matric = new JTextField("Matric No.");
      matric.setEditable(false);
      matric.setBounds(20, 65, 150, 20);
      panel.add(matric);
      matricBox = new JTextField();
      matricBox.setBounds(175, 65, 190, 20);
      panel.add(matricBox);
      
      //Course code
      course = new JTextField("Course Code");
      course.setEditable(false);
      course.setBounds(20, 90, 150, 20);
      panel.add(course);
      courseB = new JComboBox(courseList); //combo box
      courseB.setBounds(175, 90, 150, 20);
      panel.add(courseB);
      
      //ComboBox action listener
      courseB.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            codeSelection = (String) courseB.getSelectedItem();
         }
      });
      
      //Rating
      rating = new JTextField("Rating");
      rating.setEditable(false);
      rating.setBounds(20, 115, 150, 20);
      panel.add(rating);
      
      
      a = new JRadioButton("1");
      a.setBounds(175, 115, 35, 20);
      panel.add(a);
      b = new JRadioButton("2");
      b.setBounds(210, 115, 35, 20);
      panel.add(b);
      c = new JRadioButton("3");
      c.setBounds(245, 115, 35, 20);
      panel.add(c);
      d = new JRadioButton("4");
      d.setBounds(280, 115, 35, 20);
      panel.add(d);
      e = new JRadioButton("5");
      e.setBounds(315, 115, 35, 20);
      panel.add(e);
      
      //action Listener 
      a.addActionListener(this);
      b.addActionListener(this);
      c.addActionListener(this);
      d.addActionListener(this);
      e.addActionListener(this);
     
      
      rate = new ButtonGroup();
      rate.add(a);
      rate.add(b);
      rate.add(c);
      rate.add(d);
      rate.add(e);
      
      //outcome
      outcome = new JTextField("Outcome");
      outcome.setEditable(false);
      outcome.setBounds(20, 140, 150, 20);
      panel.add(outcome);
      basic = new JCheckBox("Basic knowledge");
      basic.setBounds(175, 140, 130, 20);
      basic.addItemListener(this);
      panel.add(basic);   
      adv = new JCheckBox("Advance knowledge");
      adv.setBounds(305, 140, 140, 20);
      adv.addItemListener(this);
      panel.add(adv);
      
      
      
      //Submit
      submit = new JButton("Submit");
      submit.setBounds(20, 165, 75, 27);
      panel.add(submit);
      
      //Button Submit action Listener
      submit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            printOutput();
            writeInput(); 
         }
      });
      
      output = new JLabel("Output");
      output.setBounds(20, 197, 400, 140);
      panel.add(output);   
      
     // jsp = new JScrollPane(output);
     // output.setBounds(20, 220, 430, 120);
      //panel.add(jsp);
      
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
         ratingScore = ae.getActionCommand();
      }
      
   // Check Box Item Listener
   public void itemStateChanged(ItemEvent ie){
      JCheckBox check = (JCheckBox)ie.getSource();
      outcomeSelection += check.getText() + " ";
   }
   
   //Print output
   public boolean printOutput(){
      systemOutput = "<html>";
      systemOutput += "Thank you for evaluting <br><br>";
      systemOutput += "Name: " + nameBox.getText() + "<br>";
      systemOutput += "Matric No.: " + matricBox.getText() + "<br>";
      systemOutput += "Course: " + codeSelection + "<br>";
      systemOutput += "Rating: " + ratingScore + "<br>";
      systemOutput += "Outcome: " + outcomeSelection + "<br>";
      systemOutput += "<html>";
      output.setText(systemOutput);
      //jsp.getViewport().revalidate();
      return true;
   }
   
   //write to file
   public void writeInput(){
      File inFile = new File(filePath);
      FileWriter fr = null;
      BufferedWriter br = null;
      PrintWriter pr = null;
      String input = nameBox.getText() + ", " + matricBox.getText()+ ", " + codeSelection + ", " + ratingScore + ", " + outcomeSelection;
      
      //Exception Handling
      try {
         fr = new FileWriter(inFile, true);
         br = new BufferedWriter(fr);
         pr = new PrintWriter(br);
         pr.println(input);
      } catch (IOException e){
         output.setText(e.toString());
      }finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				output.setText(e.toString());
			}
		}
   }
   
   class MenuActionListener implements ActionListener {
   Form fp;
   //receive Form class to this constructor
   public MenuActionListener(Form p){
      fp = p;
   }
   
   public void actionPerformed(ActionEvent e) {
      BufferedReader reader;
	   try {
			reader = new BufferedReader(new FileReader(fp.filePath));
			String line = reader.readLine();
         String output="<html>";
			while (line != null) {
				output += line + "<br>";
				// read next line
				line = reader.readLine();
			}
         output += "<br>";
         fp.output.setText(output);
			reader.close();
		} catch (IOException io) {
			fp.output.setText(io.toString());
		}

  }
}

} 

