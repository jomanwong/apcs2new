package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	
	public static void Spreadsheet(){
		/**XXX FORMAT XXX
		 * 3 spaces, left justified, space(s) could be taken by row number
		 * then "|", followed by 10 spaces, and "|"
		 * repeat, until reaches 12th column
		 */
		
		// array to store spreadsheet info String[][] spreadSheet = new String
		
		System.out.println("   |A         |B         |C         |D         |E         |F         |G         |" +
				"H         |I         |J         |K         |L         |");
		for(int i = 1; i <= 20; i++){
			if(i < 10){
				System.out.println(i + "  |"/*2 spaces followed by |*/ + "          |          |          |" +
						"          |          |          |          |          |          |          |"+
						"          |          |");
		
			}else{
				System.out.println(i + " |"/*1 space followed by |*/ + "          |          |          |" +
						"          |          |          |          |          |          |          |"+
						"          |          |");
			}
		}
	}
	
	
	@Override
	public String processCommand(String command){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRows(){
		// TODO 20 rows are required
		return 20;
	}

	@Override
	public int getCols(){
		// TODO 12 columns are required
		return 12;
	}

	@Override
	public Cell getCell(Location loc){
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public String getGridText(){
		// TODO Auto-generated method stub
		return null;
	}

}
