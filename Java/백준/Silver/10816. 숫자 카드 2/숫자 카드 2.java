import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> sgCard = new HashMap<>();
        for (int i = 0; i<N; i++) {
            int cardNumber = Integer.parseInt(st.nextToken());
            sgCard.put(cardNumber, sgCard.getOrDefault(cardNumber, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardCount = new LinkedHashMap<>();

        //찾아야 하는 카드 리스트

        st = new StringTokenizer(br.readLine());

        // 카드 카운트
        StringBuilder count = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int cardNumber = Integer.parseInt(st.nextToken());
            count.append(sgCard.getOrDefault(cardNumber, 0)).append(" ");
        }
        bw.write(count.toString().trim());

        br.close();
        bw.close();
    }
}