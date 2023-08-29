class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Integer> st = new Stack<>();
        int i=0;
        if(k==num.length())
            return "0";
        while(i<num.length())
        {
            int cur = num.charAt(i)-'0';
            
                while(!st.isEmpty() && st.peek() >cur && k>0)
                {
                    st.pop();
                    k--;
                }
                st.push(cur);
            i++;
                
        }
        
        while(k>0)
        {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
       while(!st.isEmpty())
             sb.append(st.pop());
         sb.reverse();
        
         //remove all the 0 at the head
         while(sb.length()>1 && sb.charAt(0)=='0')
             sb.deleteCharAt(0);
         return sb.toString();
        
    }
}

// public class Solution {
//     public String removeKdigits(String num, int k) {
//         int len = num.length();
//         //corner case
//         if(k==len)        
//             return "0";
            
//         Stack<Character> stack = new Stack<>();
//         int i =0;
//         while(i<num.length()){
//             //whenever meet a digit which is less than the previous digit, discard the previous one
//             while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
//                 stack.pop();
//                 k--;
//             }
//             stack.push(num.charAt(i));
//             i++;
//         }
        
//         // corner case like "1111"
//         while(k>0){
//             stack.pop();
//             k--;            
//         }
        
//         //construct the number from the stack
//         StringBuilder sb = new StringBuilder();
//         while(!stack.isEmpty())
//             sb.append(stack.pop());
//         sb.reverse();
        
//         //remove all the 0 at the head
//         while(sb.length()>1 && sb.charAt(0)=='0')
//             sb.deleteCharAt(0);
//         return sb.toString();
//     }
// }







// class Solution {
//     public String removeKdigits(String num, int k) {
//         Stack<Integer> container = new Stack<>();
//         for (int index = 0; index < num.length(); index++) {
//             int curr = num.charAt(index) - '0';
// 			// start reading from left to right and add numbers to stack in increasing order
//             // pop numbers from stack as long as the stack isn't empty and
//             // we have a smaller number for some location and 
// 			// we haven't exhausted `k` removals
//             if (!container.isEmpty() && container.peek() > curr) {
//                 while (!container.isEmpty() && container.peek() > curr && k-- > 0) {
//                     container.pop();  
//                 }
//             }
//             container.add(curr); // add to monotonic stack
//         }
        
//         // if we haven't exhausted all 'k' removals
//         // we can remove more larger items from top of stack
//         while (k-- > 0 && !container.isEmpty()) {
//             container.pop();
//         }
        
//         StringBuilder sb = new StringBuilder();
//         while (!container.isEmpty()) {
//             sb.append(container.pop());
//         }
//         sb.append("0"); // to handle empty case - eg: [123] 3
//         sb.reverse();
        
//         String tempAns = sb.toString();
//         // trim all 0s in front of the number
//         for (int i = 0; i < tempAns.length(); i++) {
//             if (tempAns.charAt(i) != '0') {
//                 return tempAns.substring(i);
//             }
//         }
//         return "0";
//     }
// }