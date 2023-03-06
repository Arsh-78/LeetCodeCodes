class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> nos = new ArrayList<>();
        int n=(arr.length)-1,start=0,end=n,mid=0;
        for(int i=1;i<=2000;i++)
        {
            start = 0;
            end=n;
            while(start<=end)
            {
                mid=start+(end-start)/2;
                if(arr[mid]==i)
                {
                    break;
                }
                else if(arr[mid]>i)
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            if(start>end)
            {
                nos.add(i);
            }
        }
        return nos.get(k-1);
    }
}