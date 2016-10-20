import java.util.Date;

public class DoMath {

	public static void main(String[] args) {

		testDoMath("testing square with 5", 25, Calculate.square(5));
		testDoMath("testing square with -2", 4, Calculate.square(-2));
		testDoMath("testing cube with 3", 27, Calculate.cube(3));
		testDoMath("testing average 2 numbers with 2 & 4", 3.0, Calculate.average(2.0, 4.0));
		testDoMath("testing average 2 numbers with -5.0 & 5.0", 0.0, Calculate.average(-5.0,5.0));
		testDoMath("testing average 3 numbers with -5, 2, 15", 4.0, Calculate.average(-5.0,2,15));
		testDoMath("testing toDegrees with 5", 286.479, Calculate.toDegrees(5.0),.001);
		testDoMath("testing toDegrees with -3", -171.887, Calculate.toDegrees(-3.0),.001);
		testDoMath("testing toRadians with 190 degrees", 3.31613, Calculate.toRadians(190.0), .001);
		testDoMath("testing discriminant with 5, 4, & 3 ",-44.0 ,Calculate.discriminant(5.0,4.0,3.0));
		testDoMath("testing toImproperFrac with 3, 1, 4 ","13/4", Calculate.toImproperFrac(3,1,4));
		testDoMath("testing toMixedNum with 7/2","3_1/2", Calculate.toMixedNum(7,2));
		testDoMath("testing toMixedNum with -9/3","-3", Calculate.toMixedNum(-9,3));
		testDoMath("testing foil with 2,3,6,-7,x","12x^2 + 4x – 21", Calculate.foil(2,3,6,-7,"x"));
		testDoMath("testing isDivisibleBy with 9 and 3", true, Calculate.isDivisibleBy(9,3));
		testDoMath("testing isDivisibleBy with 8 and 3",false, Calculate.isDivisibleBy(8,3));
		testDoMath("testing absValue with 8",8.0, Calculate.absValue(8));
		testDoMath("testing absValue with 8.0",8.0, Calculate.absValue(8.0));
		testDoMath("testing absValue with -2",2.0, Calculate.absValue(-2.0));
		testDoMath("testing absValue with 0",0, Calculate.absValue(0.0));
		testDoMath("testing max with 2 integers 8 & 9",9, Calculate.max(8,9));
		testDoMath("testing max with 2 integers -5 & -3",-3, Calculate.max(-5,-3));
		testDoMath("testing max with 3 doubles -4, 3, & 9",9.0, Calculate.max(-4.0,3, 9.0));
		testDoMath("testing min with 2 integers -5 & -3",-5, Calculate.min(-5,-3));
		testDoMath("testing round2 with 85.9876", 85.99, Calculate.round2(85.98765));
		testDoMath("testing round2 with 5.5", 5.50, Calculate.round2(5.5));
		testDoMath("testing round2 with 5.596", 5.60, Calculate.round2(5.596));
		testDoMath("testing exponent with 2 to the 3rd",8.0, Calculate.exponent(2.0,3));
		testDoMath("testing exponent with 1.5 to the 5th",7.59375, Calculate.exponent(1.5,5));
		testDoMath("testing factorial with 5",120, Calculate.factorial(5));
		testDoMath("testing isPrime with 7",true, Calculate.isPrime(7));
		System.out.println("Also check isPrime to ensure it calls another method");
		testDoMath("testing isPrime with 8",false, Calculate.isPrime(8));	
		testDoMath("testing gcf with 12 and 15",3, Calculate.gcf(12, 15));
		testDoMath("testing gcf with 39 and 26",13, Calculate.gcf(39,26));
		System.out.println("Also check gcf to ensure it calls another method");
		testDoMath("testing sqrt with 81, accurate +/- .01", 9.0, Calculate.sqrt(81.0), .01);
		testDoMath("testing sqrt with 56, accurate +/- .01", 7.4833, Calculate.sqrt(56.0), .01);
		testDoMath("testing quadForm with no real roots -1,0,-5","no real roots", Calculate.quadForm(-1,0,-5));
		testDoMath("testing quadForm with one real root 1,-3,10 (note this may fail by number of signif digits) \n\t\t","-2.00", Calculate.quadForm(1,4,4));
		testDoMath("testing quadForm with two real roots (note this may fail if in wrong order) \n\t\t","-2.00 and 5.00", Calculate.quadForm(1,-3,-10));
		//test time for long square root
	}

	// Integer tester
	public static void testDoMath(String testDesc, int rightAns, int testAns) {
		if (rightAns == testAns) {
			System.out.println(testDesc + " passed");

		} else {
			System.out.println(testDesc + " failed! Returned " + testAns + " instead of " + rightAns);
		}
	}

	// double tester
	public static void testDoMath(String testDesc, double rightAns, double testAns) {
		if (rightAns == testAns) {
			System.out.println(testDesc + " passed");

		} else {
			System.out.println(testDesc + " failed! Returned " + testAns + " instead of " + rightAns);
		}
	}
	// double tester within limits
	public static void testDoMath(String testDesc, double rightAns, double testAns, double range) {
		if (Calculate.absValue(rightAns-testAns) <= range){
			System.out.println(testDesc + " within " + range + " passed");
		} else {
			System.out.println(testDesc + " failed! Returned " + testAns + "instead of " +
					rightAns + ", outside of range of " + range);
		}
	}
	// String tester
			public static void testDoMath(String testDesc, String rightAns, String testAns) {
				if (rightAns.equals(testAns)) {
					System.out.println(testDesc + " passed");

				} else {
					System.out.println(testDesc + " failed! Returned " + testAns + " instead of " + rightAns);
				}
			}
	// boolean tester
		public static void testDoMath(String testDesc, boolean rightAns, boolean testAns) {
			if (rightAns == testAns) {
				System.out.println(testDesc + " passed");

			} else {
				System.out.println(testDesc + " failed! Returned " + testAns + " instead of " + rightAns);
			}
		}
}


