package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // we need to encode strings like str = ['abc', 'ab', 'fr'] => 'abc#ab#fr'
    public String encode(List<String> strs) {

        if(strs.size() == 0) return Character.toString((char)258); // return string out of 257 ASCII value

        String seperate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        
        for(String s : strs){
            sb.append(s);
            sb.append(seperate);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    // decodes a single string to a list of strings
    public List<String> decode(String s){

        if(s.equals(Character.toString((char)258))) return new ArrayList<>();

        String seperate = Character.toString((char)257);
        return Arrays.asList(s.split(seperate, -1));
    }
}
