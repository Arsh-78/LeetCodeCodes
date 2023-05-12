class Solution {
    public int[] rearrangeArray(int[] nums) {
     
        int n=nums.length;
        int[] fans  = new int[n];
        int pp=0;
        int np=(n-1)/2 + 1;
        int i=0;
        while(i<n)
        {
            if(nums[i]>=0)
            {
                fans[pp]=nums[i];
                pp++;
            }
            else
            {
                fans[np]=nums[i];
                np++;
            }
            i++;
        }
        pp=0;
        np = (n-1)/2 +1;
        for(int j=0;j<n;j=j+2)
        {
            nums[j]=fans[pp++];
            nums[j+1]=fans[np++];
        }
        return nums;
    }
}