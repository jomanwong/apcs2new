import java.util.Arrays;
/** latest version 
 * 
 * @author Joman
 *
 */
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

		String sandwich1 = "appletomatohamcheese"; //no bread - hmmm... what is a sandwich anyways?
		String sandwich2 = "appletomatoBreadkasetomatolettuce"; //one bread - There is only one bread, is it a toast?
		String sandwich3 = "appletomatoBreadkasehamtomato lettucebread milk"; //two bread(proper sandwich) - [kasetomatolettuce]
		String sandwich4 = "apple tomatoBreadkasehamtomato lettucebread milk bread"; //three bread - Not a sandwich.
		String sandwich5 = "breadbreadbreadbreadbread"; //only bread - Not a sandwich.
		String sandwich6 = "bread bread bread bread bread"; //only bread with spaces - Not a sandwich.
		String sandwich7 = "apples pineapples bread lettus tomato bacon mayo ham bread cheese"; //two bread given example - [lettustomatobaconmayoham]
		//String[] test = sandwich3.split(" ");
		//String testPrint = Arrays.toString(test);
		System.out.println("sandwhich1 -- " + splitAtBread(sandwich1));
		System.out.println("sandwhich2 -- " + splitAtBread(sandwich2));
		System.out.println("sandwhich3 -- " + splitAtBread(sandwich3));
		System.out.println("sandwhich4 -- " + splitAtBread(sandwich4));
		System.out.println("sandwhich5 -- " + splitAtBread(sandwich5));
		System.out.println("sandwhich6 -- " + splitAtBread(sandwich6));
		System.out.println("sandwhich7 -- " + splitAtBread(sandwich7));
		//System.out.println(testPrint);
	}

	public static String splitAtBread(String userInput){
		String inputLowercase = userInput.toLowerCase();
		if(inputLowercase.indexOf("bread") == -1){ //no bread
			return "hmmm... what is a sandwich anyways?";
		}
		String[] inputNoSpaceAsArray = inputLowercase.split(" ");
		String inputNoSpaceAsString = Arrays.toString(inputNoSpaceAsArray);
		String inputNoSpaceNoCommas = inputNoSpaceAsString.replaceAll(",", "");
		String inputNoSpaceNoCommasAndNoSpace = inputNoSpaceNoCommas.replaceAll(" ", "");
		String[] inputNoSpace = inputNoSpaceNoCommasAndNoSpace.split("bread");
		if(inputNoSpace.length == 2){//1 bread
			return "There is only one bread, is it a toast?";
		}else if(inputNoSpace.length == 3){//2 bread
			String[] arrToReturn = Arrays.copyOfRange(inputNoSpace, 1, 2);
			return Arrays.toString(arrToReturn);
		}else{
			return "Not a sandwich.";
		}
	}
}

