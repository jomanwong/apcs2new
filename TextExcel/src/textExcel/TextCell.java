package textExcel;

public class TextCell implements Cell {
	//spreadsheet 
	
	private String stringStored;

	public TextCell(String in){
		this.stringStored = in;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return this.stringStored;
	}

}
