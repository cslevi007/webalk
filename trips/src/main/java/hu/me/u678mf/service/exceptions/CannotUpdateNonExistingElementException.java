package hu.me.u678mf.service.exceptions;

import hu.me.u678mf.service.Trip;

public class CannotUpdateNonExistingElementException  extends RuntimeException{

	public CannotUpdateNonExistingElementException() {
		super();
	}
	
	public CannotUpdateNonExistingElementException(String message) {
		super(message);
	}
	
	public CannotUpdateNonExistingElementException(Trip trip) {
		super(String.format("Can not update element, because id: %d not exists", trip.getId()));
	}
	
}
