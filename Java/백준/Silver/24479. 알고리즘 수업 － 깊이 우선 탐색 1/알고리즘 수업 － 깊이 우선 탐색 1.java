import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int start = Integer.parseInt(st.nextToken()); // 시작점

        /** 무방향 그래프 **/
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()); // 간선의 한 정점
            int v = Integer.parseInt(st.nextToken()); // 간선의 다른 정덤

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        br.close();

        for (int i = 0; i <= N; i++) {
            // 인접 정점은 오름차순으로 방문
            Collections.sort(graph.get(i));
        }

        /** dfs **/
        // 노드를 저장 할 stack
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        // 방문 순서를 저장할 배열
        int[] visitOrder = new int[N + 1];

        // 방문 여부를 저장 할 배열
        boolean[] isVisited = new boolean[N + 1];

        // 시작 정점에 방문
//        isVisited[start] = true;
        int order = 1;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!isVisited[vertex]) {
                isVisited[vertex] = true;
                visitOrder[vertex] = order++;

                for (int i = graph.get(vertex).size() - 1; i >= 0; i--) {
                    int next = graph.get(vertex).get(i);

                    stack.push(next);
                }
            }

        }

        /** 출력 **/
        StringBuilder sb = new StringBuilder();
        // 1부터 시작이므로 기본 for 문 사용
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append("\n");
        }

        System.out.println(sb);
    }
}