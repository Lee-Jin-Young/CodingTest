import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == ')' && stack.isEmpty()) {
                    stack.push(input.charAt(j));
                    break;
                } else if (!stack.isEmpty() && stack.peek() == '(' && input.charAt(j) == ')') {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }

            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

            stack.clear();

        }


        br.close();
        bw.close();

    }
}