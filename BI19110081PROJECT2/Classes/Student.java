import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Student {
	private String[] courseCode;
	private int[] creditHour;
	private double[] mark = { 0, 0, 0}, coursePointer = {0, 0, 0};
	private int courseQuantity, totalCreditHr, i=0;
	private String grade, overallGrade, matric, output, overallOutput, course;
	private double courseMark, pointer, overallMark, overallPointer;
	
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	
	public Student(String [] courseCode, int[] creditHour) {
		this.courseCode = courseCode;
		this.creditHour = creditHour;
		
		for(int i = 0; i < creditHour.length; i++)
			totalCreditHr +=  creditHour[i];
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String[] getCourseList() {
		return courseCode;
	}
	
	public String getCourse() {
		return courseCode[i-1];
	}
	
	public String getAllCourses() {
		String input="";		
		for(int i = 0; i<courseCode.length; i++)
			input += courseCode[i] + " "; 
			
		return input;
	}
	
	public int getCourseQuantity() {
		for(int i = 0; i < courseCode.length; i++)
			courseQuantity++;
		
		return courseQuantity;
	}
	
	public void setMark(double mark) {
		courseMark = mark;
		this.mark[i] = courseMark; 
		i++;
		System.out.println(i);
	}
	
	public double getMark() {
		return courseMark;
	}
	
	public void clear() {
		i = 0;
	}
	
	public void setMatric(String matric) {
		this.matric = matric;
		System.out.println(matric);
		
	}
	
	public String getMatric() {
		return matric;
	}
	
	public void setGrade(double mark) {
		
		if(mark >= 80) {
			grade = "A";
		} else if (mark >= 75 && mark <= 79) {
			grade = "A-";
		} else if (mark >= 70 && mark <= 74) {
			grade = "B+";
		} else if (mark >= 65 && mark <= 69) {
			grade = "B";
		} else if (mark >= 60 && mark <= 64) {
			grade = "B-";
		} else if (mark >= 55 && mark <= 59) {
			grade = "C+";
		} else if (mark >= 50 && mark <= 54) {
			grade = "C";
		} else if (mark >= 45 && mark <= 49) {
			grade = "C-";
		} else if (mark >= 40 && mark <= 44) {
			grade = "D+";
		} else if (mark >= 35 && mark <= 39) {
			grade = "D";
		} else if (mark >= 0 && mark <= 34) {
			grade = "E";
		} else {
			grade = null;
		}
		setPointer();	
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setPointer() {
		if(grade == "A")
			pointer = 4.00;
		else if(grade == "A-")
			pointer = 3.67;
		else if(grade == "B+")
			pointer = 3.33;
		else if(grade == "B")
			pointer = 3.00;
		else if(grade == "B-")
			pointer = 2.67;
		else if(grade == "C+")
			pointer = 2.33;
		else if(grade == "C")
			pointer = 2.00;
		else if(grade == "C-")
			pointer = 1.67;
		else if(grade == "D+")
			pointer = 1.33;
		else if(grade == "D")
			pointer = 1.00;
		else if(grade == "E")
			pointer = 0.00;
	}
	
	public double getPointer() {
		coursePointer[i-1] = pointer;
		return pointer;
	}
	
	public void calculateOverallMark() {
		overallMark = 0;
		for(int i = 0; i < mark.length; i++) {
			overallMark += (mark[i] * creditHour[i]);
		}
		overallMark /= totalCreditHr;
	}
	
	public double getOverallMark() {
		calculateOverallMark();
		return overallMark;
	}
	
	public String getOverallGrade() {
		if(overallPointer >= 4.00) {
			overallGrade = "A";
		} else if (overallPointer >= 3.67 && overallPointer < 4.00) {
			overallGrade = "A-";
		} else if (overallPointer >= 3.33 && overallPointer < 3.67) {
			overallGrade = "B+";
		} else if (overallPointer >= 3.00 && overallPointer < 3.33) {
			overallGrade = "B";
		} else if (overallPointer >= 2.67 && overallPointer < 3.00) {
			overallGrade = "B-";
		} else if (overallPointer >= 2.33 && overallPointer < 2.67) {
			overallGrade = "C+";
		} else if (overallPointer >= 2.00 && overallPointer < 2.33) {
			overallGrade = "C";
		} else if (overallPointer >= 1.67 && overallPointer < 2.00) {
			overallGrade = "C-";
		} else if (overallPointer >= 1.33 && overallPointer < 1.67) {
			overallGrade = "D+";
		} else if (overallPointer >= 1.00 && overallPointer < 1.33) {
			overallGrade = "D";
		} else if (overallPointer >= 0 && overallPointer < 1.00) {
			overallGrade = "E";
		} else {
			overallGrade = null;
		}
		
		return overallGrade;
	};
	
	public double getOverallPointer() {
		overallPointer = 0;
		for(int i = 0; i < coursePointer.length; i++) {
			overallPointer += coursePointer[i];
		}
		overallPointer /= coursePointer.length;
		
		return overallPointer;
	}
	
	public String getOutput() {
		output = "<html>";
		output += "Entered Info <br><br>";
		output += "Matric No. : " + matric + "<br>";
		output += "Course : " + course + "<br>";
		output += "Carry Mark : " + courseMark + "<br>";
		output += "Grade : " + grade + "<br>";
		output += "Pointer : " + pointer + "<br>";
		output += "</htm>";
		
		return output;
	}
	
	public String getOverallOutput() {
		df.setRoundingMode(RoundingMode.UP);
		
		overallOutput = "<html>";
		overallOutput += "OVERALL <br><br>";
		overallOutput += "Matric No. : " + matric + "<br>";
		overallOutput += "Course : <br>";
		for(int i=0; i<courseCode.length; i++)
			overallOutput += courseCode[i] + "<br>";
		overallOutput +="Overall Mark : " + df.format(overallMark) + "<br>";
		overallOutput += "Grade : " + overallGrade + "<br>";
		overallOutput += "Pointer : " + df.format(overallPointer) + "<br>";
		overallOutput += "</htm>";
		
		return overallOutput;
	}
}
