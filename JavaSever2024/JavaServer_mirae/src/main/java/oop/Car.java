package oop;

public abstract class Car {
	int speed;
	int adult;
	int child;
	
	final public void speedUp() {
		speed += 1;
		
	}
	
	public int people() {
		return adult + child;
	}
	
	abstract public void move();
}
