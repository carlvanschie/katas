package vanschie.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carl on 14/06/17.
 */
public class FizzBuzzTest {

    @Test
    public void whenPassedAOne_thenOneIsReturned() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
    }

    @Test
    public void whenPassedATwo_thenTwoIsReturned() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }

    @Test
    public void whenPassedAThree_thenFizzIsReturned() {
        assertEquals("fizz", FizzBuzz.fizzBuzz(3));
    }

    @Test
    public void whenPassedAFive_thenBuzzIsReturned() {
        assertEquals("buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void whenPassedAFifteen_thenFizzBuzzIsReturned() {
        assertEquals("fizzbuzz", FizzBuzz.fizzBuzz(15));
    }

}
