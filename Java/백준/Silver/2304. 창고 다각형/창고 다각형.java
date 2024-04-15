import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int index,prev, max, maxArea, end, count;
    static HashMap<Integer, Integer> area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 최대 높이
        max = 0;
        // 가장 오른쪽 기둥의 왼쪽위치
        end = 0;
        // 최대 높이 기둥이 나타나는 횟수
        count = 0;

        // 왼쪽 면 기준 정렬
        area = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            // 가장 오른쪽 기둥 구하기
            if (location > end) {
                end = location;
            }
            // 최대 높이 구하기
            if (height > max) {
                max = height;
                count = 0; // 높이가 바뀌면 카운트도 리셋
            }
            if (height == max) {
                count++;
            }

            area.put(location, height);
        }

        maxArea = 0;

        // 왼쪽 부터 가장 높은 높이까지
        index = 0;
        prev = 0;
        getArea(true);

        // 오른쪽 부터 가장 높은 높이까지
        index = end;
        prev = 0; // 초기화
        getArea(false);

        // 최대 높이의 넓이까지 합
        System.out.println(maxArea + max);
    }

    private static void getArea(boolean isLeft) {
        // 최댓값을 만나면 종료
        if (area.getOrDefault(index, 0) == max) {
            if (count == 1) { // 남은 최대높이 기둥이 1개이면 탈출
                return;
            } else {
                count--;
            }
        }

        // index 의 높이가 이전 높이보다 작을 때
        if (area.getOrDefault(index, 0) > area.getOrDefault(prev, 0)) {
            prev = index;
        }
        maxArea += area.getOrDefault(prev, 0);

        index = isLeft ? index + 1 : index - 1;

        getArea(isLeft);
    }
}
