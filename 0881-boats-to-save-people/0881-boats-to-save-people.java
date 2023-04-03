class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int boats =0;
        int currentwt=0;
        int sp=0;
        int ep = people.length-1;
        while(sp<=ep)
        {
            if(people[sp]+people[ep]<=limit)
            {
                boats++;
                sp++;
                ep--;
            }
            else
            {
                boats++;
                ep--;
            }
            
        }
        return boats;
        
    }
}