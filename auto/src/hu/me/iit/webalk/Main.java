package hu.me.iit.webalk;

import java.util.Arrays;

import hu.me.iit.webalk.impl.CombustionEngine;
import hu.me.iit.webalk.impl.ElectricEngine;
import hu.me.iit.webalk.impl.WheelImpl;

public class Main {

	public static void main(String[] args) {
		Engine engine = new CombustionEngine(150, 2000);
        Wheel[] wheels = new WheelImpl[4];
        Arrays.fill(wheels, new WheelImpl(300, 18));

        Auto auto = new Auto(wheels, engine, "");
        System.out.println(auto.toString());

        Engine engine2 = new ElectricEngine(5, 200);
        Wheel[] wheels2 = new WheelImpl[4];
        Arrays.fill(wheels2, new WheelImpl(300, 18));

        Auto auto2 = new Auto(wheels2, engine2, "");
        System.out.println(auto2.toString());
	}

}
