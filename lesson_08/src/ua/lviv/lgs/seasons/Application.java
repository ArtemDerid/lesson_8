/**
 * Logos IT Acadamy Homework
 * */

package ua.lviv.lgs.seasons;

import java.util.Scanner;

import ua.lviv.lgs.exception.WrongInputConsoleParametersException;

/**
 * @author Artem
 */

public class Application {
	/* Class Name */

	enum Season {
		WINTER, SPRING, SUMMER, FALL;
	}

	enum Month {
		JANUARY(31, Season.WINTER), FEBRUARY(28, Season.WINTER), MARCH(31, Season.SPRING), APRIL(30, Season.SPRING),
		MAY(31, Season.SPRING), JUNE(30, Season.SUMMER), JULY(31, Season.SUMMER), AUGUST(31, Season.SUMMER),
		SEPTEMBER(30, Season.FALL), OCTOBER(31, Season.FALL), NOVEMBER(30, Season.FALL), DECEMBER(31, Season.WINTER);

		/** Veriables creating as fields of enum Month */
		int day;
		Season season;

		/** Constractor */
		private Month(int day, Season season) {
			this.day = day;
			this.season = season;
		}

		public int getDay() {
			/* getter */
			
			return day;
		}

		public Season getSeason() {
			/* getter */
			return season;
			
		}

	}

	/* Crating static menu **/
	static void menu() {
		System.out.println("Натисніть 1, щоб перевірити чи такий місяць існує");
		System.out.println("Натисніть 2, щоб вивести всі місяці з такою ж порою року");
		System.out.println("Натисніть 3, щоб вивести всі місяці з такою ж кількістю днів");
		System.out.println("Натисніть 4, щоб вивести всі місяці з меншою кількістю днів");
		System.out.println("Натисніть 5, щоб вивести всі місяці з більшою кількістю днів");
		System.out.println("Натисніть 6, щоб вивести наступну пору року");
		System.out.println("Натисніть 7, щоб вивести попередню пору року");
		System.out.println("Натисніть 8, щоб вивести всі місяці з парною кількістю днів");
		System.out.println("Натисніть 9, щоб вивести всі місяці з непарною кількістю днів");
		System.out.println("Натисніть 10, щоб перевірити чи введений місяць має парну кількість днів");
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException {

		/** Creating an array of Month */
		Month[] mas = Month.values();
		
		/** Creating an array of Seasons */
		Season[] mass = Season.values();
		
		/** Creating new scanner */
		Scanner sc = new Scanner(System.in);
		
		/** Creating a string for exceptions */
		String message = "Enter correct data please";

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = ifMonthExist(mas, month);

				if (!flag) {
					throw new WrongInputConsoleParametersException(message);
				}
			}

				break;

			case "2": {

				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String seasonSc = sc.next().toUpperCase();

				boolean flag = ifSeasonExists(mas, seasonSc);

				if (flag) {
					for (Month m1 : mas) {
						if (m1.getSeason().name().equalsIgnoreCase(seasonSc)) {
							System.out.println(m1);
						}
					}

				}

				if (!flag) {
					System.out.println("Season doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}

			}

				break;

			case "3": {

				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = ifMonthExist(mas, month);

				if (flag) {
					for (Month m : mas) {
						if (m.name().equals(month)) {
							for (Month m1 : mas) {
								if (m1.getDay() == m.getDay()) {
									System.out.println(m1);
								}
							}
						}
					}
				}

				if (!flag) {
					System.out.println("Month doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}
			}
				break;

			case "4": {

				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = ifMonthExist(mas, month);

				if (flag) {
					for (Month m : mas) {
						if (m.name().equals(month)) {
							for (Month m1 : mas) {
								if (m1.getDay() < m.getDay()) {
									System.out.println(m1);
								}
							}
						}
					}
				}

				if (!flag) {
					System.out.println("Month doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}
			}
				break;

			case "5": {

				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = ifMonthExist(mas, month);

				if (flag) {
					for (Month m : mas) {
						if (m.name().equals(month)) {
							for (Month m1 : mas) {
								if (m1.getDay() > m.getDay()) {
									System.out.println(m1);
								}
							}
						}
					}
				}

				if (!flag) {
					System.out.println("Month doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}
			}
				break;

			case "6": {

				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String seasonSc = sc.next().toUpperCase();

				boolean flag = ifSeasonExists(mas, seasonSc);

				if (flag) {
					Season s = Season.valueOf(seasonSc);
					int ordinal = s.ordinal();
					if (ordinal == (mass.length - 1)) {
						ordinal = 0;
						System.out.println(mass[ordinal]);
					} else {
						System.out.println(mass[ordinal + 1]);
					}

				}

				if (!flag) {
					System.out.println("Season doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}

			}

				break;

			case "7": {

				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String seasonSc = sc.next().toUpperCase();

				boolean flag = ifSeasonExists(mas, seasonSc);

				if (flag) {
					Season s = Season.valueOf(seasonSc);
					int ordinal = s.ordinal();
					if (ordinal == 0) {
						System.out.println(mass[mass.length - 1]);
					} else {
						System.out.println(mass[ordinal - 1]);
					}

				}

				if (!flag) {
					System.out.println("Season doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}

			}

				break;

			case "8": {

				for (Month m : mas) {
					if (m.getDay() % 2 == 0) {
						System.out.println(m);
					}
				}
			}
				break;

			case "9": {

				for (Month m : mas) {
					if (m.getDay() % 2 != 0) {
						System.out.println(m);
					}
				}
			}
				break;

			case "10": {

				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = ifMonthExist(mas, month);

				if (flag) {
					for (Month m : mas) {
						if (m.name().equals(month)) {
							if (m.getDay() % 2 == 0) {
								System.out.println(month + " has even number of days");
							} else {
								System.out.println(month + " has odd number of days");
							}
						}
					}
				}

				if (!flag) {
					System.out.println("Month doesn't exist");
					throw new WrongInputConsoleParametersException(message);
				}

			}
				break;

			}
		}

	}

	/** The Method to check if entered season exist */
	private static boolean ifSeasonExists(Month[] mas, String seasonSc) {
		boolean flag = false;

		for (Month m : mas) {
			if (m.getSeason().name().equals(seasonSc)) {
				flag = true;
			}
		}
		return flag;
	}

	/** The Method to check if entered month exist */
	private static boolean ifMonthExist(Month[] mas, String month) {
		boolean flag = false;

		for (Month m : mas) {
			if (m.name().equals(month)) {
				System.out.println("Month exist");
				flag = true;
			}
		}
		return flag;
	}

}
