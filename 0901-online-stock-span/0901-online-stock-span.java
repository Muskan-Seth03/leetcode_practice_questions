class StockSpanner {
    Stack<Pair> s = new Stack<>(); 
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int span = 1;
        while(!s.isEmpty() && s.peek().first <= price)
        {
            span = s.peek().second + span;
            s.pop();
        }
        s.push(new Pair(price, span));
        return span;
    }
}
class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {   
        this.first = first;
        this.second = second;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */