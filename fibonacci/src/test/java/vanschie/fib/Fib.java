package vanschie.fib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by carl on 15/06/17.
 */
public class Fib {
    private static final Map<Integer, Long> calculatedValues = new HashMap();

    public static long calculate(int number) {
        if(number == 0 || number == 1) return number;
        Long preComputedValue = calculatedValues.get(number);
        if(preComputedValue == null) {
            preComputedValue = calculate(number - 1) + calculate(number - 2);
            calculatedValues.put(number, preComputedValue);
        }
        return preComputedValue;
    }
}
