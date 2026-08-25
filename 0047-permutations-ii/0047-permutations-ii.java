import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array to place duplicates next to each other
        Arrays.sort(nums);
        // 2. Track which elements are already included in the current permutation
        boolean[] used = new boolean[nums.length];
        // 3. Initiate the backtracking process
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the current permutation is complete, add it to the results
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current path
            if (used[i]) continue;
            
            // Skip duplicates: if the current number is the same as the previous one,
            // and the previous one was not used in this path, skip to avoid duplicate permutations.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Make a choice
            used[i] = true;
            current.add(nums[i]);

            // Recurse
            backtrack(nums, used, current, result);

            // Undo the choice (backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
