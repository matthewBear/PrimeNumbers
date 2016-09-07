package com.prime;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements PrimeNumberGenerator using the Sieve of Eratosthenes
 * algorithm  
 * 
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * @author Matt Bear
 *
 */
public class EratosthenesGenerator implements PrimeNumberGenerator {
	
	/**
	 * {@inheritDoc}
	 */
	public List<Integer> generate(int startingValue, int endingValue) {
			
		//endingValue should always be the biggest
		if (startingValue > endingValue) {
			int swapVar = startingValue;
			startingValue = endingValue;
			endingValue = swapVar;
		}
		
		startingValue = (startingValue < 0) ? 0 : startingValue;
		
		int blockSize = integerSqrt(endingValue);
				
		List<Integer> primes = performInitialSieve(blockSize);
		
		int blockStart = blockSize;
		int blockEnd = 2 * blockSize;
		
		while(blockStart < endingValue){
			boolean[] segmentedSieve = initalizeSieve(blockSize);
			
			for(int i = 0; i < primes.size(); i++){
				int loLim = (blockStart / primes.get(i)) * primes.get(i);
				if(loLim < blockStart){
					loLim += primes.get(i);
				}
				
				for(int j = loLim; j < blockEnd; j+= primes.get(i)){
					segmentedSieve[j-blockStart] = false;
				}
			}
			
			//get the primes out of the sieve
			for(int i = blockStart; i < blockEnd; i++){
				if(segmentedSieve[i - blockStart] == true){
					primes.add(i);
				}
			}
			
			//move up the block to next segment
			blockStart = blockStart + blockSize;
			blockEnd = blockEnd + blockSize;
			if(blockEnd > endingValue){
				blockEnd = endingValue +1; //+1 to make it inclusive at endingVal
			}
		}
		
		return trimPrimesUpToToStartingValue(primes,startingValue);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isPrime(int value) {
		return generate(0,value).contains(value);
	}
	
	private List<Integer> performInitialSieve(int delta) {
		boolean[] sieve = initalizeSieve(delta+1);
		
		for (int i = 2; i * i <= delta; i++)
	    {
	        if (sieve[i])
	        {
	            for (int j = i * 2; j < delta; j += i)
	            {
	            	sieve[j] = false;
	            }
	        }
	    }

		List<Integer> primes = new LinkedList<Integer>();
		for(int i = 2; i < delta; i++){
			if(sieve[i] == true){
				primes.add(i);
			}
		}
		
		return primes;
	}

	
	private boolean[] initalizeSieve(int maxValue){
		boolean[] sieve = new boolean[maxValue];
		Arrays.fill(sieve, true);
		
		return sieve;
	}
	
	private List<Integer> trimPrimesUpToToStartingValue(List<Integer> primes, final int startingValue) {
		return primes.stream().filter(i -> i >= startingValue).collect(Collectors.toList());
	}
	
	/**
	 * For avoiding casting
	 */
	private int integerSqrt(int num){
		return (int) Math.sqrt(num);
	}

}
