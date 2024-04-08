import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        // 1 ≤ X ≤ 1,000,000,000
        long X = Long.parseLong(st.nextToken());
        // 0 ≤ Y ≤ 1,000,000,000
        long Y = Long.parseLong(st.nextToken());


        // 승률이 99%면 앞으로 승률을 100%로 올릴 수 없다.
        long count = -1;
        if ((100 * Y) / X < 99) {
            count = binarySearch(X, Y);
        }

        System.out.println(count);
    }

    private static long binarySearch(long X, long Y) {
        long start = 0; // 최소 게임 횟수
        long end = 1000000000; // 최대 게임 횟수
        long currentRate = (100 * Y) / X;

        while (start <= end) {
            long mid = (start + end) / 2;
            // 추가로 mid 만큼 이길 때의 승률
            long addWinRate = (100 * (Y + mid)) / (X + mid);

            // 승률이 오르지 않았을 경우
            if (addWinRate - currentRate < 1) {
                // 이긴 횟수가 더 많아져야 함
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}