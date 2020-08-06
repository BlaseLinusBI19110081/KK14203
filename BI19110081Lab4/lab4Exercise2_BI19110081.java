import java.util.*;
import java.util.List;

class DemoMenu{
   public static void main(String[]args){
      Menu list = new Menu();
      list.displayNormalArray();
      list.displayArrayList();
   }
}

class Menu{
   public void displayNormalArray(){
      String[][] Menu = {{"1", "2", "3"}, {"Nasi Lemak", "Roti", "Teh Tarik"}, {"2.00", "1.00" , "1.50"}}; 
      System.out.println("id\t" + "Menu Name\t" + "Price");
      for(int j = 0; j < 3; j++){
         for(int i = 0; i < 3; i++){
            System.out.print(Menu[i][j] + "\t");
            if(Menu[i][j] == "Roti"){
               System.out.print("\t\t");
            }
         }
         System.out.println();   
      }
    }
    
    public void displayArrayList(){
      ArrayList row1 = new ArrayList();
      ArrayList row2 = new ArrayList();
      ArrayList row3 = new ArrayList();
      row1.add("1");
      row1.add("Nasi Lemak");
      row1.add("2.00");
      
      row2.add("2");
      row2.add("Roti");
      row2.add("1.00");
      
      row3.add("3");
      row3.add("Teh Tarik0");
      row3.add("1.50");
      
      System.out.println("id\t" + "Menu Name\t" + "Price");
      for(int i = 0; i < 3; i++){
         switch (i){
            case 0:
               System.out.println(row1);
               break;
            case 1:
               System.out.println(row2);
               break;
            case 2:
               System.out.println(row3);
               break;
            default:
               break;
          }
               
      }
        
    }  
}




