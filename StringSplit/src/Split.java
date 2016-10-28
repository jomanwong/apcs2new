import java.util.Arrays;
/** latest version */
public class Split {

	public static void main(String[] args){

		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]

		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?


		//Your task:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		 */


		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		 */

		String sandwich1 = "applespineapplesbreadlettustomatobaconmayohambread"; //designated place for easier location, could be simplified
		/** make into method, the following */
		/*if(isOnlyBread(splittedString)){
			System.out.println("Is only bread, you sure it's not a loaf of bread?");
		}*/
		splitAtBread(sandwich1);
	}

	public static String splitAtBread(String input){
		String inputBackUp = input;
		input = input.toLowerCase();
		input = input + " "; //this part is important, adds a space to the end, so it will still have 3 parts if ended on 2nd bread
		String[] output = input.split("bread"); //only 2 pieces of bread, or less, input is array now
		if(input.length() == 3){ //only 3 parts if it is 2 bread
			return (Arrays.toString(output));
		}
	}

	public static boolean isOnlyBread(String[] in){ //bread bread bread
		int breadCount = 0;
		for(String i: in){
			if(i.indexOf(" ") >= 0){
				if(i.indexOf("bread") >= 0){
					breadCount++;
				}
			}else if(i.indexOf("bread") >= 0){
				breadCount++;
			}
		}
		if(breadCount == in.length){
			return true;
		}else{
			return false;
		}
	}
}

