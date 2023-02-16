class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int index=0;
        int i=0,j=0;
        int k = strs.length;
        if(strs.length<=1)
        {
            if(strs.length==1)
            {
                return strs[0];
            }
            return "";
        }
        while(i<strs[0].length() && j<strs[k-1].length())
        {
            if(strs[0].charAt(i)==strs[k-1].charAt(j))
            {
                index++;
                i++;
                j++;
            }
            else
            {
                break;
            }
        }
        return strs[0].substring(0,index);
        
    }
}
