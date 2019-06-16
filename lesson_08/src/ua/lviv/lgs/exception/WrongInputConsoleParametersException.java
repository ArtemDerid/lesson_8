/**
 * Logos IT Acadamy Homework
 * */

package ua.lviv.lgs.exception;

public class WrongInputConsoleParametersException extends Exception {
	/* Class Name */

	/** Docs to String */
	private String wrongInput;
	
	/** This is constructor */
	public WrongInputConsoleParametersException(String wrongInput) {
		super(wrongInput);
		this.wrongInput = wrongInput;
	}

	public String getWrongInput() {
		/* getter method */
		
		return wrongInput;
	}

}
