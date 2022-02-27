package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GHappyTest {
    private GHappy ghappy;

    @BeforeEach
    void setUp() {
        this.ghappy = new GHappy();
    }

//    pusty string
//    tylko g
//    tylko gg
//    brak g
//    g i literki
//    literki i g
//    g pomiędzy literkami
//    gg i literki
//    literki i gg
//    gg pomiędzy literkami
//    gg i g w stringu
//    gg i gg w stringu
//    więcej niż 2 g w stringu obok siebie

    @Test
    public void emptyString() {
        boolean result = ghappy.gHappy("");
        Assertions.assertEquals(true, result);
    }

    @Test
    public void gOnlyInString(){
        boolean result = ghappy.gHappy("g");
        Assertions.assertEquals(false,result);
    }

    @Test
    public void ggOnlyInString(){
        boolean result = ghappy.gHappy("gg");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void noGInString(){
        boolean result = ghappy.gHappy("xasafa");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void gFirstInString(){
        boolean result = ghappy.gHappy("grandomchars");
        Assertions.assertEquals(false,result);
    }

    @Test
    public void gLastInString(){
        boolean result = ghappy.gHappy("randomcharsg");
        Assertions.assertEquals(false,result);
    }

    @Test
    public void gBetweenInString(){
        boolean result = ghappy.gHappy("randomgchars");
        Assertions.assertEquals(false,result);
    }

    @Test
    public void ggFirstInString(){
        boolean result = ghappy.gHappy("ggrandomchars");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void ggLastInString(){
        boolean result = ghappy.gHappy("randomcharsgg");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void ggBetweenInString(){
        boolean result = ghappy.gHappy("randomggchars");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void ggAndgInString(){
        boolean result = ghappy.gHappy("randomgcharsggrandom");
        Assertions.assertEquals(false,result);
    }

    @Test
    public void ggMultipleInString(){
        boolean result = ghappy.gHappy("randomggcharsggrandomggchars");
        Assertions.assertEquals(true,result);
    }

    @Test
    public void manyGTogetherInString(){
        boolean result = ghappy.gHappy("randomgggggchars");
        Assertions.assertEquals(true,result);
    }
}
