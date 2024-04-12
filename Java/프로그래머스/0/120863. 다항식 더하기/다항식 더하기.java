class Solution {
    public static String solution(String polynomial) {
        int n = 0;
        int x = 0;

        polynomial = polynomial.replaceAll(" [+] ", " ");
        String[] arr = polynomial.split(" ");

        for (String str : arr) {
            if (str.endsWith("x")) {
                // x로 끝나는 항일 경우 x의 지수 추출
                String temp = str.replace("x", "");
                if (temp.isEmpty()) {
                    temp = "1";
                }
                x += Integer.parseInt(temp);
            } else {
                // 상수항일 경우 계수 추출
                n += Integer.parseInt(str);
            }
        }

        // 결과를 저장할 문자열 초기화
        StringBuilder result = new StringBuilder();

        // x의 지수가 0이 아니면 결과 문자열에 추가
        if (x != 0) {
            result.append(x == 1 ? "x" : x + "x");
        }

        // x의 지수가 0이 아니고 상수항이 0이 아니면 결과 문자열에 "+" 추가
        if (x != 0 && n != 0) {
            result.append(" + ");
        }

        // 상수항이 0이 아니면 결과 문자열에 추가
        if (n != 0) {
            result.append(n);
        }

        // 결과 문자열 반환
        return result.toString();
    }
}