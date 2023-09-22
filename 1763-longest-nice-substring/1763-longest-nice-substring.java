class Solution {
    
    public String longestNiceSubstring(String s) {
     
        Set<Character> st = new HashSet();
       for(char c : s.toCharArray()){
           st.add(c);}
        
        for(int i=0;i<s.length();i++)
        {
            if(st.contains(Character.toUpperCase(s.charAt(i))) && st.contains(Character.toLowerCase(s.charAt(i))))
                continue;
            
            String l1 = longestNiceSubstring(s.substring(0,i));
            String l2 = longestNiceSubstring(s.substring(i+1));
            
            return l1.length()>=l2.length() ? l1 : l2;
        }
        return s;
        
    }
}