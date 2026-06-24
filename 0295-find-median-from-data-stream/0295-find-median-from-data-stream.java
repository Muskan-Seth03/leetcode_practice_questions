//TC: The overall time complexity is O(log N) for the addNum method and O(1) for the findMedian method.
//SC: O(N).
class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty()|| num < leftMaxHeap.peek())
        {
            leftMaxHeap.offer(num);
        }
        else
        {
            rightMinHeap.offer(num);
        }
        // maintain the size of both heap --> leftMAxHEap size should be greater than right min heap

        if(leftMaxHeap.size() - rightMinHeap.size() > 1)
        {
            rightMinHeap.offer(leftMaxHeap.poll());
        }
        else if(leftMaxHeap.size() < rightMinHeap.size())
        {
            leftMaxHeap.offer(rightMinHeap.poll());
        }        
    }
    
    public double findMedian() {
        int m = leftMaxHeap.size();
        int n = rightMinHeap.size();

        if(m == n)
        {
            // even
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek())/2;
        }
        return (double)leftMaxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */