package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

//    message:
//    null
//    empty
//    boundaries of 'a':
//    (char) ('a' - 1) out
//    'a' bound in
//    (char) ('a' + 1) in
//    boundaries of 'z':
//    (char) ('z' + 1) out
//    'z' bound in
//    (char) ('z' - 1) in
//
//    shift:
//    any negative
//    0
//    any positive
//
//
//    test cases:
//    null and any shift
//    empty and any shift
//
//    (char) ('a' - 1) and negative/positive shift
//    'a'  and negative/positive shift
//    (char) ('a' + 1) and negative/positive shift
//
//    (char) ('z' + 1) and negative/positive shift
//    'z' and negative/positive shift
//    (char) ('z' - 1) and negative/positive shift
//
//    0 shift test
//
//    only space test
//    space at start string
//    space at end string
//    space between words in string

    private CaesarShiftCipher caesar;

    @BeforeEach
    void setUp() {
        caesar = new CaesarShiftCipher();
    }

    @Test
    public void nullTest() {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            caesar.CaesarShiftCipher(null, -10);
        }, "NullPointerException was expected");

        Assertions.assertEquals("Expected String message but was null", thrown.getMessage());
    }

    @Test
    public void emptyStringTest(){
        String result = caesar.CaesarShiftCipher("", 20);
        Assertions.assertEquals("", result);
    }

    @ParameterizedTest(name = "string={0}, shift={1}, expected={2}")
    @CsvSource({
            "`testing, 10, invalid",
            "apple, 2, crrng",
            "banana, 2, dcpcpc"
    })
    public void aBoundariesInStringAndShift(String str, int shift, String expected) {
        String result = caesar.CaesarShiftCipher(str, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest(name = "string={0}, shift={1}, expected={2}")
    @CsvSource({
            "yeti, -2, wcrg",
            "zone, 3, crqh",
            "{aeroplane, 2, invalid"
    })
    public void zBoundariesInStringAndShift(String str, int shift, String expected) {
        String result = caesar.CaesarShiftCipher(str, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void zeroShiftTest(){
        String result = caesar.CaesarShiftCipher("police", 0);
        Assertions.assertEquals("police", result);
    }

    @Test
    public void onlySpaceInString(){
        String result = caesar.CaesarShiftCipher(" ", 5);
        Assertions.assertEquals(" ", result);
    }

    @Test
    public void spaceAtBeginningOfString(){
        String result = caesar.CaesarShiftCipher(" banana", 3);
        Assertions.assertEquals(" edqdqd", result);
    }

    @Test
    public void spaceAtEndOfString(){
        String result = caesar.CaesarShiftCipher("banana ", 3);
        Assertions.assertEquals("edqdqd ", result);
    }

    @Test
    public void spaceBetweenWords(){
        String result = caesar.CaesarShiftCipher("ala has a cat", -2);
        Assertions.assertEquals("yjy fyq y ayr", result);
    }
}
