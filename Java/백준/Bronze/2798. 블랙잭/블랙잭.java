import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N장의 카드 오픈
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 3장의 카드
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = cards[i] + cards[j] + cards[k];

                    // M을 넘지 못하는 합 중 최대값
                    if (temp <= M && sum < temp) {
                        sum = temp;
                    }
                }
            }
        }

        // 출력
        System.out.println(sum);
    }
}