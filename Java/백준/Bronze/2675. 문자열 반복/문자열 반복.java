import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < count; t++) {
            int repeat = sc.nextInt();
            String testCase = sc.next();

            StringBuilder sb = new StringBuilder();
            for (char ch : testCase.toCharArray()) {
                for (int i = 0; i < repeat; i++) {
                    sb.append(ch);
                }
            }

            System.out.println(sb);
        }
    }
}