import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap: [number, frequency]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        // Keep only k most frequent elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.offer(new int[]{entry.getKey(), entry.getValue()});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Create answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}