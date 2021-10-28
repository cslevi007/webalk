package hu.me.iit.webalk.carSpring;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.me.iit.webalk.carSpring.Impl.CombustionEngine;
import hu.me.iit.webalk.carSpring.Impl.ElectricEngine;
import hu.me.iit.webalk.carSpring.Impl.WheelImpl;

@SpringBootApplication
public class CarSpringApplication  implements CommandLineRunner{

	private Engine engine;
	private String type;
	
	public static void main(String[] args) {
		SpringApplication.run(CarSpringApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Engine engine = new CombustionEngine(110, 1800);
		Wheel[] wheels = new WheelImpl[4];
		Arrays.fill(wheels, new WheelImpl(300, 18, 25));

		Car car = new Car(wheels, engine, "Toyota");
		System.out.println(car.toString());

		Engine engine2 = new ElectricEngine(130, 2300);
		Wheel[] wheels2 = new WheelImpl[4];
		Arrays.fill(wheels2, new WheelImpl(320, 19, 21));

		Car car2 = new Car(wheels2, engine2, "BMW");
		System.out.println(car2.toString());
	}

}
