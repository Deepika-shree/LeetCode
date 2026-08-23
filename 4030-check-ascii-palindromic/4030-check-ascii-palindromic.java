class Solution {
    public boolean isPalindromic(String s) {
        String str = "";

        for(char c : s.toCharArray()){
            String bin = Integer.toBinaryString(c);

            while(bin.length() < 8){
                bin = "0" + bin;
            }
            str += bin;
        }
        
        int left = 0;
        int right = str.length() - 1;
        char[] cs = str.toCharArray();
        
        while(left < right){
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;

            left ++;
            right --;
        }
        
        return Arrays.equals(str.toCharArray(), cs);
    }
}