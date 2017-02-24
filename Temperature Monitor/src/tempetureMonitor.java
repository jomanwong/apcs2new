/** 
 *  Joman Wong 2/22/17
 */

//Solved TODO: PROBLEM!! DOESN'T RECOGNIZE "System", "System cannot be resolved" with newer Java version at home
// TEST SUCCESSFUL WITH user input "resources/weather.txt", when weather.txt is in resouce package
//Solved TODO: fix calculation: e.g. -1.8 to 14.9 = 16.7 is not -16.7
/** weather.txt
16.2	23.5
	19.1 7.4	22.8

18.5	-1.8 14.9
 */

import java.io.*;
import java.util.*;
import java.text.*;

public class TempetureMonitor {
	public static void main(String[]args){
		//while(read() == true){
			try{
				changeInTemp();
			}catch(FileNotFoundException e){
				System.out.println("File not found");
			}
		//}
	}

	public static void changeInTemp() throws FileNotFoundException{
		DecimalFormat df = new DecimalFormat ("#.00");
		System.out.println("Enter directory:");
		Scanner directory = new Scanner(System.in); //reads string of file directory
		String filePath = directory.next();
		directory.close();
		System.out.println("Looking for File@ " + filePath + " ..."); //test
		System.out.println();
		//Could use directory Scanner, but this is more clear in naming
		Scanner fileReader = new Scanner(new File(filePath)); 
		//use while hasNext.
		double file;
		ArrayList<Double> readItems = new ArrayList<Double>(); 
		while(fileReader.hasNext()){
			file = fileReader.nextDouble();
			readItems.add(file);
		}
		fileReader.close();
		double temp;
		ArrayList<Double> differences = new ArrayList<Double>();
		assert readItems.size() > 1 : "Cannot Calculate Difference Due to Only ONE Temperature Value Was Read";
		for(int i = 0; i < readItems.size() - 1; i++){
			temp = readItems.get(i) - readItems.get(i+1);
			//temp = Math.abs(temp); no need due to that a decrease in temperature is possible
			if(readItems.get(i+1) > readItems.get(i)){
				temp = Math.abs(temp);
			}else if(readItems.get(i) > readItems.get(i+1)){
				temp = temp*(-1.00);
			}else{
				temp = temp;
			}
			differences.add(temp); //safe sotrage
			System.out.println(readItems.get(i) + " to " + readItems.get(i+1) + ", change = " + df.format(differences.get(i)));
		}
		//read();
	}
/*
	public static boolean read(){
		System.out.println("Search for file? Yes or No");
		Scanner response = new Scanner(System.in); 
		String userResponse = response.next();
		boolean stopLoop = false;
		while (stopLoop == false){
			if(userResponse.equalsIgnoreCase("yes")){
				response.close();
				return true;
			}else if(userResponse.equalsIgnoreCase("no")){
				response.close();
				return false;
			}else{			
				System.out.println("Unrecognized response. Enter Yes or No");
				userResponse = response.next();
				stopLoop = true;
			}
		}
		response.close();
		return false;
	}
	*/
}