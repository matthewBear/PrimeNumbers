package test.prime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.prime.EratosthenesGenerator;
import com.prime.PrimeNumberGenerator;

public class EratosthenesGeneratorTest {

	PrimeNumberGenerator generator = new EratosthenesGenerator();
	
	//==========================================
	//    Test generate
	//==========================================
	
	@Test
	public void testZeroInput(){
		List<Integer> values = generator.generate(0, 0);
		assertNotNull(values);
		assertEquals(0,values.size());
	}
	
	@Test
	public void testOneInput(){
		List<Integer> values = generator.generate(0, 1);
		assertNotNull(values);
		assertEquals(0,values.size());
	}
	
	@Test
	public void testZeroRange(){
		List<Integer> values = generator.generate(10, 10);
		assertNotNull(values);
		assertEquals(0,values.size());
	}
	
	@Test
	public void testGenerateNegativeStartPositiveEndValue(){
		List<Integer> values = generator.generate(-10, 10);
		Integer[] expected = {2,3,5,7};
		assertTrue(values.containsAll(Arrays.asList(expected)));	
		assertEquals(4,values.size());
	}
	
	@Test
	public void testGenerateNegativeStartEndValue(){
		List<Integer> values = generator.generate(-10, -5);
		assertNotNull(values);
		assertEquals(0,values.size());
	}
	
	@Test
	public void testPrimesTo10(){
		List<Integer> values = generator.generate(0, 10);
		Integer[] expected = {2,3,5,7};
		assertTrue(values.containsAll(Arrays.asList(expected)));
		assertEquals(4,values.size());
	}
	
	@Test
	public void testPrimesTo10WithReversedInputs(){
		List<Integer> values = generator.generate(10, 0);
		Integer[] expected = {2,3,5,7};
		assertTrue(values.containsAll(Arrays.asList(expected)));	
		assertEquals(4,values.size());
	}
	
	@Test
	public void testInclusivePrimeGeneration(){
		List<Integer> values = generator.generate(3, 7);
		Integer[] expected = {3,5,7};
		assertTrue(values.containsAll(Arrays.asList(expected)));
		assertEquals(3,values.size());
	}
	
	@Test
	public void testGeneratingPrimesWithLargeRange(){
		List<Integer> values = generator.generate(0,7920);
		assertEquals(1000,values.size());
	}
	
	@Test
	public void testGeneratingPrimesWithHighValueLowRange(){
		List<Integer> values = generator.generate(7900,7920);
		Integer[] expected = {7901,7907,7919};
		assertTrue(values.containsAll(Arrays.asList(expected)));
		assertEquals(3,values.size());
	}
	
	@Test
	@Ignore
	public void testGeneratingPrimesWithMillionRange(){ //stopped at 20min run time
		//1 million
		List<Integer> values = generator.generate(0,1000000);
		assertEquals(1,values.size());
	}
	
	@Test
	public void testGeneratingPrimesWithHugeRange(){ //takes a minute or so to run, but it passes
		//100 Thousand
		List<Integer> values = generator.generate(0,100000);
		assertEquals(9592,values.size());
	}
	
	//==========================================
	//    Test isPrime
	//==========================================
	
	@Test
	public void testIsNotPrime(){
		boolean actual = generator.isPrime(10);
		assertEquals(false,actual);
	}
	
	@Test
	public void testIsPrime(){
		boolean actual = generator.isPrime(7);
		assertEquals(true,actual);
	}
	
	@Test
	public void testIsPrimeNegativeInput(){
		boolean actual = generator.isPrime(-10);
		assertEquals(false,actual);
	}
	
	@Test
	public void testIsPrimeZero(){
		boolean actual = generator.isPrime(0);
		assertEquals(false,actual);
	}
	
	@Test
	public void testIsPrimeOne(){
		boolean actual = generator.isPrime(1);
		assertEquals(false,actual);
	}
}
