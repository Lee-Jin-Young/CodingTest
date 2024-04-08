import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 정렬 된 int 형 배열로 변환
        int[] person = Arrays
                .stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int sum = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            // 한 사람 당 걸리는 시간 누적
            time += person[i];
            // 총 걸리는 시간
            sum += time;
        }

        System.out.println(sum);
    }
}