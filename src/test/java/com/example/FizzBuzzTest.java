package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by miszymcz on 23/03/2018
 * 
 * Changed by joshin - 29/03/2018 - Added Test cases
 */

public class FizzBuzzTest {
	
	private FizzBuzz fbInstance = new FizzBuzz();
	
    @Test
    public void testInputZero() throws Exception {
    	assertEquals(fbInstance.play(0),"fizz buzz");
    }
    
    @Test
    public void testNumberDivisibleByOnly3() throws Exception{
    	assertEquals(fbInstance.play(-9),"fizz");
    }
    
    @Test
    public void testNumberDivisibleByOnly5() throws Exception{
    	assertEquals(fbInstance.play(20),"buzz");
    }
    
    @Test
    public void testNumberDivisibleByOnly3and5() throws Exception{
    	assertEquals(fbInstance.play(15),"fizz buzz");
    }
    
    @Test
    public void testInputOne() throws Exception{
    	assertEquals(fbInstance.getTheRange(1),"1");
    }
    
    @Test
    public void testNegativeInput() throws Exception{
    	assertEquals(fbInstance.getTheRange(-4),"1,0,-1,-2,-3,-4");
    }
    
    @Test
    public void testPositiveInput() throws Exception{
    	assertEquals(fbInstance.getTheRange(4),"1,2,3,4");
    }
}