import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        int sum = 0;

        n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        String money = "";
        for (int i = 0; i<n; i++) {
            money = br.readLine();
            if (money.equals("0")) {
                stack.pop();
            } else {
                stack.push(money);
            }
        }

        for (String str : stack) {
            sum += Integer.parseInt(str);
        }

        bw.write(Integer.toString(sum));
        br.close();
        bw.close();
    }
}