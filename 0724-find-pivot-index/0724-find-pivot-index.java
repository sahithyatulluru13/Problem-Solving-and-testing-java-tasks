class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // Find the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Check every index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}