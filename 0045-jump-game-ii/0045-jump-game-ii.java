class Solution {
    public int jump(int[] nums) {
     
        int maxIndex=nums[0];
        int n =nums.length;
        int steps = nums[0];
        int jump=1;
        int i=1;
        if(nums.length==1)
        {
            return 0;
        }
        if(nums[0]>=n-1)
        {
            return 1;
        }
        while(i<n)
        {
         
           
            maxIndex = Math.max(maxIndex,i+nums[i]);
            steps--;
            if(steps==0)
            {
                jump++;
                if(i>maxIndex)
                {
                    return -1;
                }
                if(maxIndex>=n-1)
                {
                    return jump;
                }
                
                
                steps=maxIndex-i;
            }
            
            i++;
        }
        return jump;
    }
}