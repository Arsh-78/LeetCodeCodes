class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forprod = new int[nums.length];
        forprod[0] =nums[0];
        int n =nums.length;
        int[] backprod = new int[n];
        backprod[n-1] = nums[n-1];
        int[] ans = new int[n];
        for(int i = 1;i < n ;i++ )
        {
            forprod[i] = nums[i]*forprod[i-1];
        }
        for(int i=n-2;i>0;i--)
        {
            backprod[i]=nums[i]*backprod[i+1];
        }
        
        for(int i =0 ;i<n;i++)
        {
            if(i==0)
            {
                ans[i]=backprod[i+1];
                
            }
            else if(i == n-1)
            {
                ans[i]=forprod[i-1];
            }
            else
            {
                ans[i]=forprod[i-1] * backprod[i+1];
            }
        }
        System.out.println(Arrays.toString(forprod));
        System.out.println(Arrays.toString(backprod));
        return ans;
        
    }
}