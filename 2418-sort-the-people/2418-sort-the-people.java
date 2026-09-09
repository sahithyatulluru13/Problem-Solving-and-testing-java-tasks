import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        Integer[] index = new Integer[heights.length];

        // Store indexes
        for (int i = 0; i < heights.length; i++) {
            index[i] = i;
        }

        // Sort indexes based on heights
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

        // Create result
        String[] result = new String[names.length];

        for (int i = 0; i < index.length; i++) {
            result[i] = names[index[i]];
        }

        return result;
    }
}