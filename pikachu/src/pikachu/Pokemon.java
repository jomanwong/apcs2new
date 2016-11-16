package pikachu;
import java.util.*;
//Made by Joman Wong, 8/29/16, APCS2
public class Pokemon {
	public static void main(String[]args){
		Scanner keyboard = new Scanner(System.in);
		String line = null;
		while(!(line = keyboard.nextLine()).isEmpty()) {
			String[] values = line.split("\\s+");
			System.out.print("entered: " + Arrays.toString(values) + "\n");
		}
		System.out.print("Bye!");

	}
}
