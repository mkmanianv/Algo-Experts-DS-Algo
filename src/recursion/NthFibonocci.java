package recursion;

public class NthFibonocci {
    public static int getNthFib(int n) {
        if(n ==2){
            return 1;
        }else if (n == 1){
            return 0;
        }else {
            return getNthFib(n-1)+getNthFib(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(12));
    }
}
