class Solution {
    public String multiply(String num1, String num2) {
        // Handle edge case for zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        
        // Loop from right to left for both strings
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Indices in the result array where the product belongs
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add current multiplication to previous remaining carry
                int sum = mul + result[p2];
                
                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }
        
        // Convert the result array to a String
        StringBuilder sb = new StringBuilder();
        for (int p : result) {
            // Skip leading zeros
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }
}
