class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp= new int[n];
        if(n==1 && triangle.get(0).size()==1)  //single element case
        {
            return triangle.get(0).get(0);
        }
        for(int i=0;i<n;i++)
        {
            dp[i]=triangle.get(n-1).get(i);  //Initiate all values to lowemost array
        }
        for(int i=n-2;i>=0;i--) //reverse traversal becausr straight can cause overlapping errors try [[-1],[3,2],[-3,1,-1]] for understanding
        {
            int[] tp= new int[n];
            for(int j=i;j>=0;j--)
            {
                int d=triangle.get(i).get(j) + dp[j];
                int r = triangle.get(i).get(j) + dp[j+1];
                tp[j] = Math.min(d,r);
            }
            dp=tp;
        }
        

        
        return dp[0];

    }
}