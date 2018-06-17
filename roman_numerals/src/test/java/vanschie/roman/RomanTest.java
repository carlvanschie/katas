package vanschie.roman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by carl on 18/06/17.
 */
@RunWith(Parameterized.class)
public class RomanTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, "I" },
                { 2, "II" },
                { 3, "III" },
                { 4, "IV" },
                { 5, "V" },
                { 9, "IX" },
                { 10, "X" },
                { 40, "XL" },
                { 50, "L" },
                { 90, "XC" },
                { 100, "C" },
                { 150, "CL" },
                { 400, "CD" },
                { 500, "D" },
                { 1000, "M" },
                { 1490, "MCDXC"},
                { 1499, "MCDXCIX"}
        });
    }

    private int testValue;
    private String responseValue;

    public RomanTest(int testValue, String responseValue) {
        this.testValue = testValue;
        this.responseValue = responseValue;
    }

    @Test
    public void test() {
        assertEquals(responseValue, Roman.translate(testValue));
    }
}
