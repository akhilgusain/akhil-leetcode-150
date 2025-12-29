package binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    // we can implement 2 hashmap i.e
    // hashmap with key and value 
    // treemap with timestamp and value
    // we have to use treemap because log arithmic value storing is there
    // K V and Color is Red Black Tree where color is the distinguishing factor
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
        // if key is there then put timestamp and value in treemap
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key); // get treemap
        if(treeMap == null) return ""; // if treemap is null then return ""
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp); // otherwise take entry
        return entry == null ? "" : entry.getValue(); 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
