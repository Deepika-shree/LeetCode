import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; // Exceeded the target sum, stop exploring this path
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                // Move forward, but keep 'i' as the start index because we can reuse the same element
                backtrack(result, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }
}
