class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add the current element to the existing subarray
            // or start a new subarray from the current element
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update the global maximum if the current subarray sum is larger
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        
        return maxSoFar;
    }
}
