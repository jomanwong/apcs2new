
public abstract class Tickets {
	//XXX vars here
	private int number;
	private double price;
	private int daysBeforeEvent;
	
	//construct a ticket
	public Tickets (int number, int daysBefore){
		this.number = number;
		this.daysBeforeEvent = daysBefore;
	}
	
	public Tickets(){

	}
	
	public int getDaysBeforeEvent(){
		return daysBeforeEvent;
	}
	
	//returns price, price is not declared here in the superclass
	public abstract double getPrice();
	
	//overrides the java.lang.Object.toString
	public String toString(){
		return "Number: " + this.number + ", Price: " + this.price;
	}
}	
