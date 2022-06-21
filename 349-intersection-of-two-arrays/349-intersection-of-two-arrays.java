class Solution {
    public int lsearch(int[] arr, int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
            {
                return 1;
            }
        }
        return 0;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        
        
        ArrayList<Integer> res = new ArrayList();
        for(int i = 0 ; i < nums1.length;i++)
        {
            if(lsearch(nums2,nums1[i])==1 && res.contains(nums1[i]) ==false)
            {
                res.add(nums1[i]);
            }
        }
        int[] ans =  new int[res.size()];
        for(int i =0 ;i<res.size();i++)
        {
            ans[i]=res.get(i);
        }
        return ans;
    }
}