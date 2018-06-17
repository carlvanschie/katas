package vanschie.roman;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by carl on 18/06/17.
 */
public class Roman {
    private static final Map<Integer, String> MAPPINGS = new LinkedHashMap();
    static {
        MAPPINGS.put(1000, "M");
        MAPPINGS.put(500, "D");
        MAPPINGS.put(400, "CD");
        MAPPINGS.put(100, "C");
        MAPPINGS.put(90, "XC");
        MAPPINGS.put(50, "L");
        MAPPINGS.put(40, "XL");
        MAPPINGS.put(10, "X");
        MAPPINGS.put(9, "IX");
        MAPPINGS.put(5, "V");
        MAPPINGS.put(4, "IV");
        MAPPINGS.put(1, "I");
    }

    public static String translate(int input) {
        return process(new StringBuilder(), input).toString();
    }

    private static StringBuilder process(StringBuilder stringBuilder, int input) {
        for(Map.Entry<Integer, String> entry : MAPPINGS.entrySet()) {
            if(input / entry.getKey() >= 1) {
                return process(stringBuilder.append(entry.getValue()), input - entry.getKey());
            }
        }
        return stringBuilder;
    }
}
