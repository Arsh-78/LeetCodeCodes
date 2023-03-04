class Solution {
    public int splitNum(int num) {
        ArrayList<Integer> mnums= new ArrayList();
        
        while(num>0)
        {
            mnums.add(num%10);
            num=num/10;
        }
        int firstNum=0;
        int secondNum=0;
        int i=0;
        int j=1;
        int n=mnums.size();
        Collections.sort(mnums);
        while(i<n)
        {
            firstNum=firstNum*10+mnums.get(i);
            
            i=i+2;
            
        }
        while(j<n)
        {
            secondNum=secondNum*10+mnums.get(j);
            
            j=j+2;
            
        }
        return firstNum+secondNum;
    }
}