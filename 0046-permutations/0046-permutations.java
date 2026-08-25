import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // Base case: if the current list matches the size of nums, a permutation is found
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip elements that are already in the current permutation path
            if (tempList.contains(nums[i])) {
                continue; 
            }
            
            // Add the element to the current path
            tempList.add(nums[i]);
            
            // Recurse to explore further choices
            backtrack(result, tempList, nums);
            
            // Remove the last added element to backtrack and try other paths
            tempList.remove(tempList.size() - 1);
        }
    }
}
