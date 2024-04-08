import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        LocalDate date = LocalDate.of(2007,sc.nextInt(),sc.nextInt());
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int dayOfWeek = date.getDayOfWeek().getValue()-1;

        System.out.println(days[dayOfWeek]);
    }
}
