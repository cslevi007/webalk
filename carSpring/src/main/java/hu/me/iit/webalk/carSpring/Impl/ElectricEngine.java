package hu.me.iit.webalk.carSpring.Impl;

import hu.me.iit.webalk.carSpring.Engine;

public class ElectricEngine implements Engine{
	private final int power;
    private final int voltage;
    
	public ElectricEngine(int power, int voltage) {
		super();
		this.power = power;
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return "ElectricEngine [power=" + power + ", voltage=" + voltage + "]";
	}
}
