package arrays;

import java.util.PriorityQueue;

public class ConnectSticks {

    public int connectSticks(int[] sticks) {
        if(sticks.length == 1)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;
        for(int i = 0; i < sticks.length; i++){
            pq.add(sticks[i]);
        }
        int prev = 0;
        int curr = 0;
        while(!pq.isEmpty()){
            prev = pq.poll();
            if(pq.isEmpty()){
                ans = prev + curr;
                break;
            }else{
                curr = pq.poll();
            }
            ans += prev + curr;
            if(!pq.isEmpty()){
                pq.add(prev+curr);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        new ConnectSticks().connectSticks(new int[]{2,4,3});
    }
}
