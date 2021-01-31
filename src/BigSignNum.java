public class BigSignNum {
    private BigNum num;
    private boolean isPositive;

    BigSignNum(long x) {
        if(x>0) {
            num = new BigNum(x);
            isPositive = true;
        } else {
            num = new BigNum(-x);
            isPositive = false;
        }
    }

    BigSignNum(BigSignNum x) {
        num = new BigNum(x.num);
        isPositive = x.isPositive;
    }

    void add(BigSignNum x){
        if(x.isPositive){   //+?
            if(isPositive){ //+?
                num.add(x.num);
            }
            else {
                if(x.num.isLarger(num)){
                    isPositive=true;
                }
                num.sub(x.num);
            }
        }
        else {
            if(isPositive){ //+?
                if(x.num.isLarger(num)){
                    isPositive=false;
                }
                num.sub(x.num);
            }
            else{
                num.add(x.num);
            }
        }
    }

    void sub(BigSignNum x){

        if(x.isPositive){   //+?
            if(isPositive){ //+?
                if(x.num.isLarger(num)){
                    isPositive=false;
                }
                num.sub(x.num);
            }
            else {
                num.add(x.num);
            }
        }
        else {
            if(isPositive){     //+?
                num.add(x.num);
            }
            else{
                if(x.num.isLarger(num)){
                    isPositive=true;
                }
                num.sub(x.num);
            }
        }

    }

    void mul(BigSignNum x){
        //умножение
        num.mul(x.num);
        if(((x.isPositive)&&(isPositive))||((!x.isPositive)&&(!isPositive)))
        {   //++ или --?
            isPositive=true;
        }
        else {
            isPositive=false;
        }
    }

    public String toString(){
        if(isPositive)
            return num.toString();
        else
            return "-"+num.toString();
    }

}
