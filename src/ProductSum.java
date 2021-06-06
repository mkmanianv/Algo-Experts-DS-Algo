import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
    public static int productSum(List<Object> array) {
        return productSum(array,1);
    }
    public static int productSum(Object obj, int depth){
        int sum=0;
        if(obj instanceof ArrayList){
            ArrayList innerList =(ArrayList)obj;
            for (Object innerObj:innerList){
                sum+=productSum(innerObj,depth+1);
            }
        }else{
            return sum+=(int)obj;
        }
        return depth*sum;
    }

    public static void main(String[] args) {
            List<Object> test =
                    new ArrayList<Object>(
                            Arrays.asList(
                                    5,
                                    2,
                                    new ArrayList<Object>(Arrays.asList(7, -1)),
                                    3,
                                    new ArrayList<Object>(
                                            Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        System.out.println(ProductSum.productSum(test));
    }
}
