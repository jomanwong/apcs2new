import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import arrays_materials.ArraysLab3;

public class Tester {
	public static void main(String[] args){
		int[] a1 = 				{5, 10, 15, 20, 25, 30, 35, 40, 0, 0,  -10};
		int[] a2 = 				{7, 14, 21, 28, 35, 42, 49, 56, 0, 15, -15};
		int[] expectedResult = 	{12, 24, 36, 48, 60, 72, 84, 96, 0, 15, -25};
		int[] result = sum(a1, a2);
		Assert.assertArrayEquals("Result " + Arrays.toString(result) 
		+ " Does not match the expected value of " + Arrays.toString(expectedResult),
		expectedResul
		t, result);
		System.out.println("Unit test testSum passed.");
	}
	public static int[] sum(int[] arr1, int[] arr2){
		assert (arr1.length > 0): "arr1 is nulll or empty!";
		assert (arr2.length > 0): "arr2 is null or empty!";
		assert (arr1.length == arr2.length): "arr1 and arr2 are not equal in length!";
		int[] output = new int[10];
		for(int i = 0; i < arr1.length - 1; i ++){
			output[i] = arr1[i] + arr2[i];
		}
		return output;
	}
}

