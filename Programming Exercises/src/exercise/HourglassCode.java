package exercise;

public class HourglassCode {
	public static void main(String[]args){
		PrintTopAndBottomLine();
		//prints top half
		String s = "::";
		System.out.print("\\");
		for(int j = 4; j > 0; j--){
			System.out.print(s);
		}
	}
	public static void PrintTopAndBottomLine(){
		System.out.print("|");
		for(int i = 0; i < 10; i++){
			System.out.print("\"");
		}
		System.out.println("|");
	}
}
