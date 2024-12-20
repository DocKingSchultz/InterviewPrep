package BinarySearch;

import java.util.PriorityQueue;
//Find Median From Data Stream
//The median is the middle value in a sorted list of integers. For lists of even length, there is no middle value, so the median is the mean of the two middle values.
//
//For example:
//
//For arr = [1,2,3], the median is 2.
//For arr = [1,2], the median is (1 + 2) / 2 = 1.5

// 2 Heapa dobra fora, kako ih balansirati ?

public class MedianFinder {
    PriorityQueue<Integer> heapLeft;
    PriorityQueue<Integer> heapRight;
    public MedianFinder() {
        heapLeft = new PriorityQueue<>((a,b)->b-a);
        heapRight = new PriorityQueue<>((a,b)->a-b);
    }

    // O(logn)
    public void addNum(int num) {
        if (heapLeft.isEmpty() || num <= heapLeft.peek()) {
            heapLeft.add(num);
        } else {
            heapRight.add(num);
        }

        // Balance the heaps
        if (heapLeft.size() > heapRight.size() + 1) {
            heapRight.add(heapLeft.poll());
        } else if (heapRight.size() > heapLeft.size()) {
            heapLeft.add(heapRight.poll());
        }
    }

    // findMedian O(1)
    public double findMedian() {
        if(heapLeft.size()> heapRight.size())return heapLeft.peek();
        else if(heapLeft.size()< heapRight.size())return heapRight.peek();
        return  (double) (heapLeft.peek() + heapRight.peek()) /2.0;
    }
}
