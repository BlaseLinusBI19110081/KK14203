import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ReadWrite extends Student{
	
	private String filePath1 = "courses.txt";
	private String filePath2 = "database.txt";
	private static DecimalFormat df = new DecimalFormat("#.##");

	public ReadWrite(String[] courseCode, int[] creditHour) {
		super(courseCode, creditHour);
	}
	
	public void writeIndividual() {
		File file = new File(filePath1);
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		String input = getMatric() + ", " + getCourse() + ", " + getMark() + ", " + getGrade() + ", " + getPointer() + "\n";
		System.out.println(input);
		
		try {
			
			fw = new FileWriter (file, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.println(input);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException e) {
				
			}	
		}		
	}
	
	public void writeOverall() {
		File file = new File(filePath2);
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		df.setRoundingMode(RoundingMode.UP);
		
		String input = getMatric() + ", " + getAllCourses() +"," + df.format(getOverallMark()) + ", " + df.format(getOverallPointer()) + ", " + getOverallGrade() + "\n";
		System.out.println(input);
		
		try {
			
			fw = new FileWriter (file, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.println(input);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException e) {
				
			}	
		}	
		
		
	}
	
	
}
