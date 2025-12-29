package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    // for n = 2 we would do each cycle of n + 1 i.e 3
    // use frequency map to note occurence of each task
    // use heap to sort in descending order
    // take values from heap and put in temp list
    // reduce by 1 from temp list
    // again put it back in heap
    // this is one cycle i.e n + 1 interval
    // run use case with AAABB with map -> [3,2]

    // ex : Input: tasks = ["A","A","A","B","B","B"], n = 2
    // output: 8
    // A -> B -> idle -> A -> B -> idle -> A -> B 
    // idle after A and B because of n = 2
    // A and A need to be separated by at least 2 intervals

    public int leastInterval(char[] tasks, int n) {

        // Step 1 : count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task : tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Step 2 : build a max heap based on the frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        maxHeap.addAll(freqMap.values());

        // Step 3 : Process tasks

        int time = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < n + 1; i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll()); // add elements into temp ex : 3,2
                }
            }
            // decrease by 1

            for(int freq : temp){
                if(--freq > 0) maxHeap.add(freq);
            }

            // at the end add n + 1 i.e 3 in our case or the size of the temp
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return time;
    }
}
