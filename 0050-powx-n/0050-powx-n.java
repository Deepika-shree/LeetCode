class Solution {
    public double myPow(double x, int n) {
        // Use long to prevent integer overflow when handling Integer.MIN_VALUE
        long N = n;
        
        // Handle negative exponents
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        // Binary exponentiation loop
        while (N > 0) {
            // If the current exponent bit is odd, multiply the result
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base
            currentProduct *= currentProduct;
            // Halve the exponent
            N /= 2;
        }
        
        return result;
    }
}
