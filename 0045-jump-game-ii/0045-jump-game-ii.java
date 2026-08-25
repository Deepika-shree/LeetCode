class Solution {
    public int jump(int[] nums) {
        // Base case: if array has 1 element, 0 jumps needed
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Loop through array elements except the last one
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the furthest index reachable from current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;             // Make another jump
                currentEnd = farthest; // Set the new boundary
                
                // If we can already reach or exceed the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
