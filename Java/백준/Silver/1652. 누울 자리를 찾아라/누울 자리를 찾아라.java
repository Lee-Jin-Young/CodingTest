import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        boolean[][] isEmpty = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < size; j++) {
                // .일 경우 빈 공간(true)
                isEmpty[i][j] = (row.charAt(j) == '.');
            }
        }

        int countWE = 0;
        int countNS = 0;

        for (int i = 0; i < size; i++) {
            int count = 0;

            for (int j = 0; j < size; j++) {
                // 가로 - 마지막 열은 제외
                if (j < size - 1 && isEmpty[i][j] && isEmpty[i][j + 1]) {
                    count++;
                }

                // 기존에 공간이 있는데 벽을 만날 경우
                if (count > 0 && !isEmpty[i][j]) {
                    countWE++;
                    count = 0;
                }
            }

            // 2칸이상 비어있는 경우가 있었다면
            if (count > 0) {
                countWE++;
            }
        }

        for (int j = 0; j < size; j++) {
            int count = 0;

            for (int i = 0; i < size; i++) {
                // 세로 - 마지막 행은 제외
                if (i < size - 1 && isEmpty[i][j] && isEmpty[i + 1][j]) {
                    count++;
                }

                // 기존에 공간이 있는데 벽을 만날 경우
                if (count > 0 && !isEmpty[i][j]) {
                    countNS++;
                    count = 0;
                }
            }

            if (count > 0) {
                countNS++;
            }
        }

        System.out.println(countWE + " " + countNS);
    }

}