package tudelft.numfinder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumFinderTest {
    NumFinder nf;

    @BeforeEach
    void setUp() {
        nf = new NumFinder();
    }

    @Test
    public void findLargestWithMaxInteger() {
        nf.find(new int[] {4, Integer.MAX_VALUE, 2, 1});
        Assertions.assertEquals(Integer.MAX_VALUE, nf.getLargest(), "largest value in array");
    }

    @Test
    public void findSmallestWithMaxInteger() {
        nf.find(new int[] {4, Integer.MAX_VALUE, 2, 1});
        Assertions.assertEquals(1, nf.getSmallest(), "smallest value in array");
    }

    @Test
    public void findLargestWithMinInteger() {
        nf.find(new int[] {4, Integer.MIN_VALUE, 2, 1});
        Assertions.assertEquals(4, nf.getLargest(), "largest value in array");
    }

    @Test
    public void findSmallestWithMinInteger() {
        nf.find(new int[] {4, Integer.MIN_VALUE, 2, 1});
        Assertions.assertEquals(Integer.MIN_VALUE, nf.getSmallest(), "smallest value in array");
    }


}