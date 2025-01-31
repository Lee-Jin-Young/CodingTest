import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int stu = score.length;
        
        // {[평균, 인덱스], ...}
        List<double[]> avgWithIndex = new ArrayList<>();
        
        for(int i = 0; i<stu; i++) {
            avgWithIndex.add(new double[]{(score[i][0] + score[i][1]) / 2.0, i});
        }
        
        // 중복o 정렬o 자료형 => Heap
        // 배열의 정렬이므로 어떤 값을 기준으로 정렬 할 것인지 작성해야함
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        
        for (double[] avg : avgWithIndex) {
            pq.offer(avg);
        }
        
        int[] ranks = new int[stu];
        int rank = 1;
        double prevScore = -1;
        
        for(int i = 0; i<stu; i++) {
            double[] student = pq.poll();
            
            // 새로운 점수일 경우
            if(prevScore != student[0]) {
                rank = i+1;
                prevScore = student[0];
            }
            
            ranks[(int)student[1]] = rank;
            
        }
        
        return ranks;
        
    }
}