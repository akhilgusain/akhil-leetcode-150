package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap with string as key and List as values
        Map<String, List<String>> map = new HashMap<>(); 
        // ex : {bat: [abt, bta],
        //       cat: [act, cat] } and so on ...
        // we have to sort each word and see in map if its matches any key if it matches then just add to map
        // otherwise make it as new key and initialize a new arraylist to it and repeat
        // in the end just return all the values from hashmap
        for(String word : strs){
            // convert the string to character array
            char[] charWords = word.toCharArray();
            // sort it so we can compare
            Arrays.sort(charWords);
            // now make a keyword with it so that it can be used to search in hashmap
            String keyWord = new String(charWords);
            // lets check whether its there in hashmap, if not initialize with keyword as key 
            if(!map.containsKey(keyWord)){
                map.put(keyWord, new ArrayList<>());
            }
            // otherwise just add to existing ones
            map.get(keyWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}