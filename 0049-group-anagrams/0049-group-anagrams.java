import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base case check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // Map to store grouped anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);
            
            // Initialize the list if the key doesn't exist
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            // Add original string to the corresponding anagram group
            map.get(sortedKey).add(s);
        }
        
        // Return all grouped lists
        return new ArrayList<>(map.values());
    }
}
