package stack;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // ideal scenario is if we start from an index and we encounter the next bar to be greater then we simply just add to stack
        // otherwise for any fall scenario i.e if height gets decrease on subsequent bar then we will need to calculate the area
        // in other words
        // If you see increasing bars, store their indices.
        // If a smaller bar comes, you know the previous taller bars can't extend further — calculate area.
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // here we assume a bar at starting, it acts as a base for left most bar so we add left most bar to stack
        int maxArea = 0;

        // now iterate over bars
        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){ // this is decreasing scenario
                int height = heights[stack.pop()]; // we pop since we have found a new bar thats crucial for area calculation, i.e 2 in ex1
                int width = i - stack.peek() - 1; 
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // this is ideal scenario
        }

        // stack if non empty then we need to calculate area for remaining bars
        while(stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1; //height.length is the righter most boundary
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
