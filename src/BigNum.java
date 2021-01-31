public class BigNum {
    static final int base = 100;
    static final int len = 4;
    byte [] digits;
    boolean sign=true;  //знак - или +

    BigNum(){
        digits = new byte[len];
    }

    BigNum(long x){
        this();
        fromLong(x);
    }

    BigNum(BigNum bigNum){
        digits = bigNum.digits.clone();
    }

    void fromLong(long x){
        for(int i=0; x>0; i++){
            digits[i] = (byte) (x % base);
            x = x / base;
        }
    }

    void add(BigNum x){
        // сложение
        byte c=0;
        int sum;
        for(int i=0; i<len; i++){
            sum = digits[i]+x.digits[i]+c;
            digits[i] = (byte) (sum % base);
            c = (byte) (sum / base);
        }
    }

    void sub(BigNum x){
        int new_sub_num;
        //переменные
        byte[] newer_num = new byte[len],
                my_one_Num = new byte[len],
                my_two_Num = new byte[len];
        if (isLarger(x)){
            //кто больше?
            my_one_Num =digits;
            // для правильного порядка отнимания
            my_two_Num =x.digits;
        }
        else {
            sign=false;
            my_two_Num =digits;
            my_one_Num =x.digits;
        }
        for(int i=0; i<len; i++){
            //цикл
            new_sub_num = my_one_Num[i] - my_two_Num[i];
            //вычитание
            if (new_sub_num <0){
                //больше 0?
                new_sub_num +=base;
                my_one_Num[i+1]-=1;
                //забираем еденицу у впереди стоящего
            }
            my_one_Num[i]=(byte) new_sub_num;
            //записываем в новое число
        }
        this.digits= my_one_Num;
        //записываем нужные числа в начальную переменную
    }

    void mul(BigNum x){             //умножение
        int tmpNum;
        BigNum newerNum = new BigNum();        //переменные
        BigNum summNum = new BigNum();
        BigNum shiftNum = new BigNum();
        byte[] my_one_Num = new byte[len],
                my_two_Num = new byte[len];
        my_one_Num =digits;
        my_two_Num =x.digits;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                //2 цикла
                tmpNum = my_one_Num[i]* my_two_Num[j];
                //в переменную записываем полученное число
                for(int k=0; k<len; k++){
                    //сдвиг в зависимости от положения
                    shiftNum.digits[k]=0;
                    newerNum.digits[k]=0;
                }
                newerNum.fromLong(tmpNum);//перевод в другой формат
                for(int k=0; k<len; k++){
                    shiftNum =mulDigit(newerNum.digits[k],(j+i+k));
                    summNum.add(shiftNum);
                    //сумма
                }
            }
        }
        digits = summNum.digits;
    }

    boolean isLarger(BigNum x){
        for(int i=len-1; i>=0; i--){
             //вычислениее большего
            if (digits[i]!=x.digits[i]) {
                if (digits[i]>x.digits[i]) {
                    return true;
                }
                else {
                    return false;
                }

            }
        }
        return false;
    }

    private BigNum mulDigit(byte digit, int shift) {
        //сдвиг при умножении
        BigNum mulDigitNum = new BigNum();
            mulDigitNum.digits[0] = digit;
        mulDigitNum.shift(shift);
        return mulDigitNum;
    }

    void shift(int x){
        //сдвиг
        if(x<0){
            for (int j=0; j>x; j--) {
                for (int i = 0; i<len-1; i++) {
                    digits[i] = digits[i+1];
                }
                digits[3]=0;
            }
        }
        else {
            for (int j=0; j<x; j++) {
                for (int i = len-1; i>0; i--) {
                    digits[i] = digits[i-1];
                }
                digits[0]=0;
            }
        }
    }

    public String toString(){
        String result = "";
        int i = len - 1;
        while(i>0 & digits[i]==0)
            i--;
        while(i>=0) {
            String d = ((Byte) digits[i--]).toString();
            if(d.length()==1)
                d = "0" + d;
            result = result + d;
        }
        if(result.charAt(0)=='0')
            return result.substring(1);
        return result;
    }

}
