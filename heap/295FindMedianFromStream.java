package heap;

import java.util.PriorityQueue;

class MedianFinder {
    // we will make two heaps
    // first that will store first half will be max heap and second would be min heap
    // all element in max heap should be less than of min heap
    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> b - a); // max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

    public MedianFinder() {

    }

    public void addNum(int num) {
        lo.offer(num); // add to max heap
        hi.offer(lo.poll()); // balance the min heap

        if (lo.size() < hi.size()) { // maintain size property
            lo.offer(hi.poll());
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */