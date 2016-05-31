package Graph;

import java.util.Scanner;

/**
 * Created by ksk on 2016-05-30.
 */
public class DFS {

    static void DFS(int vertex, int vertexCount, int[][] adjacencyMatrix, boolean[] isVisit) {
        isVisit[vertex - 1] = true;
        System.out.println("방문한 정점 : " + vertex);
        for (int i = 1; i <= vertexCount; i++) {
            if (adjacencyMatrix[vertex - 1][i - 1] == 1 && !isVisit[i - 1]) {
                System.out.println(vertex + "에서 " + i + "로 이동");
                DFS(i, vertexCount, adjacencyMatrix, isVisit);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정점의 수, 간선의 수를 입력해 주세요");
        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertexCount][vertexCount];
        boolean[] isVisit = new boolean[vertexCount];

        for (int i = 0; i < edgeCount; i++) {
            System.out.println("간선을 입력해주세요");
            int edgeStart = scanner.nextInt();
            int edgeEnd = scanner.nextInt();
            adjacencyMatrix[edgeStart - 1][edgeEnd - 1] = 1;
        }

        for (int j = 0; j < vertexCount; j++) {
            for (int k = 0; k < vertexCount; k++) {
                System.out.print(adjacencyMatrix[j][k] + " ");
            }
            System.out.println();
        }

        DFS(1, vertexCount, adjacencyMatrix, isVisit);
    }
}
