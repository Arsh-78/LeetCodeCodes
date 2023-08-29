class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nr=nsr(heights);
        int[] nl =nsl(heights);
        
//         System.out.println(Arrays.toString(nr));
//         System.out.println(Arrays.toString(nl));
        
        int max=0;
        for(int i=0;i<heights.length;i++)
        {
            max=Math.max((Math.abs(nr[i]-nl[i])-1)*heights[i],max);
        }
        return max;
    }
    
    int[] nsl(int[] heights)
    {
         int[] res  =new int[heights.length];
        Stack<Integer> st = new Stack<Integer>();
        int start=0 ;
        st.push(start);
        res[start]=-1;
        start++;
        while(start<heights.length)
        {
            if(heights[start] <=heights[start -1])
            {
                while(!st.isEmpty() && heights[start] <= heights[st.peek()])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    res[start]=-1;
                }
                else
                {
                    res[start]=st.peek();
                }
                st.push(start);
            }
            else
            {
                 if(st.isEmpty())
                {
                    res[start]=-1;
                }
                else
                {
                    res[start]=st.peek();
                }
                st.push(start);
            }
            start++;
        }
        return res;
    
    }
    int[] nsr(int[] heights)
    {
        int[] res  =new int[heights.length];
        Stack<Integer> st = new Stack<Integer>();
        int end = heights.length-1;
        st.push(end);
        res[end]=end+1;
        end--;
        while(end>=0)
        {
            if(heights[end]<= heights[end+1])
            {
                while(!st.isEmpty() && heights[end] <= heights[st.peek()])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    res[end]=heights.length;
                }
                else
                {
                    res[end]=st.peek();
                }
                st.push(end);
            }
            else
            {
                 if(st.isEmpty())
                {
                    res[end]=heights.length;
                }
                else
                {
                    res[end]=st.peek();
                }
                st.push(end);
            }
            end--;
        }
        return res;
    
    }
}