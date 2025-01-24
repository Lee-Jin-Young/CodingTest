class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        
        for(int i = 0; i<arr.length; i++) {
            // 홀일 경우, (length+i) % 2 => 1,0,1,0 ...
            // 짝일 경우, (length+i) % 2 => 0,1,0,1 ...
            int add = (arr.length+i)%2;
            answer[i] = arr[i] + add*n;
        }
        
        return answer;
    }
}