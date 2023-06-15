class Solution {
    public int findLongestChain(int[][] pairs) {

     Arrays.sort(pairs,(a,b)->a[1]-b[1]);
     int chain =1;
     int currEnd=pairs[0][1];

     for(int i=1;i<pairs.length;i++)
     {
         if(pairs[i][0]>currEnd)
         {
             chain++;
             currEnd=pairs[i][1];
         }
     }

     return chain;
    }
}