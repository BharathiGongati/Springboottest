package org.jsp.SpringBootTest.exception;

public class IdNotFoundExcepton extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String getMessage() {
    	return "Invalid id";
    }

}
