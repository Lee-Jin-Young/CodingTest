import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double totalScore = 0;
        double totalCredit = 0;

        // 20줄에 걸쳐 주어진다.
        for (int i = 0; i<20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 과목명 스킵
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                double gradePoint = getGradeScore(grade);
                totalScore += credit * gradePoint;
                totalCredit += credit;
            }


        }
        bw.write(String.valueOf(totalScore / totalCredit));

        br.close();
        bw.close();
    }

    private static double getGradeScore(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return -1.0;
        }
    }
}