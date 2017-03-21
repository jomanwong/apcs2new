package textExcel;

public class TextCell implements Cell {
	//spreadsheet 

	private String stringStored;

	public TextCell(String in){
		this.stringStored = in;
	}

	@Override
	public String abbreviatedCellText() {
		
		String abbreviatedText = stringStored;
		
		if(stringStored.charAt(0) == '\"'){  //has to be first to pass testEmptyStrinCell, probably because the test tests empty quotation marks
			
			abbreviatedText = stringStored.substring(1, stringStored.length() - 1);
			
		}
		
		if(abbreviatedText.length() > 10){    
			
			abbreviatedText = stringStored.substring(1, 11);
			return abbreviatedText;
			
		}else{
			
			//autofill spaces
			while(abbreviatedText.length() < 10){
				
				abbreviatedText += " ";

			}
			
			return abbreviatedText;
			
		}
	}
	
	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return this.stringStored;
	}
	
	

}
