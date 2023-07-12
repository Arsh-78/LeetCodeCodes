class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> nge2 =new HashMap<>();
        int[] nge1 =new int[nums1.length];
        
        int i = nums1.length-1;
        int j= nums2.length-1;
        nge2.put(nums2[j],-1);
        st.push(nums2[j]);
        j--;
        while(j>=0)
        {
            if(nums2[j]>nums2[j+1])
            {
                while(!st.isEmpty() && st.peek()<=nums2[j])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    
                    nge2.put(nums2[j],-1);
                }
                else
                    nge2.put(nums2[j],st.peek());
                st.push(nums2[j]);
                
            }
            else
            {
                if(st.isEmpty())
                {
                    nge2.put(nums2[j],-1);
                }
                else
                     nge2.put(nums2[j],st.peek());
                st.push(nums2[j]);
            }
            j--;
           
        }
        while(i>=0)
        {
            nge1[i] = nge2.get(nums1[i]);
            i--;
        }
        return nge1;
    }
}