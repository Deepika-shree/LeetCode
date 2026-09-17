class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length()-1;
        while(i>=0 && s.charAt(i) != ' '){
            i--;
        } 
        return s.substring(i+1).length(); 
    }
}