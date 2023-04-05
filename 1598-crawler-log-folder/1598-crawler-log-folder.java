class Solution {
    public int minOperations(String[] logs) {
        int counter=0;
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].equals("../"))
            {
                if(counter-1<0)
                {
                    counter = 0;
                }
                else
                {
                    counter--;
                }
            }
            else if(logs[i].equals("./"))
            {
                continue;
            }
            else
            {
                counter++;
            }
        }
        return counter;
    }
}