import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 최대 힙에 거인의 키 저장
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            maxHeap.offer(Integer.valueOf(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        int count = 0;
        //
        while (maxHeap.peek() > 1 && count < T && maxHeap.peek() >= centi) {
            int max = maxHeap.poll();
            int half = max / 2;
            maxHeap.offer(half);

            count++;

            // 가장 키 큰 거인이 센티보다 작을 경우
            if (maxHeap.peek() < centi ) {
                break;
            }
        }

        if (maxHeap.peek() < centi) {
            sb.append("YES\n").append(count);
        } else {
            sb.append("NO\n").append(maxHeap.peek());
        }


        System.out.println(sb);
    }

}