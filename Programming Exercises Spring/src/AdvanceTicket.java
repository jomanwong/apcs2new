
public class AdvanceTicket extends Tickets{
	//XXX VARS HERE
	private double price;

	if(super.getDaysBeforeEvent >= 10){
		this.price = 30.0;
	}else if(super.getDaysBeforeEvent > 0){
		this.price = 40.0;
	}else{
		System.out.println("Do not sell ticket, event has passed.");
	}
		
}
