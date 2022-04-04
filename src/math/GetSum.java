package math;

public class GetSum {
    public int getSum(int a, int b) {
        while(b !=0)
        {
            int c = a&b; //CARRY is AND of two bits
            a=a^b; //SUM of two bits is A XOR B
            //shifts carry to 1 bit to calculate sum
            b= c<<1;
        }
        return a;
    }

    public static void main(String[] args) {
        new GetSum().getSum(9,3);
    }
}
