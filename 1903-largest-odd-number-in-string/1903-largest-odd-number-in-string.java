class Solution {
    public String largestOddNumber(String num) {
        String ans = "";
        int i=0;
        char temp ; 
        while(i<num.length())
        {
            temp = num.charAt(i);
            if(temp != '0' && temp != '2' && temp != '4' && temp != '6'  && temp != '8')
            {
                ans=num.substring(0,i+1);
            }
            i++;
        }
        return ans;
    }
}