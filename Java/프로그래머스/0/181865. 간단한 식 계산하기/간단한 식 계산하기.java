import java.util.StringTokenizer;

class Solution {
    public int solution(String binomial) {
        StringTokenizer st = new StringTokenizer(binomial);
        
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        if(op.equals("+")) {
            return a+b;
        } else if(op.equals("-")) {
            return a-b;
        } else {
            return a*b;
        }
    }
}