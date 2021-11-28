package hu.me.u678mf.service.exceptions;

public class NoSuchTripException extends RuntimeException {
	private Long id;

	public NoSuchTripException() {
		super();
	}

	public NoSuchTripException(Long id) {
		super(String.format("Trip with id: %d, is not exists in the system!", id));
	}
}
