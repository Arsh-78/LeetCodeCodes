class Solution {
    public String mergeAlternately(String word1, String word2) {
     
        String temp = "";
        int fp=0;
        int sp=0;
        while(fp<word1.length() && sp<word2.length())
        {
            temp = temp+ word1.charAt(fp) + word2.charAt(sp);
            fp++;
            sp++;
        }
        
        while(fp<word1.length())
        {
            temp += word1.charAt(fp);
            fp++;
        }
        while(sp<word2.length())
        {
            temp += word2.charAt(sp);
            sp++;
        }
        return temp;
    }
}