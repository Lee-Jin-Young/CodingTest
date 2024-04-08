import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        String[] words = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.nextLine();
        }

        String start = "";
        String end = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("?")) {
                start = (i == 0) ? "" : String.valueOf(words[i - 1].charAt(words[i - 1].length() - 1));
                end = (i == words.length-1) ? "" : String.valueOf(words[i + 1].charAt(0));
                // 재귀 함수 사용 시 return
            }
        }

        String[] candidate = new String[Integer.parseInt(sc.nextLine())];
        for (int i = 0; i < candidate.length; i++) {
            candidate[i] = sc.nextLine();
        }

        for (String cand : candidate) {
            if (!containWord(cand, words) && cand.startsWith(start) && cand.endsWith(end)) {
                System.out.println(cand);
            }
        }
    }

    private static boolean containWord(String candidate, String[] words) {
        for (String word : words) {
            if (candidate.equals(word)) {
                return true;
            }
        }
        return false;
    }
}