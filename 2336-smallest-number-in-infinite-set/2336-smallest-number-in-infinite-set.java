class SmallestInfiniteSet {
    
    HashMap<Integer,Integer> rec = new HashMap<Integer,Integer>();
    
    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        
        int i=1;
        while(true)
        {
            if(rec.containsKey(i))
                i++;
            else
            {
                rec.put(i,-1);
                return i;
            }

        }   
    }
    
    public void addBack(int num) {
        
        if(rec.containsKey(num))
        {
            rec.remove(num);  
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */