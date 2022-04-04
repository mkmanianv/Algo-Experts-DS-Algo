package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k)
    {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else
            {
                map.put(num, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>((o1, o2)->o2.getValue()-o1.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.offer(entry);
        }

        for(int i = 0; i < k; i++){
            res.add(pq.poll().getKey());
        }



        return res;

    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[]{1,1,1,2,2,3},1 ));
    }
}
