package hu.me.iit.webalk.carSpring.Impl;

import hu.me.iit.webalk.carSpring.Wheel;

public class WheelImpl implements Wheel{
	private final int width;
    private final int diameter;
    private final int height;
    
	public WheelImpl(int width, int diameter, int height) {
		super();
		this.width = width;
		this.diameter = diameter;
		this.height = height;
	}

	@Override
	public String toString() {
		return "WheelImpl [width=" + width + ", diameter=" + diameter + ", height=" + height + "]";
	}
}
