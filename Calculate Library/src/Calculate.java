public class Calculate {
	//part 1
	public static int square(int num){
		return(num*num);
	}
	public static int cube(int num){
		return(num*num*num);
	}
	public static double average(double numOne, double numTwo){
		return((numOne*numTwo)*0.5);
	}
	public static double average(double numOne, double numTwo, double numThree){
		return((numOne + numTwo + numThree)/3);
	}
	public static double toDegrees(double rad){
		return((3.14159*rad)*(180/3.14159));
	}
	public static double toRadians(double deg){
		return(deg*(3.14159/180));
	}
	public static double discriminant(double a, double b, double c){
		return((b*b)-(4*a*c));
	}
	public static String toImproperFrac(int a, int b, int c){
		String d = Integer.toString(a*c + b);
		return(d + "/" + c);
	}
	public static int toMixedNum(int num){
		return(number*number);
	}
	public static int foil(int num){
		return num;
	}
}
