import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // trim을 통해 앞뒤 공백 제거
        String text = br.readLine().trim();
        br.close();

        // 공백의 개수 = 단어의 개수 - 1
        int before = text.length();
        text = text.replace(" ", "");
        int after = text.length();
        // 입력값이 "", " "과 같을 경우의 예외 처리
        int count = (after == 0) ? 0 : before - after + 1;

        bw.write(String.valueOf(count));
        bw.close();
    }
}