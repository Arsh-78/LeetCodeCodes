class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        if(n==0)
        {
            return true;
        }
        if(flowerbed.length==1)
        {
            if(flowerbed[0]==0 && n==1)
            {
                return true;
            }
        }
        while(i<flowerbed.length)
        {
            if(i==0)
            {
                if(flowerbed[i]==0 && flowerbed[i+1]==0)
                {
                    n--;
                    i=i+2;
                }
                else
                {
                    i++;
                }
            }
            else if(i==flowerbed.length-1)
            {
                if(flowerbed[i-1]==0  && flowerbed[i]==0)
                {
                    n--;
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0)
                {
                    n--;
                    i=i+2;
                }
                else
                {
                    i++;
                }
            }
        }
        return n<=0 ;
    }
}