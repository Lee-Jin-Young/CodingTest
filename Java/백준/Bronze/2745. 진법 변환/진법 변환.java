import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        String N = sc.next();
        // 출력 조건에 오류에 대한 조건이 없으므로 ABC 5와 같은 잘못된 입력은 고려하지 않음
        int base = sc.nextInt();

        long result = 0;
        for (int i = 0; i < N.length(); i++) {
            char digit = N.charAt(i);
            int value;

            // 아스키코드 변환
            if(Character.isDigit(digit)) {
                value = digit - '0';
            } else {
                value = digit - 'A' + 10;
            }

            result = result * base + value;
        }

        System.out.println(result);

    }
}