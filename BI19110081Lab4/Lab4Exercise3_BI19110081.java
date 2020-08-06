import java.util.*;
import java.util.List;

class DemoMenu{
    public static void main(String[] args)
    {
        Menu food = new Menu();
        food.Order();
    }
}

class Menu{
    private double sum;
    int menu_size = 4;
    ArrayList<ArrayList<String>> menu = new ArrayList<>(menu_size);
    
    void addMenu(){
        for(int i=0; i < menu_size; i++) {
            menu.add(new ArrayList());
        }
            
        menu.get(0).add("1");
        menu.get(0).add("Nasi Lemak");
        menu.get(0).add("2.00");
            
        menu.get(1).add("2");
        menu.get(1).add("Roti\t");
        menu.get(1).add("1.00");
            
        menu.get(2).add("3");
        menu.get(2).add("Teh Tarik");
        menu.get(2).add("1.50");
            
        menu.get(3).add("4");
        menu.get(3).add("Kopi-O\t");
        menu.get(3).add("1.00");                       
    }
    
    void displayMenu(){
        System.out.println("ID\tMenu Name\tPrice(RM)");
        
        for(List<String> row : menu){
            for(int i = 0; i < 3; i++){
                System.out.print(row.get(i));
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }
    
    void Order(){
        Scanner reader = new Scanner(System.in);
        int order_size = 4;
        ArrayList<ArrayList<String>> custORDER = new ArrayList<>(order_size);
        
        for(int i=0; i < order_size; i++) {
            custORDER.add(new ArrayList());
        }
        
        int c = 0;
        int opt = 0;
        char input = 'o';
        int quantity;
        String fname, price;
        
        addMenu();
        displayMenu();
            
	    System.out.print("\nChoose menu: ");
	    input = reader.next().charAt(0);
        
       while (input != 'q'){    
	        opt = Integer.parseInt(String.valueOf(input)) - 1;
	        fname = menu.get(opt).get(1);
	        custORDER.get(c).add(fname);
            
	        System.out.print(custORDER.get(c).get(0) + " - Quantity: ");
           quantity = reader.nextInt();
           
           custORDER.get(c).add(Integer.toString(quantity));
	        custORDER.get(c).add("RM " + menu.get(opt).get(2));

	        sum += quantity * Multiplier(input);
	        System.out.print("\n"); 
           c++;
            
           displayMenu(); 
	        System.out.print("\nChoose menu: ");
	        input = reader.next().charAt(0);
	        }
	        
	        System.out.println("\nThe Order Details is below: \n");
	        for(int i = 0; i < c; i++){
                for(int j = 0; j < 3; j++){
                    System.out.print(custORDER.get(i).get(j));
                    if(j == 1){
                        System.out.print("\tX");
                    }
                    System.out.print("\t");
                }
                System.out.print("\n");
            }
            System.out.println("\nTOTAL PRICE: RM " + sum);
	    }

    double Multiplier (char input){
        double multiplier = 0;
        
        switch(input){
            case '1':
               multiplier = 2.00;
               break;
            case '2':
               multiplier = 1.00;
               break;
            case '3':
               multiplier = 1.50;
               break;
            case '4':
               multiplier = 1.00;
               break;
            default: 
               break;
        }
        return multiplier;
    }
}

