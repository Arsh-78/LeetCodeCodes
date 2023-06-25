class Solution {

    class Pair
    {
        String first;
        int second;
        Pair(String g,int n)
        {
            this.first=g;
            this.second= n;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        Set<String> st = new HashSet<>();

        for(String s : wordList)
        {
            st.add(s);
        }
        st.remove(beginWord);

        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord))
            {
                return steps;
            }
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a' ;ch<='z';ch++)
                {
                    char[] replace = word.toCharArray();
                    replace[i] = ch;
                    String nWord = new String(replace);
                    if(st.contains(nWord))
                    {
                        st.remove(nWord);
                        q.add(new Pair(nWord,steps+1));
                    }
                }
            }
        }
        return 0;


    }
}