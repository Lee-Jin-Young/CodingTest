class Solution {
    public int solution(int a, int b) {
        
        // a ⊕ b
        int plus = Integer.parseInt(a + "" + b);
        
        // 2 * a * b
        int mul = 2 * a * b;
        
        return Math.max(plus, mul);
    }
}