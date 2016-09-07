package com.driver;

import java.util.List;

import com.prime.EratosthenesGenerator;
import com.prime.PrimeNumberGenerator;

public class Driver {

	private static PrimeNumberGenerator generator = new EratosthenesGenerator();
	
	public static void main(String[] args) {
		int startingValue = Integer.parseInt(args[0]);
		int endingValue = Integer.parseInt(args[1]);
		
		List<Integer> values = generator.generate(startingValue, endingValue);
		
		System.out.println(values);
	}

}
