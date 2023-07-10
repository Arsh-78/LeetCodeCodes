class Solution {
    public int maxProfit(int[] prices) {
     int bp=prices[0];
     int profit=0;
     int cp=0;
     for(int i=0;i<prices.length;i++)
     {
         if(bp>prices[i])
         {
             bp=prices[i];
         }
         cp=prices[i]-bp;
         if(cp>0)
         {
             profit+=cp;
             bp=prices[i];
         }

     }  
     return profit; 
    }
}