package hu.me.iit.webalk.impl;

import hu.me.iit.webalk.Engine;

public class ElectricEngine implements Engine{
	private final int operatingTime;
    private final int voltage;

    public ElectricEngine(int operatingTime, int voltage) {
        this.operatingTime = operatingTime;
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
                "operatingTime=" + operatingTime +
                ", voltage=" + voltage +
                '}';
    }
}
