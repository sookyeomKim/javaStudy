package Graph;

import java.util.*;

/**
 * Created by ksk on 2016-05-30.
 */
public class BFS {
    static void BFS(int vertex, int vertexCount, int[][] adjacencyMatrix, boolean[] isVisit, Queue<Integer> queue) {
        isVisit[vertex - 1] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            for (int i = 1; i <= vertexCount; i++) {
                if (adjacencyMatrix[vertex - 1][i - 1] == 1 && !isVisit[i - 1]) {
                    System.out.println(vertex + "에서 " + i + "로 이동");
                    isVisit[i - 1] = true;
                    queue.add(i - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
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

        BFS(1, vertexCount, adjacencyMatrix, isVisit, queue);
    }
}
