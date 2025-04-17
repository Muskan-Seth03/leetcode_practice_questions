import java.util.*;  // using 1 queue
class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        int n= q.size();
        while(n-2>=0)
        {
            q.offer(q.poll());
            n--;
        }    
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
