import java.util.Arrays;
/** latest version */
public class Split {

	public static void main(String[] args){

		/*String.split();
		It's a method that acts on a string, <StringName>.split(<String sp>);
		Where sp is the string where the string splits
		And it returns an array
		 Example: "I like apples!".split(" "); 
				it will split at spaces and return an array of ["I","like","apples!"]
		 Example 2: "I really like really red apples"split("really")
				it will split at the word "really" and return an array of ["I "," like "," apples!"] */

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

		String sandwich1 = "appletomatohamcheese"; //designated place for easier location, could be simplified
		String sandwich2 = "";
		String sandwich3 = "";
		String sandwich4 = "";
		String sandwich5 = "";
		String sandwich6 = "";
		/** make into method, the following */
		System.out.println(splitAtBread(sandwich1));
	}

	public static String splitAtBread(String userInput){
		String inputInstance = userInput.toLowerCase();
		if(inputInstance.indexOf("bread") == -1){ //no bread
			return "hmmm... what is a sandwich anyways?";
		}
		String[] input = inputInstance.split("bread");
		if(input.length == 2){//1 bread
			return "There is only one bread, is it a toast.";
		}else if(input.length == 3){//2 bread
			return input[1].toString();
		}else{
			return "Not a sandwich";
		}
	}
}

