class demoStudent_UMS {
	public static void main(String[] args) {
		Student_UMS Student_1 = new Student_UMS();
		Student_1.setname("Aali");
		Student_1.setmatric("BI1231");
		Student_1.setage((byte)20);
		Student_1.setCurrentSemester((byte) 1);
		Student_1.setCohort("2015/2016");
		Student_1.printStudent();
		
		Finance Finance_1 = new Finance((byte)1, "2015/2016", 3000, 1000, "16-04-2016");
		Student_1.newRecord(Finance_1);
		Finance_1.printFinance();
		System.out.println();
		Student_1.updatePayment((byte)1, "2015/2016", 1000, "16-12-2016");
		Student_1.printRecord();
		
	}
	
}

 class Student_UMS extends Student{

	private byte currentSemester;
	private Finance financeRecord[];
	private byte TotalFinanceRecord=0;
	private String cohort;
	
	public Student_UMS() {
		initStudent();
	}
	
	public void initStudent() {
		this.financeRecord = new Finance[20];
		this.currentSemester = 1;
		this.cohort = "2017/2018";
	}
	
	public void updateTotalFinanceRecord() {
		this.TotalFinanceRecord++;
	}
	
	public void updatePayment(byte sem, String session, double lastCredit, String lastPayDate) {
		financeRecord[TotalFinanceRecord] = new Finance();
		if(currentSemester==sem && this.cohort.equals(session) ) {
			financeRecord[TotalFinanceRecord].getSemester(sem);
			financeRecord[TotalFinanceRecord].getSession(session);
			financeRecord[TotalFinanceRecord].payment(lastCredit, lastPayDate);
			
		}
		else {
			System.out.println("Record Not Found!");
		}
	}
	
	public void newRecord(Finance obj) {
		financeRecord[TotalFinanceRecord] = obj;
		updateTotalFinanceRecord();
	}
	
	public void setCurrentSemester(byte sem){
		this.currentSemester = sem;
	}
	
	public void setCohort(String cohort){
		this.cohort = cohort;
	}
	
	public byte getCurrentSemester() {
		return this.currentSemester;
	}
	
	public String getCohort() {
		return this.cohort;
	}
	
	public void printRecord() {
		financeRecord[TotalFinanceRecord].printFinance();
	}
	
}

class Student
{
	private String name, matric;
	private byte age;
	
	public Student(){
		name = " ";
		matric = " ";
		age = 0;
	}
	
	Student(String a, String b, byte c){
		name = a;
		matric = b;
		age = c;		
	}
	
	public void setname(String name){
		this.name = name;
	}
	
	public void setmatric(String matric){
		this.matric = matric;
	}
	
	public void setage(byte age){
		this.age = age;
	}
	
	
	public String getname() {
		return this.name;
	}
	
	public String getmatric() {
		return this.matric;
	}
	
	public byte getage() {
		return this.age;
	}
	
	public void printStudent(){
		System.out.println ("Name: "+getname()+"\nMatric number: "+getmatric()+"\nAge: "+getage());
		System.out.println();
	}
		
	
	
	
}
 class Finance {
	private byte sem;
	private String session, lastPayDate;
	private double fees;
	private double totalCredit;
	private double remainingDebit;
	private double lastCredit;
	
	public Finance(){
		this.sem = 1;
		this.session = "";
		this.lastPayDate = "";
		this.totalCredit = 0;
		this.lastCredit = 0;
		this.fees = 2000;
		this.remainingDebit = 2000;
	}
	
	public void getSemester(byte sem) {
		this.sem = sem;
	}
	
	public Finance(byte sem, String session, double fees, double lastCredit, String lastPayDate){
		this.sem = sem;
		this.session = session;
		this.fees = fees;
		payment(lastCredit, lastPayDate);
		calculateDebit();
	}
	
	public void getFees(double fee){
		this.fees = fee;
	}
	
	public void getSession(String session){
		this.session = session;
	}
	
	public void calculateDebit(){
		this.remainingDebit = fees - totalCredit;
	}
	
	public void printFinance(){
		System.out.println("Sem: " + sem + "	Session: " + session);
		System.out.println("Fees: RM"+ fees + "	Remaining: RM" + remainingDebit);
		System.out.println("Last Payment: RM" + lastCredit + " on " + lastPayDate);
	}	
	
	public String giveSession() {
		return this.session;
	}
	
	public byte giveSem() {
		return this.sem;
	}
	
	public void payment(double lastCredit, String lastPayDate){
		this.lastCredit = lastCredit;
		this.lastPayDate = lastPayDate;
		this.totalCredit+=lastCredit;
		calculateDebit();
	}
	
	
}