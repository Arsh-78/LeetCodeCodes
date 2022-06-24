class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        for(int i = 0;i<numbers.length;i++)
        {
            int nt = target-numbers[i];
            System.out.println(nt);
            int x = bS(numbers,nt,i);
            
            if(x == -1001)
            {
                continue;
            }
            else
            {
                System.out.println(i);
                ans[0]=i+1;
                ans[1]=x+1;
                break;
            }
        }
        return ans;
}
    
    int bS(int[] numbers,int target,int index)
    {
        int end = numbers.length-1;
        int start = 0;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(numbers[mid] == target && mid != index)
            {
                
                return mid;
            }
            else if(numbers[mid]>target)
            {
            end = mid-1;
            }
            else
            {
                start = mid +1;
            }
                
        }
        return -1001;
    }
}