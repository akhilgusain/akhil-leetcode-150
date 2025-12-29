package stack;

import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // since time = distance/speed hence we arrange the car based on time it takes to reach target
        int n = position.length;
        double [][]cars = new double[n][2]; //initialize the 2d array for position and time tracking
        // since we need to calculate time by dividing two ints i.e why we initialize double type 2d array
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        // now lets sort the cars data by their position
        Arrays.sort(cars, (a,b)->Double.compare(b[0], a[0]));
        int fleetCount = 0;
        double prevCarTime = 0;

        for(double[] car : cars){
            // if current car is faster i.e take less time then it will be its own fleet
            // else it will be added to existing fleet
            if(car[1] > prevCarTime){
                fleetCount++;
                prevCarTime = car[1];
            } 
        }
        return fleetCount;
    }
}
