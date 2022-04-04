package dynamicprogramming;

import java.util.*;

public class LongestIncreasingSubsequence {

    private int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }

    public int longestIncreasingSubSequence(int input[]){
        int T[] = new int[input.length];
        int T1[] = new int[input.length];
        int R[] = new int[input.length];
        for(int i=0; i < R.length ; i++) {
            R[i] = -1;
        }
        T[0] = 0;
        int len = 0;
        for(int i=1; i < input.length; i++){
            if(input[T[0]] > input[i]){ //if input[i] is less than 0th value of T then replace it there.
                T[0] = i;
                T1[0]=input[i];
            }else if(input[T[len]] < input[i]){ //if input[i] is greater than last value of T then append it in T
                len++;
                T[len] = i;
                T1[len]=input[i];
                R[T[len]] = T[len-1];
            }else{ //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(input, T, len,input[i]);
                T[index] = i;
                T1[index]=input[i];
                R[T[index]] = T[index-1];
            }
        }

        //this prints increasing subsequence in reverse order.
        System.out.print("Longest increasing subsequence ");
        int index = T[len];
        while(index != -1) {
            System.out.print(input[index] + " ");
            index = R[index];
        }

        System.out.println();
        return len+1;
    }

    public int longestSubsequenceWithActualSolution(int arr[]){
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }

        //find the index of max number in T
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }

        //lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();

        return T[maxIndex];
    }

    public static void main(String[] args) {
//        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
//        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3});
//        new LongestIncreasingSubsequence().longestSubsequenceWithActualSolution(new int[]{3,1,5,0,6,4,9});
        new LongestIncreasingSubsequence().longestIncreasingSubSequence(new int[]{3,1,5,0,6,4,9});
    }
}
