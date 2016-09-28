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
	public static boolean isPrime(int a){
        if(absValue(a) < 4){
        	return true;
        }else if (absValue(a) % 2 == 0 || absValue(a) % 3 == 0){
            return false;
        }else{
            return true;
        }
    }
	public static int gcd(int a, int b){
        while (b > 0){
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
	public static double sqrt(double a){
	    double x=0;
	    while ((a-x*x)>0.0001){
		    x=x+0.0001;
	    }
	    return x;
    }
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
