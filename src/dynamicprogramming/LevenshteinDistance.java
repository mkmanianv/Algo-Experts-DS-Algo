package dynamicprogramming;

public class LevenshteinDistance {

    public static void main(String[] args) {
        levenshteinDistance("abc","yabd");
    }

    public static int levenshteinDistance(String str1, String str2) {
    int[][] edits=new int[str1.length()+1][str2.length()+1];
    for(int i=0;i<str2.length();i++){
        for(int j=0;j<str1.length();j++){
            edits[i][j]=j;
        }
        edits[i][0]=i;
    }
    return -1;
  }
}
