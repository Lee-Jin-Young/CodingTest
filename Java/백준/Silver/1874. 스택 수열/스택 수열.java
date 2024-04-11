import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sequence;
    static StringBuilder sb;
    static Stack<Integer> stack;
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 입력받은 수열 배열 생성
        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sequence[i] = num;
        }

        sb = new StringBuilder();
        stack = new Stack<>();
        cal(0);

        System.out.println(sb);
    }

    private static void cal(int index) {
        if (index == n) {
            // 입력 된 수열을 모두 순회 했을 때 전부 출력 되지 않는다면
            if (!stack.isEmpty()) {
                sb.setLength(0);
                sb.append("NO");
            }
            return;
        }

        StringBuilder operator = new StringBuilder();

        // 예외처리
        if (stack.isEmpty()) {
            stack.push(num);
            operator.append("+").append("\n");
            num++;
        }

        while (sequence[index] > stack.peek()) {
            stack.push(num);
            operator.append("+").append("\n");
            num++;
        }

        // 목표 값 보다 stack에 담긴 값이 크거나 같으면 pop
        stack.pop();
        operator.append("-").append("\n");

        sb.append(operator);
        cal(index + 1);
    }
}