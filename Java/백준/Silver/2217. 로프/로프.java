import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> weight = new ArrayList<>();
        // 1 ~ N개의 로프 확인을 위해 0번 인덱스에 더미데이터 삽입
        // 최대 중량 = 10,000을 넘지 않는 자연수
        weight.add(10000);
        for (int i = 0; i < N; i++) {
            weight.add(Integer.valueOf(br.readLine()));
        }
        // 오름차순 일 경우 가장 약한 로프가 항상 동일
        weight.sort(Comparator.reverseOrder());


        /*
         * w/k = 로프별로 걸리는 중량
         * w = 로프의 최대중량 * k
         * 로프를 1개 쓸 경우 => 로프들의 중량 중 최댓값
         * 로프를 N개 쓸 경우 => N개의 로프 중량 중 최소값 * N
         */
        int maxWeight = 0;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                maxWeight = weight.get(1);
                continue;
            }

            maxWeight = Math.max(maxWeight, weight.get(i) * i);
        }

        System.out.println(maxWeight);

    }
}