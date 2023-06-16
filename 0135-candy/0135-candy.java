class Solution {
    public int candy(int[] ratings) {
        int candies = 0;
        int[] hasCand = new int[ratings.length];
        hasCand[0]=1;
        for(int i = 1 ;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                hasCand[i] = hasCand[i-1]+1;
                
            }
            else
            {
                hasCand[i]=1;
            }
        }
        System.out.println(Arrays.toString(hasCand));
        for(int i= ratings.length-2;i>=0;i--)
        {
            
            if(ratings[i]>ratings[i+1])
            {
                if(hasCand[i] <= hasCand[i+1])
                hasCand[i]=hasCand[i+1]+1;
            }
        }
        System.out.println(Arrays.toString(hasCand));
        
        for(int i = 0;i<ratings.length;i++)
        {
            candies += hasCand[i];
        }
        return candies;
    }
}