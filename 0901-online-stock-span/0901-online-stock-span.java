class StockSpanner {

      ArrayList<Integer> stock_prices = new ArrayList<>();
    public StockSpanner() {
        
      
    }
    
    public int next(int price) {
        
        stock_prices.add(price);
        int c =0;
        int i=stock_prices.size()-1;
        
        while(i>-1)
        {
            if(stock_prices.get(i)<=price)
                c++;
            else
                break;
            i--;
        }
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */