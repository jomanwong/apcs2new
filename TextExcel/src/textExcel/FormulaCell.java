package textExcel;

public class FormulaCell extends RealCell {
	
	private String userInput; // ( * + * )

	public FormulaCell(String in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String abbreviatedCellText(){ //use recursion that calls itself when method is entered. It checks the value of the cell it references, aka set value again
		String abbreviatedText = userInput;

		abbreviatedText = getDoubleValue(abbreviatedText) + "";
		
		if(abbreviatedText.length() > 10){    

			abbreviatedText = userInput.substring(0, 10);
			return abbreviatedText;

		}else{
			//autofill spaces
			while(abbreviatedText.length() < 10){

				abbreviatedText += " ";

			}

			return abbreviatedText;
		}
	}
	
	public String fullCellText() {
		return getDoubleValue(userInput) + "";
	}
	
	public String inspectCell(String cell){
		//returns content of cell
		SpreadsheetLocation loc = new SpreadsheetLocation(cell); //thx to Mr DeHeer pointing out I could use SpreedsheetLocation
		return getCell(loc).fullCellText();
	}
	
	public Cell getCell(Location loc){
		// TODO Auto-generated method stub
	
		return Spreadsheet.spreadSheet [loc.getRow()][loc.getCol()]; //note to self, notice method returns type Cell, not String
	}

	
	@Override
	public double getDoubleValue(String in){
		double returnThis;
		in = in.substring(2, in.length() - 2); //"* + *"
		String[] formParts = in.split(" "); //no need to use unit like in Spreadsheet [*][+][*]
		//parse to a double
		//Double val = Double.parse(str);
		
		return returnThis;
	}

}
