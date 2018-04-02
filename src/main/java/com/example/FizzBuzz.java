package com.example;

/**
 * Created by miszymcz on 23/03/2018
 *
 * - Print a comma-separated numbers from 1 to input inclusive 
 * - If number is divisible by three, it's replaced by the word fizz 
 * - If divisible by five by the word buzz. 
 * - Numbers divisible by both become 'fizz buzz'
 */

public class FizzBuzz {

	public String play(int input) {

		System.out.println(getTheRange(input));
		
		StringBuilder outputString = new StringBuilder("");
		/***
		 * Check Division by 3 and 5 and return value accordingly
		 */
		if (input % 3 == 0) {
			outputString.append("fizz ");
		}
		if (input % 5 == 0) {
			outputString.append("buzz");
		}
		return outputString.toString().trim();
	}
	
	public String getTheRange(int input){
		
		StringBuilder outputString = new StringBuilder("1");

		/***
		 * If else for 3 cases - input=0; <0 and >0
		 */
		if (input == 0) {
			outputString.append(",").append(0);
		} 
		else if (input < 0) {
			int range = Math.abs(input) + 1;
			for (int i = 1; i <=range; i++) {
				outputString.append(",").append(1 - i);
			}
		} 
		else {
			for (int i = 2; i <= input; i++) {
				outputString.append(",").append(i);
			}
		}
		
		return outputString.toString().trim();
	}
}
