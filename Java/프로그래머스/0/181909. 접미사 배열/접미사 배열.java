import java.util.*;
import java.util.Collections;

class Solution {
    public String[] solution(String my_string) {
        List<String> suffix = new ArrayList<>();
        
        for(int i = 0; i<my_string.length(); i++) {
            suffix.add(my_string.substring(i));
        }
        
        Collections.sort(suffix);
        
        String[] answer = new String[suffix.size()];
        
        for(int i = 0; i<answer.length; i++) {
            answer[i] = suffix.get(i);
        }
        
        return answer;
    }
}