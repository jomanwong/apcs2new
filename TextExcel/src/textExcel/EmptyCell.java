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
		return "1234567890" ;
	}

}
