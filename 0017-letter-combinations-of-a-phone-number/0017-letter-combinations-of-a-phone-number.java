class Solution {
    public List<String> letterCombinations(String digits) {
        int[] allUsed = new int[10];
        HashMap<Integer,String> map = new HashMap<>();
        String t = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> ans = new ArrayList<>();
        if(digits.length()==0)
        {
            return ans;
        }
        int counter =0;
        for(int i=2;i<=9;i++)
        {
            if(i==9)
            {
                map.put(i,t.substring(counter));
            }
            else if(i==7)
            {
                 map.put(i,t.substring(counter,counter+4));
                counter=counter+4;
            }
            else
            {
                map.put(i,t.substring(counter,counter+3));
                counter=counter+3;
            }
        }
        for(int i=0;i<digits.length();i++)
        {
            allUsed[digits.charAt(i)-'0']++;
        }
        helper("",digits,digits,map,ans);
        System.out.println(ans);
        
        return ans;
    }

    void helper(String p,String up,String digits,HashMap<Integer,String> map,ArrayList<String> ans)
    {
        if(p.length()==digits.length())
        {
            ans.add(p);
        }
        if(up.length()==0)
        {
            return;
        }
        else
        {
            String temp=map.get(up.charAt(0)-'0');
            for(int i=0;i<temp.length();i++)
            {
                helper(p+temp.charAt(i),up.substring(1),digits,map,ans);
            }

        }
    }
    
}