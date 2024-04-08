import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 모두 대문자로 변경 (대소문자 구분x 조건 / 대문자 출력 조건)
        String str = br.readLine().toUpperCase();
        br.close();

        // 알파벳별 횟수 저장
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i<str.length(); i++) {
            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        int max = 0;
        char maxAlph = '?';
        // 가장 많이 나온 알파벳 찾기
        for (Map.Entry<Character, Integer> map : hashMap.entrySet()) {
            if (max < map.getValue()) {
                max = map.getValue();
                maxAlph = map.getKey();
            }
        }

        // 가장 많이 나온 알파벳이 여러개인지 확인
        int count = 0;
        for (int mapValue : hashMap.values()) {
            if (max == mapValue) {
                count++;
            }
        }

        maxAlph = count > 1 ? '?' : maxAlph;
        bw.write(String.valueOf(maxAlph));
        bw.close();
    }
}