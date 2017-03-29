package textExcel;


public class PercentCell extends RealCell {
	
	private String percentValue;
	
	public PercentCell(String in) {
		super(in);
		this.percentValue = in; //stores 
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String abbreviatedCellText(){
		String abbreviatedText = this.percentValue.substring(0, this.percentValue.indexOf('.')) + "%";
		//autofill spaces
		while(abbreviatedText.length() < 10){
			
			abbreviatedText += " ";

		}
		
		return abbreviatedText;
	}
	
	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return "" + getDoubleValue(percentValue);
	}
	
	@Override
	public double getDoubleValue(String percent){ //could hardcode it to change percentValue, but it's more safe imo this way
		double returnThis;
		percent = percent.substring(0, percent.length() - 1); //takes out '%' Note could use indexOf, but this takes less iterations
		returnThis = Double.parseDouble(percent);
		returnThis = returnThis / 100;
		return returnThis;
	}
	
}
