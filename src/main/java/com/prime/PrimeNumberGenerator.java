package com.prime;

import java.util.List;

public interface PrimeNumberGenerator {
	/**
	 * Returns an ordered list of prime numbers from startingValue to
	 * endingValue. 
	 * 
	 * Passed values of 1,10 and 10,1 are equivalent.
	 * 
	 * @param startingValue
	 * 		The starting value of the range to generate prime numbers 
	 * @param endingValue
	 * 		The ending value of the range to generate prime numbers
	 * @return An ordered list of prime numbers
	 */
	List<Integer> generate(int startingValue, int endingValue);

	/**
	 * Returns true iff value is a prime number
	 * 
	 * @param value
	 * @return true if value is a prime number, else returns false
	 */
	boolean isPrime(int value);
}
