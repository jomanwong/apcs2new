/** Joman Wong
 * 
 * @author APCS2
 * most recent revision 10/20/16
 */
public class Calculate {
	//part 1
	//squares the input
	public static int square(int num){
		return(num*num);
	}
	//cubes the input
	public static int cube(int num){
		return(num*num*num);
	}
	//average out two doubles
	public static double average(double numOne, double numTwo){
		return((numOne+numTwo)*0.5);
	}
	//average out 3 doubles
	public static double average(double numOne, double numTwo, double numThree){
		return((numOne + numTwo + numThree)/3);
	}
	//radians to degrees
	public static double toDegrees(double rad){
		return(rad * 57.2958);
	}
	//degrees to radians
	public static double toRadians(double deg){
		return(deg*(3.14159/180));
	}
	//find the discriminant from input of the classic a, b, c
	public static double discriminant(double a, double b, double c){
		return((b*b)-(4*a*c));
	}
	//converts mixed number into improper fraction
	public static String toImproperFrac(int a, int b, int c){
		String d = Integer.toString(a*c + b);
		return(d + "/" + c);
	}
	//converts improper fraction to mixed number
	public static String toMixedNum(int a, int b){
		if(a%b == 0){
			return(a/b+"");
		}else if (a < b){
			return(a+"/"+b);
		}
		return( (a - ( a % b))/b + "_" + (a % b ) + "/" + b);
	}
	//use the foil method
	public static String foil(int a, int b, int c, int d, String e){
		int y = b*d;
		b = a*d + c*b;
		a = a*c;
		if (y > 0){
			return(a + e + "^2 + " + b + e + " " + "+ " + y);
		}else{
			return (a + e + "^2 + " + b + e + " " + "� " + y*-1); // � vs - from fmy keyboard caused a problem with the
		}														// testDoMath
	}
//end of part 1
	//checks if one integer is evenly divisible by another
	public static boolean isDivisibleBy(int a, int b){
		if(a % b == 0 || b % a == 0){
			return(true);
		}else{
			return(false);
		}
	}
	//returns absolute value of input int
	public static double absValue(double num){
		if(num > 0){
			return num;
		}else if(num < 0){
			return num*-1;
		}else{
			return 0;
		}
	}
	//returns larger of the 2 integers passed
	public static int max(int a, int b){
		if (a > b){
			return(a);
		}else{
			return(b);
		}
	}
	//returns the largest of the 3 doubles passed
	public static double max(double a, double b, double c){
		if (a > b && a > c){ //test a
			return(a);
		}else if(b > a && b > c){//test b
			return(b);
		}else{
			return c;
		}
	}
	//returns the smaller of the two integers passed
	public static int min (int a, int b){
		if (a>b){
			return(b);
		}else{
			return a;
		}
	}
	//rounds a double to 2 decimal places
	public static double round2(double num){
		   int a =(int)(num*100);
		   double x;
		   if ((a+0.5)>= (num * 100)){
		   x = a/100.00;
		   return(x);
		   }else{ x=(a+1)/100.00;
		   return (x);
		   }
	    }
//end of part 2
	//raise a value to a positive integer power
	public static double exponent(double num, int raiser){
		double num2 = 1;
		if(raiser < 0){
			return(-1);
		}else{
			for(int i = 0; i < raiser;i++){
				num2 *= num;
			}
		}
		return num2;
	}
	//returns the factorial of the value passed
	public static int factorial(int num){
		for(int i = num-1; i > 0; i-= 1){
			num *= i;
		}
		return num;
	}
	//determines whether a value is prime or not
	public static boolean isPrime(int a){
        if(absValue(a) < 4){
        	return true;
        }else if (absValue(a) % 2 == 0 || absValue(a) % 3 == 0){
            return false;
        }else{
            return true;
        }
    }
	//finds the gcf of two ints
	public static int gcf(int a, int b){
        while (b > 0){
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
	//returns the approximation of the square root
	public static double sqrt(double a){
	    double x=0;
	    while ((a-x*x)>0.0001){
		    x=x+0.0001;
	    }
	    return x;
    }
	//does the quadratic formula or the zeros of an quadratic consist of variable a, b, c.
	public static String quadForm(int a, int b, int c){
        double sqrtOfDis = sqrt(discriminant(a, b, c));
        double root1 = round2((- b + sqrtOfDis)/(2*a));
        double root2 = round2((- b - sqrtOfDis)/(2*a));
        if( root1 == root2){
        	return String.valueOf(root1);
        }else if(sqrt(discriminant(a, b, c)) <= 0){
            return "no real roots"; 
        }else{
            return Double.toString(root1) + " and " + Double.toString(root2);
        }
    }
}
