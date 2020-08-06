class TestCake {

	public static void main(String[] args) {
		Cake c = new Cake("Generic");
		String[]topping = {"Lava Chocolate", "Cream Cheese", "Butter Cream", "Fondant"};
		c.setCake(topping, 45.00, 65.00, 80.00);
		c.printCake();
		String[] order = {"Lava Chocolate", "Cream Cheese"};
		c.orderCake(order, 1, 2);
		c.printOrder();
	}

}

class Cake{
	String name;
	String[] topping = new String[4];
	String[] toppingOrder = new String[4];
	double priceSmall;
	double priceMedium;
	double priceBig;
	double totalPrice;
	int size, quantity;
	
	Cake(String cakeName){
		name = cakeName;
	}
	
	 void setCake(String[]topping, double priceSmall, double priceMedium, double priceBig){
		this.topping = topping;
		this.priceSmall = priceSmall;
		this.priceMedium = priceMedium;
		this.priceBig = priceBig;
	}
	
	 void orderCake(String[]toppingOrder, int quantity, int size) {
		this.toppingOrder = toppingOrder;
		this.quantity = quantity;
		this.size = size;
	}
	
	double getSizePrice() {
		if(size==1) {
			return priceSmall;
		}
		else if(size==2) {
			return priceMedium;
		}
		else  {
			return priceBig;
		}
	}
	
	 double getTotalPrice() {
		return totalPrice = getSizePrice() * quantity + (toppingOrder.length*10);
	}
	
	String getSize() {
		if(size == 1) {
			return "Small";
		}else if(size == 2) {
			return "Medium";
		}else {
			return "Big";
		}
	}
	
	 void printCake() {
		System.out.println("-----------------------");
		System.out.println("       Cake Menu       ");
		System.out.println("-----------------------");
		System.out.println("Generic Cake with available toppings: ");
		
		for(int i=0; i < topping.length; i++) {
			System.out.println(i+1 + ") " + topping[i]);
		}
		
		System.out.println("\nPrice:");
		System.out.println("[1] Small  : RM" + priceSmall);
		System.out.println("[1] Medium : RM" + priceMedium);
		System.out.println("[1] Big    : RM" + priceBig);
	}
	
	 void printOrder() {
		System.out.println("\n\nCake Order detail:");
		System.out.println("-----------------------");
		System.out.print("Topping :");
		
		for(int i=0; i < toppingOrder.length; i++) {
			System.out.print(" " + (i+1) + ")" + toppingOrder[i]);
		}
		
		System.out.println("\nSize    : " + getSize());
		System.out.println("-----------------------");
		System.out.println("Total Price : RM" + getTotalPrice());
		System.out.println("-----------------------");
	}
	
}