class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> mp = new HashMap<>();
        mp.put("I",1);
        mp.put("IV",4);
        mp.put("V",5);
        mp.put("IX",9);
        mp.put("X",10);
        mp.put("XL",40);
        mp.put("L",50);
        mp.put("XC",90);
        mp.put("C",100);
        mp.put("CD",400);
        mp.put("D",500);
        mp.put("CM",900);
        mp.put("M",1000);
        
        int cur =0;
        int i=0;
        while(i<s.length())
        {
            if(i==s.length()-1)
            {
                 cur+=mp.get(s.substring(i,i+1));
                   break;
            }
            if(mp.containsKey(s.substring(i,i+2)))
               {
                   cur+=mp.get(s.substring(i,i+2));
                   i=i+2;
               }
              else
               {
                   cur+=mp.get(s.substring(i,i+1));
                   i++;
               }
        }
          
        return cur;
    }
}