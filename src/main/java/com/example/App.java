package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final int input = Integer.parseInt(args[0]);
        final FizzBuzz fizzBuzz = new FizzBuzz();

        System.out.println( "Hello World!" );
        System.out.println(fizzBuzz.play(input));
    }
}
