import javax.swing.JOptionPane;

public class Entry {
	
	private String matric;
	
	public Entry() {
		do{
	    	  matric = JOptionPane.showInputDialog("Enter your matric number",null);	
	    	  
	    	  if(matric == null){
	    		  System.exit(0);    		  
	    	  } else if(matric.length() != 10){
	    		  JOptionPane.showMessageDialog(null, "Please enter a valid matric number");    		  
	    	  }
	    	  
	 	  }while(matric.length() != 10);
	}
	
	public String getMatric() {
		return matric;
	}
}
