class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix[0].length;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int[] r:matrix)
        {
            reverse(r);
        }
        
    }

    void reverse(int[] nums)
    {
        int s=0;
        int e= nums.length-1;
        while(s<=e)
        {
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
        return;
    }
}