package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        // TODO Auto-generated method stub
        int open=n;
        int close=n;
        List <String> ll=new ArrayList<>();
        gen(open,close,"",ll);
        return ll;
    }

    public static void gen(int open, int close, String ans,List <String>  ll) {
        // TODO Auto-generated method stub
        if(open==0 && close==0) {
            ll.add(ans);
            return;
        }
        if(open>0) {
            gen(open-1, close, ans+'(',ll);

        }

        if(close>0 && open<close) {

            gen(open, close-1, ans+')',ll);
        }


    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
