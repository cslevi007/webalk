package hu.me.iit.webalk.impl;

import hu.me.iit.webalk.Engine;

public class CombustionEngine implements Engine{
	private final int bhp;
    private final int cc;

    public CombustionEngine(int bhp, int cc) {
        this.bhp = bhp;
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "bhp=" + bhp +
                ", cc=" + cc +
                '}';
    }
}
