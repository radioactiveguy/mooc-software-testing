package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {
    @Test
    public void singleNumber() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XXX");
        Assertions.assertEquals(30,result);
    }

    @Test
    public void numberWithDifferentDigits() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XXVIII");
        Assertions.assertEquals(28, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void emptyString() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("");
        Assertions.assertEquals(0,result);
    }

//    @Test
//    public void invalidRomanNumber() {
//        RomanNumeral roman = new RomanNumeral();
//        Exception thrown = Assertions.assertThrows(
//                Exception.class,
//                () -> roman.convert("IIV"),
//                "Incorrect Roman number exception expected"
//        );
//        Assertions.assertTrue(thrown.getMessage().contains(""));
//    }
}
