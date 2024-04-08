import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int[] score = new int[count];
        for (int i = 0; i<count; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        double sum = 0;
        for (int i : score) {
            double max = score[count-1];

            // int 와 double 의 연산 결과는 double
            sum += i / max * 100;
        }

        double avg = sum / count;
        bw.write(String.valueOf(avg));

        bw.close();
    }
}