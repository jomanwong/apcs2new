package pikachu;
import java.util.*;
//Made by Joman Wong, 8/29/16, APCS2
public class Pokemon {
	public static void main(String[]args){
			methodOne(0);
	}

	public static void methodOne(int in){
		if(in == 8){
			System.out.print(in);
		}else{
			methodOne(in + 1);
			System.out.print(in);
		}
	}
}