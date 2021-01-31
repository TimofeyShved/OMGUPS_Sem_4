public class Lab_main {
    public static void main(String[] args){
        System.out.println("Hello world!");

        System.out.println("-______________________1____________________________-");

        BigNum x = new BigNum(8);
        BigNum y = new BigNum(3);
        x.sub(y);
        System.out.println("");
        System.out.println("x");
        System.out.println(x.toString());
        System.out.println("y");
        System.out.println(y.toString());

        x.mul(y);
        System.out.println("mul x y");
        System.out.println("x");
        System.out.println(x.toString());
        System.out.println("y");
        System.out.println(y.toString());

        System.out.println("-_______________________2___________________________-");

        BigSignNum z = new BigSignNum(-3);
        BigSignNum v = new BigSignNum(-12);

        System.out.println(z.toString());
        System.out.println(v.toString());
        z.sub(v);
        System.out.println(z.toString());
        z.sub(v);
        System.out.println(z.toString());
        v.sub(z);
        System.out.println(v.toString());
        z.mul(v);
        System.out.println(z.toString());

        System.out.println("-________________________3__________________________-");

        BigFloat d = new BigFloat(-4.5f);
        BigFloat f = new BigFloat(2.3f);

        System.out.println(d.toString());
        System.out.println(f.toString());
        d.add(f);
        System.out.println(d.toString());
        d.sub(f);
        System.out.println(d.toString());
        d.sub(f);
        System.out.println(d.toString());
        f.sub(d);
        System.out.println(f.toString());
        d = new BigFloat(-8.2f);
        f = new BigFloat(2.5f);
        d.mul(f);
        System.out.println(d.toString());

    }
}
