class Solution {
    public int divisorSubstrings(int num, int k) {
        String nums=Integer.toString(num);
        int start =0;
        int end=start+k;
        int currN;
        int kb=0; 
        while(end <= nums.length())
        {
          currN = Integer.parseInt(nums.substring(start,end));
           if(currN!=0 && num%currN==0)
            {
                kb++;
            }
            start++;
            end++;
        }
        return kb;
    }
    
}