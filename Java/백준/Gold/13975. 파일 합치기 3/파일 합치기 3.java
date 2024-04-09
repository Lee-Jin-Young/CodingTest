import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 3 ≤ K ≤ 1,000,000
            long K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 중복가능한 정렬된 자료구조
            // 파일의 크기는 10,000을 초과하지 않는다.
            PriorityQueue<Long> minHeap = new PriorityQueue<>();

            for (int j = 0; j < K; j++) {
                minHeap.offer(Long.valueOf(st.nextToken()));
            }

            // 3 ≤ K ≤ 1,000,000
            long sum = 0;
            System.out.println(sum(minHeap, sum));

        }

    }

    private static long sum(PriorityQueue<Long> minHeap, long sum) {
        if (minHeap.size() < 2) {
            return sum;
        }

        long C1 = minHeap.poll();
        long C2 = minHeap.poll();

        minHeap.offer(C1 + C2); // 임시 파일을 만드는 비용
        sum += C1 + C2;

        return sum(minHeap, sum);
    }

}