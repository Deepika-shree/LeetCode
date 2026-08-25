class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            // Case 1: Characters match, or pattern has '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: Pattern has '*'
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++; // Advance pattern pointer, assume '*' matches empty sequence first
            } 
            // Case 3: Last pattern pointer was '*', but current characters don't match
            else if (starIdx != -1) {
                pIdx = starIdx + 1; // Backtrack pattern to character after '*'
                sTmpIdx++;          // Advance string match to consume one more character with '*'
                sIdx = sTmpIdx;
            } 
            // Case 4: No match and no previous '*'
            else {
                return false;
            }
        }

        // Check for remaining characters in pattern (only '*' can remain)
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == pLen;
    }
}
