import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String[] arr = name.split("-");

        for (String s : arr) {
            System.out.print(s.charAt(0));
        }
    }
}