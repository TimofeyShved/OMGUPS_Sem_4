import java.lang.*;

class BigFloat extends BigNum{
    private boolean isPositive;
    private long shift;

    BigFloat(float x){
        super();
        shift = -(long) (Math.log10(1000000/Math.abs(x))/2);
        long xl = (long) (x*Math.pow(100, -shift));
        if(x>0)
            isPositive = true;
        else {
            xl = -xl;
            isPositive = false;
        }
        fromLong(xl);
        normalize();
    }

    BigFloat(BigFloat x){
        super(x);
        isPositive = x.isPositive;
        shift = x.shift;
    }

    private void calcShift(BigFloat x){
        if(shift < x.shift)
            shift((int) (shift- x.shift));
        else
            x.shift((int) (x.shift - shift));
        shift = Math.max(shift, x.shift);
    }

    void normalize(){
        int i;
        for(i=len-1; i>=0 && digits[i]==0; i--)
            ;
        shift(len-i-1);
        shift = shift - len + i + 1;
    }

    void add(BigFloat x) {
        BigFloat floatNum = new BigFloat(x);
        System.out.println(floatNum);
        System.out.println(this);
        if (floatNum.isPositive) {
            calcShift(floatNum);
            if (isPositive)
                super.add(floatNum);
            else if (super.isLarger(floatNum))
                super.sub(floatNum);
            else {
                ((BigNum) floatNum).sub(this);
                digits = floatNum.digits.clone();
                shift = floatNum.shift;
                isPositive = false;
            }
            normalize();
        } else {
            floatNum.isPositive = true;
            sub(floatNum);
        }
        System.out.println(this);
    }

    void sub(BigFloat x) {
        BigFloat floatNum = new BigFloat(x);
        calcShift(floatNum);
        if(x.isPositive)
        {   //+?
            if(isPositive)
            {   //+?
                if(super.isLarger(floatNum))
                {
                    super.sub(floatNum);
                }
                else {
                    ((BigNum) floatNum).sub(this);
                    digits = floatNum.digits.clone();
                    shift = floatNum.shift;
                    isPositive = false;
                }
            }
            else {
                super.add(floatNum);
            }
        }
        else {
            if(isPositive)
            {   //+?
                super.add(floatNum);
            }
            else {
                if(super.isLarger(floatNum))
                {   //больше?
                    super.sub(floatNum);
                }
                else {
                    ((BigNum) floatNum).sub(this);
                    digits = floatNum.digits.clone();
                    shift = floatNum.shift;
                    isPositive = false;
                }
            }
        }
        normalize();
    }

    void mul(BigFloat x){
        //умножение
        BigFloat floatNum = new BigFloat(x);
        calcShift(floatNum);
        //переменные
        floatNum.shift(-2);
        super.shift(-2);
        super.mul((BigNum) floatNum);
        shift=shift+ floatNum.shift+4;
        if(((x.isPositive)&&(isPositive))||((!x.isPositive)&&(!isPositive)))
        {   //++ или --?
            isPositive=true;
        }
        else {
            isPositive=false;
        }
        normalize();
    }

    public String toString(){
        String sign = isPositive?"":"-";
        return sign + super.toString() + "e" + ((Long)(shift*2)).toString();
    }
}
