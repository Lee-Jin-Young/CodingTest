import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queuestack = new ArrayDeque<>();
        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        while (A.hasMoreTokens()) {
            if (Integer.parseInt(A.nextToken()) == 0) {
                queuestack.add(Integer.parseInt(B.nextToken()));
            } else {
                B.nextToken();
            }
        }

        int M = Integer.parseInt(br.readLine());
        if (queuestack.isEmpty()) {
            System.out.println(br.readLine());
        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            while (st.hasMoreTokens()) {
                queuestack.addFirst(Integer.valueOf(st.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                sb.append(queuestack.pollLast()).append(" ");
            }

            System.out.println(sb);
        }

    }
}