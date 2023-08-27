class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int start=0;
        int end=cardPoints.length-1;
        int s=0;
        int i=0;
        int max=0;
        int c=0;
        while(c<k)
        {
            s+=cardPoints[start++];
            c++;
        }
        if(start==end+1)
            return s;
        start--;
        //System.out.println(start+" "+s);
        max=s;
        while(start>-1)
        {
            s-=cardPoints[start--];
            //System.out.println(s);
            s+=cardPoints[end--];
            //System.out.println(s);
            max=Math.max(s,max);
            
        }
        return max;
    }
}