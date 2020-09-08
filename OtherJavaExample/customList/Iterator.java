package com.custom;

public interface Iterator<E> {

	boolean hasNext();
	E next();
	E currentElement();
	void reset();
}
