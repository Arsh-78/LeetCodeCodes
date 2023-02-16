class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(t.length()!=s.length())
        {
            return false;
        }
        
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        String temp ="";
        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i)))
            {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++)
        {
            temp += map.get(s.charAt(i));
        }
        
        return temp.equals(t);
        
    }
}