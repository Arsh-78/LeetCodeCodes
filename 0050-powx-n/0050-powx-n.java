class Solution {
    public double myPow(double x, int n) {
        double num=x;
        double result=1.0;
        
        if(x==0.0 ||n==0 || x==1)
        {
            return x==0.0 ? 0.0:1.0;
        }
        
        if(n<0)
        {
            x=1/x;
            num=x;
            if(n==Integer.MIN_VALUE)
            {
                result=result*x;
                n=Integer.MAX_VALUE;
                
            }
            else
            {
                n=n*-1;
            }
        }
        
    
        while(n>0)
        {
            if(n==1)
            {
                result=result*x;
                break;
            }
           else if(n%2==0)
           {
              x=x*x;
               num=x;
               n=n/2;
           }
            else
            {
                result = result*num;
                n=n-1;
            }
        }
        return result;
    }
    double helper(double x,int n,double num)
    {
        if(n==1)
        {
            return x;
        }
        if(n%2==0)
        {
             return helper(x*x,n/2,num);
        }
        else
        {
             return x * helper(x,n-1,num);
        }
    }

}