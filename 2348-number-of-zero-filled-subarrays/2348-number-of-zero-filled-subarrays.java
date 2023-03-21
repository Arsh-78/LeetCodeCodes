class Solution {
    public long zeroFilledSubarray(int[] nums) {
     
        int i=0;
        int j=0;
        int n=nums.length;
        int curr =0;
        long ans=0;
        while(i<n)
        {
            if(nums[i]==0)
            {
               ans += ++curr; 
            }
            else
            {
                curr=0;
            }
            i++;
        }
        return ans;
    }
}