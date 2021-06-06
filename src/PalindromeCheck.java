public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int i=0;
        int j=chars.length-1;
        while (i<=j){
            if(chars[i]!=chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
    }
}
