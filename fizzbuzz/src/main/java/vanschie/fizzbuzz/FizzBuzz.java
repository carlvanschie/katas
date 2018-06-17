package vanschie.fizzbuzz;

/**
 * Created by carl on 14/06/17.
 */
public class FizzBuzz {
    public static String fizzBuzz(Integer value) {
        if(value % 15 == 0) {
            return "fizzbuzz";
        }
        if(value % 3 == 0) {
            return "fizz";
        }
        if(value % 5 == 0) {
            return "buzz";
        }
        return value.toString();
    }
}
