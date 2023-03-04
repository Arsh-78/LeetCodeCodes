class Solution {
    public int countGoodNumbers(long n) {
        if(n==1)
        {
            return 5;
        }
        long oddIndex = n/2;
        long evenIndex = n%2==0 ? n/2 : n/2+1 ;
        System.out.println(oddIndex + ":"+evenIndex);
        long mod = 1000000007;
        long evenp= pow(5,evenIndex,mod);
        long oddp = pow(4,oddIndex,mod);
        System.out.println(evenp + "+" + oddp);

        long ans = (oddp*evenp)%mod;
        return Math.toIntExact(ans);
    }


    public long pow(long num,long index,long mod)
    {
        if(index==1)
        {
            return num;
        }
        if(index%2==0)
        {
            
            return pow((num*num)%mod,index/2,mod);
        }
        else
        {
            return (num*pow((num*num)%mod,index/2,mod)) % mod;
        }
    }
}