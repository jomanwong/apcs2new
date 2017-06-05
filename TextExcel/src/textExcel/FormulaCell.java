package textExcel;

public class FormulaCell extends RealCell {

	private String userInput; // ( * + * )

	public FormulaCell(String in) {
		super(in);
		this.userInput = in;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String abbreviatedCellText(){ //TODO: use recursion that calls itself when method is entered.
		//It checks the value of the cell it references, aka set value again.
		String abbreviatedText = getDoubleValue(userInput) + "";

		if(abbreviatedText.length() > 10){    

			abbreviatedText = abbreviatedText.substring(0, 10);
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
		return userInput;
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


	@Override //what about order of operations?
	//Handling zeroes? - solved as add or subtract from zeroes doesn't change, multi by 0 = 0, but, can't divide from zero
	public double getDoubleValue(String in){
		//Cell[][] ss = Spreadsheet.spreadSheet;
		//String str = in.substring(2, in.length() - 2); instead of splitting and take away neg's, split then make new array
		String[] temp = in.split(" "); //split at spaces, results in [ (][#][+][#][)] //BUT WHAT IF IT'S JUST 1 NUMBER ( # ) -> [(][#][)]
		String[] inParts = new String[temp.length - 2]; //takes off the two darn parenthesis that were secretly plotting to overthrow me

		//
		//wish .clone() could have start and end points

		for(int j = 0; j < inParts.length; j ++){ //FILL THIS!!
			inParts[j] = temp[j + 1]; //takes off the two darn parenthesis that were secretly plotting to overthrow me
		}

		double returnThis = Double.parseDouble(inParts[0]);

		if(inParts[0].equalsIgnoreCase("sum") || inParts[0].equalsIgnoreCase("avg")) { //[RangeA][-][RangeB]
			/*int nCells = 0;
			double avg = 0.00;
			returnThis = 0.00;

			SpreadsheetLocation rangeA = new SpreadsheetLocation(inParts[0]); //omg srsly why haven't I thought of using just location
			SpreadsheetLocation rangeB = new SpreadsheetLocation(inParts[1]); //no more hard coding it with array locations, yassss, thanks random statckexchange user

			for(int i = rangeA.getRow() + 1; i <= rangeB.getRow() + 1; i++){ //range a to b
				for(int j = rangeA.getCol() + 1; j <= rangeB.getCol() + 1; j++){
					if(ss[i][j] instanceof FormulaCell){
						returnThis += ((RealCell) ss[i][j]).getDoubleValue(ss[i][j].fullCellText()); //cast to realCell for easier calculation
					}else{
						returnThis += Double.valueOf(ss[i][j].fullCellText());
					}
					nCells ++; //counted 1 more cell
				}

			}
			avg = returnThis/nCells;
			if(nCells > 1 && inParts[0].equalsIgnoreCase("avg")){ //if it calls to find average and there's actually a need to find average
				returnThis = avg;
			}*/
		}else if(inParts[0].equalsIgnoreCase("[A-L][0-20]")){
			
			
		}else if(inParts.length == 3){ //if not calling to find "sum" or "avg"
			if(inParts[1].equals("+")) { 					//addition 
				returnThis += Double.parseDouble(inParts[2]);
			}else if(inParts[1].equals("-")) { 				//subtraction
				returnThis -= Double.parseDouble(inParts[2]);
			}else if(inParts[1].equals("*")) { 				//multiplication
				returnThis *= Double.parseDouble(inParts[2]);
			}else{
				if(inParts[1].equals("/")) { 				//division (honestly, as last choice it doesn't need to check if, but a good error catch...
					//if there are no other number or formula.
					returnThis /= Double.parseDouble(inParts[2]);
				}
			}
		}else{
			for(int i = 0; i < inParts.length - 1; i += 2){ //first, then skips the operation sign 
				//Then, check operations, until end
				if(inParts[i + 1].equals("+")) { 					//addition 
					returnThis += Double.parseDouble(inParts[i + 2]);
				}else if(inParts[i + 1].equals("-")) { 				//subtraction
					returnThis -= Double.parseDouble(inParts[i + 2]);
				}else if(inParts[i + 1].equals("*")) { 				//multiplication
					returnThis *= Double.parseDouble(inParts[i + 2]);
				}else{
					if(inParts[i + 1].equals("/")) { 				//division (honestly, as last choice it doesn't need to check if, but a good error catch...
						//if there are no other number or formula.
						returnThis /= Double.parseDouble(inParts[i + 2]);
					}
				}
			}
		}

		//returnThis = Double.parseDouble(inParts[0]);


		/*if(inParts[0].substring(0, 1).contains("[A-L]")){
			inParts[0] = inspectCell(inParts[0]) + "";
		}

		if(inParts.length > 1 && inParts[2].substring(0, 1).contains("[A-L]")){
			inParts[2] = inspectCell(inParts[2]) + "";
		}*/


		return returnThis * 1.0;
	}

}
