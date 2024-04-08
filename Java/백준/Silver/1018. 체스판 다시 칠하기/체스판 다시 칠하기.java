import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 개행문자 삭제

        // 주어진 보드
        String[] row = new String[N];
        for (int i = 0; i < N; i++) {
            row[i] = sc.nextLine();
        }


        int min = 32; // 최대 32 ( 전부 W거나 B )

        // 8 * 8 당 필요한 색칠 횟수 구하기 (체스판의 개수만큼 반복)
        //총 체스판의 개수 = (N-7) * (M-7)
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = 0;

                count = differ(row, i, j);

                // min보다 count가 작을 경우 min = count;
                if (min > count) {
                    min = count;
                }
            }
        }

        System.out.println(min);

    }

    private static int differ(String[] row, int startRow, int startCol) {
        // W로 시작 할 경우
        int countW = 0;
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                // 짝+짝, 홀+홀 == 짝수, 짝+홀 == 홀수
                char wb = (i + j) % 2 == 0 ? 'W' : 'B';

                if (row[i].charAt(j) != wb) {
                    countW++;
                }
            }
        }

        return Math.min(countW, 64-countW);
    }
}