class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans =  new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i] < 0)
            {
                if(st.isEmpty())
                {
                    ans.add(asteroids[i]);
                }
                else
                {
                while(!st.isEmpty() && st.peek()<Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    ans.add(asteroids[i]);
                }
                else if(st.peek()==Math.abs(asteroids[i]))
                    st.pop();
                }
            }
            else
            {
                st.push(asteroids[i]);
            }
        }
        int ind =ans.size();
        while(!st.isEmpty())
        {
            ans.add(ind,st.peek());
            st.pop();
        }
        int[] fans = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            fans[i]=ans.get(i);
        }
        return fans;
    }
}