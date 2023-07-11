
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int start=0;
        int end=0;
        int cur=0;
        int ans=0;
        int f=k;

        while(end<n)
        {
            if(nums[end]==1)
            {
                cur++;
                end++;
            }
            else
            {
                if(f==0)
                {
                    ans=Math.max(ans,cur);
                   if(start==end)
                   {
                       end++;
                       start++;
                   }
                   else
                   {
                       cur--;
                       if(nums[start]==0)
                       {
                        f++;   
                       }
                       start++;
                   }

                }
                else
                {
                    f--;
                    cur++;
                    end++;
                }
            }
            
        }
        ans=Math.max(cur,ans);
        return ans;

    }
}