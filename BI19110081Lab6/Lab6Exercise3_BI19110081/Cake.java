abstract class Cake {
	
    String name;
    String [] topping;
    String [] toppingOrder;
    double priceSmall; double priceMedium; double priceBig, totalPrice;
    int size; int quantity;
    Cake (String name){
        this.name = name;
    }
    
    
    abstract void setCake (String [] topping, double priceSmall, double priceMedium, double priceBig);
   
    void orderCake (String [] toppingOrder, int quantity, int size){
        this.toppingOrder = toppingOrder ;
        this.quantity = quantity;
        this.size = size;
    } 
    double getSizePrice (int size){
        if (size==1) {return priceSmall;}
        else if (size==2){return priceMedium;}
        else if (size==3){return priceBig;}
        else return 0;
    }
    double getTotalPrice (){
        double totalPrice = getSizePrice(size)*quantity+(toppingOrder.length*10);
        return totalPrice;
    }
    String getSize (){
        if (size==1)return "small";
        else if (size==2)return "medium";
        else if (size==3)return "big";
        else return "invalid";
    }
    public int getQuantity(){
      return quantity;  
   }
    
    //return print order to GUI call
   public String printOrder_GUI(){
      String print = "\n\nCake Order detail:\n";
      String line = "-------------------------------------------\\n";
      print += line;
      print += "Topping Order: \n";
      for(int i=0; i<toppingOrder.length; i++){
         print += "(" + (i+1) + ") " + toppingOrder[i] + " \n";
      } 
      print += "\nSize        : " + getSize() + "\n";
      print += "Quantity : " + getQuantity() + "\n";
      print += line;
      print += "Total Price: RM" + getTotalPrice() + "\n"; 
      print += line; 
      return print;
   } 
}
    class BlackForest extends Cake {
        BlackForest (String name ){
            super (name);
    }

        void setCake (String [] topping, double priceSmall, double priceMedium, double priceBig){
        this.topping = topping;
        this.priceSmall = priceSmall;
        this.priceMedium = priceMedium;
        this.priceBig = priceBig;
        }
    
} 