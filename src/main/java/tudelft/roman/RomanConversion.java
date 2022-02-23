package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanConversion {
    private static Map<Character, Integer> romanToInt;

    static {
        romanToInt = new HashMap<>();
        romanToInt.put('I',1);
        romanToInt.put('V',5);
        romanToInt.put('X',10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }

    public int convert(String number){
        int convertedNumber = 0;
        for(int i=0; i<number.length(); i++){
            int currentNumber = romanToInt.get(number.charAt(i));
            int nextNumber = i+1 < number.length() ? romanToInt.get(number.charAt(i+1)) : 0;

            if(currentNumber>=nextNumber) convertedNumber+= currentNumber;
            else convertedNumber-= currentNumber;
        }
        return convertedNumber;
    }
}
