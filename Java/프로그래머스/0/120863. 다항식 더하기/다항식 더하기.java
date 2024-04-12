class Solution {
    public static String solution(String polynomial) {
        int n = 0;
        int x = 0;

        polynomial = polynomial.replaceAll(" [+] ", " ");
        String[] arr = polynomial.split(" ");
        for (String str : arr) {
            if (str.endsWith("x")) {
                String temp = str.replace("x", "");
                if (temp.isEmpty()) {
                    temp = "1";
                }
                x += Integer.parseInt(temp);
            } else {
                n += Integer.parseInt(str);
            }
        }

        String answer = "";
        if (x != 0) {
            if (x == 1) {
                answer = answer + "x";
            } else {
                answer = answer + x + "x";
            }
        }
        if (x != 0 && n != 0) {
            answer = answer + " + ";
        }
        if (n != 0) {
            answer = answer + n;
        }
        return answer;
    }
}