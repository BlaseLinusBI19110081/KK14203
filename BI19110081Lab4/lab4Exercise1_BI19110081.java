import java.text.DecimalFormat;

class demoFinance{
   public static void main(String[] args){
   Finance sem1 = new Finance();
   sem1.setSem((byte)1);
   sem1.setSession("2016/2017");
   sem1.setFees(3000.0);
   sem1.setLastPayDate("13-09-2016");
   sem1.setLastCredit(1000);
   sem1.print();
   
   Finance sem2= new Finance((byte)2, "2016/2017", 3000, 2000, "14-02-2017");
   sem2.print();
   }
}

class Finance{
   private byte Sem;
   private String Session;
   private double Fees;
   private double totalCredit;
   private double remainingDebit;
   private String lastPayDate;
   private double lastCredit;
   
   //mutator
   public void setSem(byte Sem){
      this.Sem = Sem;
   }
   
   public void setSession(String Session){
      this.Session = Session;
   }
   
   public void setFees(double Fees){
      this.Fees = Fees;
   } 
   
   public void setLastPayDate(String lastPayDate){
      this.lastPayDate = lastPayDate;
   }
   
   public void setLastCredit(double lastCredit){
      this.lastCredit = lastCredit;
   }
   
   //method
   public double calculateDebit(){
      remainingDebit = Fees - totalCredit;
      return remainingDebit;
   }
   
   public void payment(double lastCredit, String lastPayDate){
      totalCredit += lastCredit;
      remainingDebit = calculateDebit();
   }
      
   //constructor
   public Finance(){
      Sem = 1;
      Session = " ";
      lastPayDate = " ";
      totalCredit = 0;
      lastCredit = 0;
      Fees = 2000.0;
      remainingDebit = 2000.0;
   }
   
   //parameterised constructor
   public Finance(byte Sem, String Session, double Fees, double lastCredit, String lastPayDate){
      this.Sem = Sem;
      this.Session = Session;
      this.Fees = Fees;
      this.lastCredit = lastCredit;
      this.lastPayDate = lastPayDate;
      payment(lastCredit, lastPayDate);
      calculateDebit();
   }
   
   public void print(){
      System.out.println("Sem: " + Sem + " Session: " + Session);
      System.out.println("Fees: " + Fees + " Remaining: " + remainingDebit);
      System.out.println("Last payment: " + lastCredit + " on " + lastPayDate);
   }
}