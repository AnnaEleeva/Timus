import org.junit.Assert;
import org.junit.jupiter.api.Test;


class Program1DTests {
    int a,b,c;

    @Test
    void getSolution1() {
        a=1; b=2; c=3;
        String result="7";

        Assert.assertEquals(result, Program1D.getSolution(a,b,c));
    }

    @Test
    void getSolution2() {
        a=-1; b=1; c=1;
        String result="0";

        Assert.assertEquals(result, Program1D.getSolution(a,b,c));
    }
    @Test
    void getSolution3() {
        a=0; b=1; c=1;
        String result="MANY SOLUTIONS";

        Assert.assertEquals(result, Program1D.getSolution(a,b,c));
    }

    @Test
    void getSolution4() {
        a=0; b=2; c=2;
        String result="NO SOLUTION";

        Assert.assertEquals(result, Program1D.getSolution(a,b,c));
    }
}