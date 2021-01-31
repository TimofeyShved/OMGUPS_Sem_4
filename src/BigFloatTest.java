import org.junit.Test;
import static org.junit.Assert.*;

public class BigFloatTest{

    @Test
    public void normalize() throws Exception {
        BigFloat x = new BigFloat(100);
        x.sub(new BigFloat(99.99f));
        x.normalize();
        float y = Float.parseFloat(x.toString());
        assertTrue(Math.abs(y - 0.01) < 0.001);
    }


    @Test
    public void mul() throws Exception {
        BigFloat x = new BigFloat(-5.3f);
        BigFloat y = new BigFloat(7.5f);
        x.mul(y);
        assertEquals(x.toString(), "-39750000e-6");
        x.mul( new BigFloat(-2.7f));
        assertEquals(x.toString(), "1073250e-4");
    }

    @Test
    public void sub() throws Exception {
        BigFloat x = new BigFloat(7.5f);
        BigFloat y = new BigFloat(5.3f);
        x.sub(y);
        assertEquals(x.toString(), "2200000e-6");
        x.sub(new BigFloat(-1.2f));
        assertEquals(x.toString(), "3400000e-6");
        x.sub(y);
        assertEquals(x.toString(), "-1900000e-6");
    }


    @Test
    public void add() throws Exception {
        BigFloat x = new BigFloat(100);
        System.out.println(x);
        x.add(new BigFloat((float) 0.01));
        float y = Float.parseFloat(x.toString());
        System.out.println(x);
        assertTrue(Math.abs(y - 100.01) < 0.001);
        x = new BigFloat(1);
        x.add(new BigFloat((float) -10000));
        y = Float.parseFloat(x.toString());
        assertTrue(Math.abs(y + 9999f) < 0.001);
    }

    @Test
    public void toStringTest() throws Exception {
        BigFloat x = new BigFloat((float) 1);
        float y = Float.parseFloat(x.toString());
        assertTrue(Math.abs(y - 1) < 0.001);
        x = new BigFloat((float) -10.01);
        y = Float.parseFloat(x.toString());
        assertTrue(Math.abs(y + 10.01) < 0.001);
    }

}
