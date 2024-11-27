package ArraysHashing;

//Top K Frequent Elements
//Solved
//Given an integer array nums and an integer k, return the k most frequent elements within the array.
//
//The test cases are generated such that the answer is always unique.
//
//You may return the output in any order.

// Koristiti Heap za ubacivanje elemenata
// Momenat kada treba k prvih elemeneata da se izabere heap je dobro resenje

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer, Integer> entry:map.entrySet())
        {
            int[] tuple = new int[2];
            tuple[0] = entry.getKey();
            tuple[1] = entry.getValue();
            priorityQueue.offer(tuple);
            if(priorityQueue.size()>k)
            {
                priorityQueue.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        for(int[]  prioEntry:priorityQueue)
        {
            res[i++] = prioEntry[0];
        }
        return res;
     }

}
