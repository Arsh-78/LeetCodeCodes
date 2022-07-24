class Solution {
    public String removeDuplicates(String s) {
     Stack<Character> stk = new Stack<Character>();
         
         int i = 0;
        while(i<s.length())
        {
            if(stk.isEmpty())
            {
                stk.push(s.charAt(i));
                i++;
            }
            else if(s.charAt(i)==stk.peek())
            {
                stk.pop();
                i++;
            }
            else
            {
                stk.push(s.charAt(i));
                i++;
            }
        }
        String temp = "";
        while(!stk.isEmpty())
        {
            temp+= stk.pop();
        }
        StringBuilder ans = new StringBuilder();
        ans.append(temp);
        return ans.reverse().toString();
    }
}