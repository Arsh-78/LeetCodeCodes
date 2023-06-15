class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gp = 0;
        int sp = 0;
        int c=0;
        while(gp<g.length && sp<s.length)
        {
            if(s[sp] >= g[gp])
            {
                c++;
                sp++;
                gp++;
            }
            else
            {
                sp++;
            }
        }
        return c;

    }
}