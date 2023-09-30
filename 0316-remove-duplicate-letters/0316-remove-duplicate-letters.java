class Solution {
    public String removeDuplicateLetters(String s) {

        int[] a = new int[26];
        boolean[] seen = new boolean[26];
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i)-'a']=i;
        }

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            int cur = s.charAt(i)-'a';
            if(seen[cur])continue;
            while(!st.isEmpty() && cur < st.peek() && i<a[st.peek()])
            {
                seen[st.peek()]=false;
                st.pop();
            }
            st.push(cur);
            seen[cur]=true;

        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())sb.append((char)(st.pop()+'a'));
        return sb.reverse().toString();
        
    }
}