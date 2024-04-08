import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        br.close();

        // 대각선 찾기
        // 총 개수를 구하기 1, 3, 5, 10 ... 계차수열
        int start = 1;
        int startTerm = 2;
        int total = start;
        while (total < X) {
            total = total+startTerm;
            startTerm++;
        }

        // 대각선에서 몇번째인지 찾기
        int A = total - X + 1;
        int B = startTerm - (total - X) - 1;

        // 대각선의 방향
        String result = (startTerm%2 == 0)? A+"/"+B : B+"/"+A;
        bw.write(result);

        bw.close();
    }
}