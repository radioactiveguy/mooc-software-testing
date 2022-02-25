package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTestWithBeforeEach {

    private RomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }

    @Test
    public void singleNumber() {
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        int result = roman.convert("XXX");
        Assertions.assertEquals(30,result);
    }

    @Test
    public void numberWithDifferentDigits() {
        int result = roman.convert("XXVIII");
        Assertions.assertEquals(28, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void emptyString() {
        int result = roman.convert("");
        Assertions.assertEquals(0,result);
    }

//    @Test
//    public void invalidRomanNumber() {
//        Exception thrown = Assertions.assertThrows(
//                Exception.class,
//                () -> roman.convert("IIV"),
//                "Incorrect Roman number exception expected"
//        );
//        Assertions.assertTrue(thrown.getMessage().contains(""));
//    }
}
