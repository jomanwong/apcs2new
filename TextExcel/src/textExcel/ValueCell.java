package textExcel;

public class ValueCell extends RealCell {

	private String valueStored;

	public ValueCell(String in) {
		super(in);
		this.valueStored = in;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String abbreviatedCellText(){
		String abbreviatedText = valueStored;
		
		if(abbreviatedText.length() > 10){    

			abbreviatedText = valueStored.substring(0, 10);
			return abbreviatedText;

		}else{
			//autofill spaces
			while(abbreviatedText.length() < 10){

				abbreviatedText += " ";

			}

			return abbreviatedText;
		}

		public String fullCellText() {

		}
	}
