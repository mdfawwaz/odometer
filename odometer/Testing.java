package odometer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testing {
	public static void main(String[] args) {
		System.out.println(Odometer.isAscending(12345));
		System.out.println(Odometer.isAscending(10243));
		System.out.println(Odometer.isAscending(11223));
		Odometer o1 = new Odometer(5);
		Odometer o2 = o1.nextReading();
		System.out.println(o1);
		System.out.println(o2);
		//System.out.println(0/0);
		try {
		o1.setReading(10234);
		} catch(Exception e) {
			System.out.println("I shouldn't have done that");
		}
	}
}