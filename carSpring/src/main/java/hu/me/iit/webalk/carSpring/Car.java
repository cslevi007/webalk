package hu.me.iit.webalk.carSpring;

import java.util.Arrays;

public class Car {
	private final Wheel[] wheel;
    private final Engine engine;
    private final String type;
    
	public Wheel[] getWheel() {
		return wheel;
	}
	public Engine getEngine() {
		return engine;
	}
	public String getType() {
		return type;
	}
	public Car(Wheel[] wheel, Engine engine, String type) throws NotRightData{
		super();
		
		if (wheel.length != 4 || engine == null || type == null) {
            throw new NotRightData();
        }
		
		this.wheel = wheel;
		this.engine = engine;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [wheel=" + Arrays.toString(wheel) + ", engine=" + engine + ", type=" + type + "]";
	}
    
}
