package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TwoNumbersSumTest {
    private TwoNumbersSum tns;
    private ArrayList<Integer> a1;
    private ArrayList<Integer> a2;
    private ArrayList<Integer> expected;

    @BeforeEach
    void setUp() {
        this.tns = new TwoNumbersSum();
        this.a1 = new ArrayList<>();
        this.a2 = new ArrayList<>();
        this.expected = new ArrayList<>();
    }

    @Test
    public void addOneDigitNumbers(){
        a1.add(1);
        a2.add(5);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(6);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addOneDigitToTwoDigitNumber(){
        a1.add(2);
        a2.add(3); a2.add(7);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(3); expected.add(9);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTwoDigitToOneDigitNumber(){
        a1.add(2); a1.add(1);
        a2.add(3);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(2); expected.add(4);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTwoFewDigitNumbers(){
        a1.add(2); a1.add(1); a1.add(3); a1.add(7);
        a2.add(4); a2.add(2); a2.add(0);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(2); expected.add(5); expected.add(5); expected.add(7);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void singleDigitsWhichSumIsTen(){
        a1.add(4);
        a2.add(6);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(1); expected.add(0);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void singleDigitsWhichSumMoreThanTen(){
        a1.add(8);
        a2.add(9);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(1); expected.add(7);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void multipleDigitsWhichSumMoreThanTen(){
        a1.add(8); a1.add(7); a1.add(6);
        a2.add(9); a2.add(8);

        ArrayList<Integer> result = tns.addTwoNumbers(a1, a2);
        expected.add(9); expected.add(7); expected.add(4);

        Assertions.assertEquals(expected, result);
    }

}
