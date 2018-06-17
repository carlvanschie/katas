package vanschie.fib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carl on 15/06/17.
 */
public class FibTest {

    @Test
    public void givenTheValueZero_thenTheValueZeroShouldBeReturned() {
        assertEquals(0, Fib.calculate(0));
    }

    @Test
    public void givenTheValueOne_thenTheValueOneShouldBeReturned() {
        assertEquals(1, Fib.calculate(1));
    }

    @Test
    public void givenTheValueTwo_thenTheValueOneShouldBeReturned() {
        assertEquals(1, Fib.calculate(2));
    }

    @Test
    public void givenTheValueThree_thenTheValueTwoShouldBeReturned() {
        assertEquals(2, Fib.calculate(3));
    }

    @Test
    public void givenTheValueFour_thenTheValueThreeShouldBeReturned() {
        assertEquals(3, Fib.calculate(4));
    }

    @Test
    public void givenTheValueFive_thenTheValueFiveShouldBeReturned() {
        assertEquals(5, Fib.calculate(5));
    }

    @Test
    public void givenTheValueSix_thenTheValueEightShouldBeReturned() {
        assertEquals(8, Fib.calculate(6));
    }

    @Test
    public void givenTheValueTwenty_thenTheValue6765ShouldBeReturned() {
        assertEquals(6765, Fib.calculate(20));
    }

    @Test
    public void givenTheValueFifty_thenTheValue12586269025ShouldBeReturned() {
        assertEquals(12586269025L, Fib.calculate(50));
    }
}
