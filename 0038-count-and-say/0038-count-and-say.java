class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n <= 0) return "";
        
        String result = "1";
        
        // Generate the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int len = result.length();
            
            // Traverse the current string to find run-length encoding
            for (int j = 0; j < len; j++) {
                int count = 1;
                
                // Count consecutive identical characters
                while (j + 1 < len && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }
                
                // Append frequency followed by the digit character
                sb.append(count).append(result.charAt(j));
            }
            
            // Update result for the next iteration
            result = sb.toString();
        }
        
        return result;
    }
}
