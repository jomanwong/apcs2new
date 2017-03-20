package textExcel;

public class EmptyCell implements Cell {

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return "          ";
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		//return "          ";
		//in place to show it actually works \/
		return "" ; //thought it want 10 spaces for empty cell?? But on test cases it asks for empty string, or 10 spaces applies only to abbreviated for printing purposes
	}

}
