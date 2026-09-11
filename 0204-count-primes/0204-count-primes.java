class Solution {
    public int countPrimes(int n) {
        boolean[] a = new boolean[n];
        Arrays.fill(a,true);
        for(int i = 2; i*i < n; i++){
            if(a[i]==true){
                for(int j=i*i;j<n;j=j+i){
                    a[j]=false;
                }
            }
        }
        int c=0;
        for(int i=2;i<n;i++){
            if(a[i]==true){
                c++;
            }
        }
        return c;
    }
}