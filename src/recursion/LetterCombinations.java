package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));

        List<String> res = new ArrayList<>();
        solve(digits, 0, map, "", res);
        return res;

    }

    public void solve(String str,int index, Map<Character, List<Character>> map, String res, List<String> list){
        if(str.length() ==0 ||str.length() <= index){
            if(res.length()>0)
                list.add(res);
            return;
        }

        char ch = str.charAt(index);
        List<Character> options = map.get(ch);
        for(int i=0; i<options.size() ; i++){
            solve(str.substring(1), index, map, res+options.get(i) , list);
        }
    }

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
    }
}
