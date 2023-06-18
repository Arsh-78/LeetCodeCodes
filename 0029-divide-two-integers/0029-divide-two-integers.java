class Solution {
    public int divide(int dividend, int divisor) {

    if(dividend==Integer.MIN_VALUE && divisor ==-1)
    {
        return Integer.MAX_VALUE;
    }    

     int res = 0;
     int quotient =0;
     int sign = (divisor>=0)== (dividend>=0) ? 1 :-1;
     dividend = Math.abs(dividend);
     divisor = Math.abs(divisor);
     System.out.println(sign);
     while(dividend - divisor >=0) 
     {
         int count = 0;
         while(dividend-(divisor<<1<<count) >=0)
         {
             count++;
         }
         res += 1<<count;
         dividend -= divisor<<count;
     }   

     return sign==1 ? res : -res;
    }
}