import org.junit.Test;
import static org.junit.Assert.*;

public class BigSignNumTest {
    @Test
    public void mul() throws Exception {
        BigSignNum x = new BigSignNum(-6);
        BigSignNum y = new BigSignNum(115);
        x.mul(y);
        assertEquals(x.toString(), "-690");
        x.mul(new BigSignNum(-333));
        assertEquals(x.toString(), "229770");
    }

    @Test
    public void sub() throws Exception {
        BigSignNum x = new BigSignNum(5);
        BigSignNum y = new BigSignNum(4);
        x.sub(y);
        assertEquals(x.toString(), "1");
        y.sub(new BigSignNum(1));
        assertEquals(y.toString(), "3");
        x.sub(y);
        assertEquals(x.toString(), "-2");
        y = new BigSignNum(4);
        y.sub(x);
        assertEquals(x.toString(), "-2");
        assertEquals(y.toString(), "6");
    }

    @Test
    public void add() throws Exception {
        BigSignNum x = new BigSignNum(2);
        x.add(new BigSignNum(2));
        assertEquals(x.toString(),"4");
        x.add(new BigSignNum(-8));
        assertEquals(x.toString(),"-4");
        x.add(new BigSignNum(2));
        assertEquals(x.toString(),"-2");
        x.add(new BigSignNum(-8));
        assertEquals(x.toString(),"-10");
    }



    @Test
    public void toStringTest() throws Exception {
        assertEquals(new BigSignNum(13).toString(), "13");
        assertEquals(new BigSignNum(-9999).toString(), "-9999");
        assertEquals(new BigSignNum(-78569).toString(), "-78569");
        BigSignNum x = new BigSignNum(-12);
        long y = Integer.parseInt(x.toString());
        assertEquals(y, -12);
    }

}
