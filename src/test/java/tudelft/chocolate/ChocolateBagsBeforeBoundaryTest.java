package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChocolateBagsBeforeBoundaryTest {
    /*
     not enough bars
     2 small 1 big and total 10

     only big bars are enough
     0 small 3 big and total 15
     1 small 2 big and total 10

     only small bars are enough
     4 small 0 big and total 4

     small and big bars
     3 small 4 big and total 23
     */
    private ChocolateBags bags;

    @BeforeEach
    public void SetUp() {
        this.bags = new ChocolateBags();
    }

    @Test
    public void totalIsBiggerThanAmountOfBars() {
        int result = bags.calculate(1, 1, 10);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void onlyBigBars() {
        int result = bags.calculate(5, 3, 10);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void bigAndSmallBars() {
        int result = bags.calculate(5, 3, 17);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void onlySmallBars() {
        int result = bags.calculate(4, 2, 3);
        Assertions.assertEquals(3, result);
    }
}
