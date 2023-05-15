class Solution {
    public void nextPermutation(int[] nums) {
       
        int bp=-1;
        int n = nums.length-1;
        for(int i=n;i>0;i--)
        {
            if(nums[i-1]<nums[i])
            {
                bp=i-1;
                break;
            }
        }
        
        if(bp==-1)
        {
            reverse(nums,0);
            return;
        }
        int ngi=bp;
        
        for(int i=n;i>=0;i--)
        {
            if(nums[i]>nums[bp])
            {
                ngi = i;
                break;
            }
        }
        System.out.println(nums[bp]+"--"+nums[ngi]);
        int temp = nums[bp];
        nums[bp]=nums[ngi];
        nums[ngi]=temp;
        
        reverse(nums, bp+1);
        return;
    }
    
    public void reverse(int[] arr,int s)
    {
        int i=s;
        int j=arr.length-1;
        int temp;
        while(i<j)
        {
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return ;
    }
}