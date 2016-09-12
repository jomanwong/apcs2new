public class DoMath {
	public static void main(String[]args){
		System.out.println(Calculate.square(10));
		System.out.println(Calculate.toDegrees(0.16666));
		System.out.println(Calculate.toRadians(270));
		System.out.println(Calculate.discriminant(1, 2, 1));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(2, 6));
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println(Calculate.isDivisibleBy(3, 8));
		System.out.println(Calculate.absValue(-5));
		System.out.println(Calculate.max(9, 9));
		System.out.println(Calculate.max(1.2, 9.0, 1.1));
		System.out.println(Calculate.min(99,2));
		System.out.println(Calculate.round2(8.765));
	}
}
