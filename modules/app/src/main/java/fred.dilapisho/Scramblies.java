package fred.dilapisho;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        boolean returnValue = true;
        Map<String, Long> charCountStr1 = str1.codePoints().
                mapToObj(Character::toString)
                .collect(Collectors.
                        groupingBy(Function.identity(), Collectors.counting())
                );

        Map<String, Long> charCountStr2 = str2.codePoints().
                mapToObj(Character::toString)
                .collect(Collectors.
                        groupingBy(Function.identity(), Collectors.counting())
                );
        if (charCountStr2.size() < charCountStr1.size()) {
            return false;
        } else {
            for (Map.Entry<String, Long> entry : charCountStr2.entrySet()) {
                String s = entry.getKey();
                Long aLong = entry.getValue();
                if (charCountStr2.containsKey(s) && charCountStr2.get(s) < aLong) {
                    returnValue = false;
                    break;
                }
            }
        }
        return returnValue;
    }
}
