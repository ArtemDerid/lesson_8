/**
 * Logos IT Acadamy Homework
 * */

package ua.lviv.lgs.sum;

import java.util.Scanner;

import ua.lviv.lgs.exception.WrongInputConsoleParametersException;

/**
 * @author Artem
 */

public class Application {
	/* Class Name */
	
	public static void main(String[] args) throws WrongInputConsoleParametersException {
		addNumbers();
	}

	/** This is the simple method for adding numbers */
	public static void addNumbers() throws WrongInputConsoleParametersException {
		
		/** Creating new scanner */
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("Enter first integer");
			
			/** Reading the input and assigning it to double firstNumber */
			Double firstNumber = scanner.nextDouble();
			
			System.out.println("Enter second integer");
			
			/** Reading the input and assigning it to double secondNumber */
			Double secondNumber = scanner.nextDouble();

			if (firstNumber % 1 == 0 && secondNumber % 1 == 0) {
				System.out.println("The sum of your numbers are " + (firstNumber + secondNumber));
			} else {
				String message = "You entered incorrect data";
				throw new WrongInputConsoleParametersException(message);
			}
		}
	}

}
