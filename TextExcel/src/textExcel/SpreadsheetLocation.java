package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{

	private int rows; // not private final variables because needs to be computed
	private int cols; // not private final variables because needs to be computed
	private String coords; //short for coordinates i.e. "D20"
	
    @Override
    public int getRow(){
    	
        // TODO Auto-generated method stub
    	this.rows =  Integer.parseInt(coords.substring(1)); //cuts out A-L
        return this.rows - 1;
    }

    @Override
    public int getCol(){
    	
        // TODO Auto-generated method stub
    	this.cols = coords.charAt(0); //set to numerical value of first character of coords, value according to ASCII (or unicode?)
        return this.cols - 65; //calculation using ASCII (or unicode?)
    }
    
    public SpreadsheetLocation(String cellName){
    	
        // TODO: Fill this out with your own code
    	this.coords = cellName.toUpperCase(); //apparently there is a test with lowercase user inputs
    }

}
