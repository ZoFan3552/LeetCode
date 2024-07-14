package hot100.Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int kthLargest = new KthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(kthLargest);
    }
}
