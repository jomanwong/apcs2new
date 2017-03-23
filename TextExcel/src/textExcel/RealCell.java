package textExcel;

public class RealCell implements Cell {
	
	private String contents;
	
	public RealCell(String in){
		this.contents = in;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return "          ";
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return this.contents;
	}
	
	public double getDoubleValue(String doubleStr){
		return Double.parseDouble(doubleStr);
	}

}
