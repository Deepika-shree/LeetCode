class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[128];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        int length = 0;
        boolean odd = false;
        for(int i=0;i<128;i++){
            if(length % 2 == 0){
                length+=freq[i];
            }
            else{
                length = length + freq[i]-1;
                odd = true;
            }
       
        } 
        if(odd){
            length++;
        }
        return length;


    }
}