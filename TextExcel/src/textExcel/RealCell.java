package textExcel;

abstract class RealCell implements Cell {

	private String contents;

	public RealCell(String in){
		this.contents = in + "";
	}

	@Override
	public String abbreviatedCellText() {
		String abbreviatedText = contents;
		
		if(abbreviatedText.length() > 10){    

			abbreviatedText = contents.substring(0, 10);
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
		return getDoubleValue(this.contents) + "";
	}

	public double getDoubleValue(String doubleStr){ 
		return Double.parseDouble(doubleStr);
	}

}
