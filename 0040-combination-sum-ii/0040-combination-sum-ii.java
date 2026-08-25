import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 1. Sort to handle duplicates and enable early pruning
        Arrays.sort(candidates);
        // 2. Start backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> results) {
        // Base Case: Target met
        if (remain == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early Pruning: Remaining target is smaller than the smallest available number
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate combinations at the same depth
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Make choice
            current.add(candidates[i]);
            
            // Move to next element (i + 1 ensures each number is used only once)
            backtrack(candidates, remain - candidates[i], i + 1, current, results);
            
            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}
