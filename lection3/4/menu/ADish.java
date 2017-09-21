package menu;

public abstract class ADish implements IDish{

	private final String name;
	private int price;
	
	public ADish(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getDiscountPrice() {
		return (int)(price*0.1);
	}
	
	public abstract void printInform();

	
	
}
