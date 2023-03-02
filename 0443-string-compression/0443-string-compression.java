class Solution {
    public int compress(char[] chars) {
        if(chars.length<=1)
        {
            return chars.length;
        }
        int charp=1;
        int countp=1;
        char currchar=chars[0];
        String s="";
        while(charp<chars.length)
        {
            if(currchar==chars[charp])
            {
                countp++;
                charp++;
            }
            else
            {
                if(countp>1)
                {
                    s = s + currchar+countp;
                    countp=1;
                    currchar=chars[charp];
                    charp++;
                }
                else
                {
                    s=s+currchar;
                    countp=1;
                    currchar=chars[charp];
                    charp++;
                }
                
            }
        }
        if(countp>1)
        {
        s = s + currchar+countp;
        }
        if(countp==1)
        {
            if(s.charAt(s.length()-1) != currchar)
                s=s+currchar;
        }
        System.out.println(s);
        for(int i=0;i<s.length();i++)
        {
            chars[i]=Character.valueOf(s.charAt(i));
        }
       
        return s.length();
    }
}