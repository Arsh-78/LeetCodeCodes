class Solution {
    public int numberOfSteps(int num) {
        
        if(num<=1)
        {
            return num==1 ? 1:0;
        }
        if(num % 2 ==0)
        {
            return 1+numberOfSteps(num/2);
        }
        return 1 + numberOfSteps(num-1);
    }
}