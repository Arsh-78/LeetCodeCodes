class Solution {
    public int divisorSubstrings(int num, int k) {
        String nums=Integer.toString(num);
        int start =0;
        int end=0;
        int currN;
        int kb=0;
        while(end-start+1<=k)
        {
            end++;
        }
        
        while(end <= nums.length())
        {
          currN = Integer.parseInt(nums.substring(start,end));
            System.out.println(currN);
            if(isD(num,currN))
            {
                kb++;
            }
            start++;
            end++;
        }
        return kb;
    }
    
    boolean isD(int num,int d)
    {
        if(d==0)
            return false;
        return num%d==0;
    }
}