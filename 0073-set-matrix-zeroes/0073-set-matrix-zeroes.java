class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        // Find all zeros position
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        // replace rows with zeros
        for(int i=0;i<m;i++){
            if(row[i]){
                for(int j=0;j<n;j++){
                    mat[i][j]=0;
                }
            }
        }
        // replace columns with zeros
        for(int j=0;j<n;j++){
            if(col[j]){
                for(int i=0;i<m;i++){
                    mat[i][j] = 0;
                }
            }
        }
        
    }
}