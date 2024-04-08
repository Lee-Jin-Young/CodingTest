import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정점
        int M = Integer.parseInt(br.readLine()); // 간선

        /** 무방향 그래프 **/
        ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList.get(a).add(b);
            nodeList.get(b).add(a);
        }

        /** dfs **/
        int start = 1; // 1번 컴퓨터가 바이러스

        // 노드를 저장 할 stack
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        // 방문 여부를 저장 할 배열  
        boolean[] visited = new boolean[N + 1];

        // 시작 정점에 방문
        visited[start] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            // 꺼낸 정점과 연결 된 정점 탐색  
            for (int next : nodeList.get(vertex)) {
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                    // 연결 된 정점에 방문 할 때 마다 카운트 증가  
                    count++;
                }
            }
        }

        /** 출력 **/
        System.out.println(count);
    }
}