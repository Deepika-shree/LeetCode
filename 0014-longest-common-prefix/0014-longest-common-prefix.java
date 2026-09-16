import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] arr) {

        Arrays.sort(arr);

        StringBuilder s = new StringBuilder();

        String first = arr[0];
        String last = arr[arr.length - 1];

        int len = Math.min(first.length(), last.length());

        for (int i = 0; i < len; i++) {

            if (first.charAt(i) != last.charAt(i)) {
                return s.toString();
            }

            s.append(first.charAt(i));
        }

        return s.toString();
    }
}