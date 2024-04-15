import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 주유소 간의 거리 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        // 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다.
        long min = 1000000001;
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            int now = Integer.parseInt(st.nextToken());
            min = Math.min(min, now);

            sum += min * distance[i];
        }

        System.out.println(sum);
    }
}