class Solution {
    public int minimumOperations(String num) {
     
        Stack<Integer> st = new Stack<>();
        int n1 = num.lastIndexOf('5');
        int n2 = num.lastIndexOf('0');
        //System.out.println(n1+" "+n2);
        int len = num.length();
        int a1=-1;
        int z=0;
        for(int i=0;i<num.length();i++)
        {
            if(num.charAt(i)=='0')
                z++;
            if((num.charAt(i)=='2' || num.charAt(i)=='7') && i<n1)
            {
                a1=Math.max(a1,i);
            }
        }
            
        int a2=-1;
        for(int i=0;i<num.length();i++)
        {
            if((num.charAt(i)=='0' || num.charAt(i)=='5') && i<n2)
            {
                a2=Math.max(a2,i);
            }
        }
        if(a1!=-1) 
            a1 = len-1-n1 +n1-a1-1;
        if(a2!=-1)
            a2 = len-1-n2 +n2-a2-1;
        //System.out.println(a1+" "+a2);
        if(a1==-1 && a2==-1)
        {
            return len-z;
        }
        else if(a1==-1 || a2==-1)
        {
            return Math.max(a1,a2);
        }
        else
        {
            return Math.min(a1,a2);
        }
    }
}