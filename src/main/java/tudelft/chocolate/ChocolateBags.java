package tudelft.chocolate;

public class ChocolateBags {

    public int calculate(int small, int big, int total) {
        int maxBigBoxes = total / 5;
        int bigBoxesWeCanUse = maxBigBoxes < big ? maxBigBoxes : big;
        total -= (bigBoxesWeCanUse * 5);

        if(small < total)
            return -1;
        return total;
    }
/*
     not enough bars
     2 small 1 big and total 10

     only big bars are enough
     0 small 3 big and total 15

     only small bars are enough
     4 small 0 big and total 3

     small and big bars
     3 small 4 big and total 23
*/
}
