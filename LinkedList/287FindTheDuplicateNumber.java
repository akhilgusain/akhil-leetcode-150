package LinkedList;

class Solution {
    public int findDuplicate(int[] nums) {
        //floyd's tortoise and hare(rabbit) algorithm
        // nums = [1,3,4,2,2]
        // finding the duplicate in array containing n+1 integers.
        // 0 -> 1 -> 3 -> 2 -> 4 -> 2 -> 4 -> 2 ... it repeats 
        // so it can be represented as  
        //          (cyclic)   
        //           |-----|
        // 1 -> 3 -> 2 -> 4
        // now we will move slow by 1 and fast twice
        // they will meet at one point.
        // before that we will come out of loop, and then reset fast pointer
        // now move slow and fast by one, hence we get the common point
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = 0;
        // reset the slow pointer or fast pointer, either will work
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // you can return either slow or fast

    }
}
