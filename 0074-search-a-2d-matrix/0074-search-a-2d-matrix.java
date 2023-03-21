class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowS=0;
        int rowE=matrix.length-1;
        int scanR=0;
        int mid =0;
        while(rowS<=rowE)
        {
            mid = rowS+(rowE - rowS)/2;
            
            if(matrix[mid][0]==target)
            {
                return true;
            }
            else if(matrix[mid][0]<target)
            {
                
                rowS=mid+1;
            }
            else
            {
                rowE=mid-1;
            }
        }
        scanR=rowE;
        int s=0;
        int e = matrix[0].length-1;
        while(s<=e && scanR>-1)
        {
            mid = s+(e-s)/2;
            if(matrix[scanR][mid]==target)
            {
                return true;
            }
            else if(matrix[scanR][mid]<target)
            {
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return false;
    }
}