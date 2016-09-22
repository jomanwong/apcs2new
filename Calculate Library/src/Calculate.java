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
	public static String toMixedNum(int a, int b){
		if(a%b == 0){
			return(a/b+" ");
		}else if (a < b){
			return(a+"/"+b);
		}
		return( (a - ( a % b))/b + "_" + (a % b ) + "/" + b);
	}
	public static String foil(int a, int b, int c, int d, String e){
		int y = b*d;
		b = a*d + c*b;
		a = a*c;
		return(a + e + "^2 + " + b + e + y);
	}
//end of part 1
	public static boolean isDivisibleBy(int a, int b){
		if(a % b == 0 || b % a == 0){
			return(true);
		}else{
			return(false);
		}
	}
	public static double absValue(double num){
		if(num > 0){
			return num;
		}else if(num < 0){
			return num*-1;
		}else{
			return 0;
		}
	}
	public static int max(int a, int b){
		if (a > b){
			return(a);
		}else{
			return(b);
		}
	}
	public static double max(double a, double b, double c){
		if (a > b && a > c){ //test a
			return(a);
		}else if(b > a && b > c){//test b
			return(b);
		}else{
			return c;
		}
	}
	public static int min (int a, int b){
		if (a>b){
			return(a);
		}else{
			return b;
		}
	}
/*	public static double round2(double num){
		
	}*/
//end of part 2
	public static double exponent(double num, int raiser){
		double num2 = 1;
		if(raiser < 0){
			return(-1);
		}else{
			for(int i = 0; i < raiser;i++){
				num2 = num2 * num;
			}
		}
		return num2;
	}
	public static int factorial(int num){
		for(int i = num-1; i > 0; i-= 1){
			num = num*i;
		}
		return num;
	}
	public static boolean isPrime(double num){
		return(Math.round(num*100.00)/100.00);
	}
	/*public static double round2(double num){
		return(Math.round(num*100.00)/100.00);
	}
	public static double round2(double num){
		return(Math.round(num*100.00)/100.00);
	}*/
	
}
