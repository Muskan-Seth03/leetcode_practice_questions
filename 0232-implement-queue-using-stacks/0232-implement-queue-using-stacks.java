class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    int peek = -1;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        if(output.isEmpty() && input.isEmpty())
        {
            peek = x;
        }
        input.push(x);
    }
    
    public int pop() {
        if(!output.isEmpty())
        {
            int val = output.pop();
            
            if(!output.isEmpty())
            {
                peek = output.peek(); 
            }
            else
            {
                if(input.isEmpty())
                peek = -1;
                
                else
                {
                    while(!input.isEmpty())
                    {
                        output.push(input.pop());
                    }
                    peek = output.peek();
                }
            }
            return val; 
        }
        else
        {
            while(!input.isEmpty())
            {
                output.push(input.pop());
            }
            return output.pop();
        }
    }
    
    public int peek() {
        if(output.isEmpty())
        {
            return peek;
        }
        else
        {
            return output.peek();
        }
    }
    
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */