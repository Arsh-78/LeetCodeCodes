class Solution {
    
    
    public int longestStrChain(String[] words) {
        
        int n = words.length;
        int[] dp = new int[n]; //longest predecessor sequence till n
        
        Arrays.sort(words,Comparator.comparingInt(String :: length));
        //System.out.println(Arrays.toString(words));
        
        Arrays.fill(dp,1);
       
        int ans=0;
        for(int i=0;i<n;i++)
        {
            String curWord=words[i];
            for(int j=0;j<i;j++)
            {
                if(checkP(curWord,words[j]) && dp[i] <= dp[j] +1)
                {
                    dp[i] = Math.max(dp[i],1 +dp[j]);
                    //System.out.println(curWord + " " + words[j] +" "+dp[i]+" "+dp[j]);
                }
            }
            if(ans<dp[i])
            {
                ans=dp[i];
            }
          
        }
        return ans;
        
    }
    
    boolean checkP(String a,String b)
    {
        if(Math.abs(a.length()-b.length()) != 1)
            return false;
        
        
        int i =0 ;
        int j=0;
        while(i<a.length() && j<b.length())
        {
            if(a.charAt(i)!= b.charAt(j))
            {
                i++;
            }
            else
            {
            i++;
            j++;
            }
        }
        if(j<b.length())
        {
            return false;
        }
        return true;
        
    }
}