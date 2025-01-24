import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> collatz = new ArrayList<>();
        collatz.add(n);
        
        while(n!=1) {
            n = n%2==0 ? n/2 : 3*n+1;
            collatz.add(n);
        }
        
        int[] answer = new int[collatz.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = collatz.get(i);
        }
        
        return answer;
    }
}