class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> ia = new ArrayList<int[]>();
        int[] temp = new int[2];
        temp[0]=intervals[0][0];
        temp[1]=intervals[0][1];
        
        for(int i=1 ; i<intervals.length;i++)
        {
            if(intervals[i][0]>=temp[0] && intervals[i][0]<=temp[1])
            {
                temp[1]=Math.max(intervals[i][1],temp[1]);
                
            }
            else
            {
                ia.add(new int[]{temp[0],temp[1]});
                temp[0]=intervals[i][0];
                temp[1]=intervals[i][1];
                
            }
        }
        
        ia.add(temp);

        int[][] fans = new int[ia.size()][2];
        for(int i=0 ; i<ia.size();i++)
        {
            fans[i][0]=ia.get(i)[0];
            fans[i][1]=ia.get(i)[1];
        }
        return fans;
    }
}