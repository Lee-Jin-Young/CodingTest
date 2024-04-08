import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 현재 탑보다 낮은 탑들을 스택에서 pop하여 제거함 (더 낮으면 레이저 막힙)
            while (!stack.isEmpty() && stack.peek()[1] <= height) {
                stack.pop();
            }

            // 스택이 비어있지 않으면 현재 탑의 신호를 수신하는 탑이 있음
            if (!stack.isEmpty()) {
                sb.append(stack.peek()[0] + 1).append(" ");
            } else { // 스택이 비어있으면 현재 탑의 신호를 수신하는 탑이 없음
                sb.append("0 ");
            }

            // 현재 탑의 높이와 인덱스를 스택에 저장함
            stack.push(new int[]{i, height});
        }

        System.out.println(sb);
    }
}
