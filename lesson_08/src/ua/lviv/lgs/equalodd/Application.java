/**
 * Logos IT Acadamy Homework
 * */

package ua.lviv.lgs.equalodd;

import java.util.Scanner;
import ua.lviv.lgs.exception.WrongInputConsoleParametersException;

/**
 * @author Artem
 */

public class Application {
	/* Class Name */

	public static void main(String[] args) throws WrongInputConsoleParametersException {

		evenOrOdd();
	}

	/** This is the simple method to define if number is even or odd */
	public static void evenOrOdd() throws WrongInputConsoleParametersException {

		/** Creating new scanner */
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter some integer");

			/** Reading the input and assigning it to double number */
			double number = scanner.nextDouble();
			if (number % 1 != 0) {
				String message = "Entered data isn't correct. Please, try again";
				throw new WrongInputConsoleParametersException(message);
			} else {
				if (number % 2 == 0) {
					System.out.println("Your number is even");
				} else {
					System.out.println("Your number is odd");
				}
			}
		}
	}

}
