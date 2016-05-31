package Graph;

import java.util.*;

/**
 * Created by ksk on 2016-05-30.
 */
public class Dijkstra {
    private static int extract_min(LinkedList Q, LinkedList S, double[] D) {
        double min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (Object e : Q) {
            if (!S.contains(e) && min > D[(int) e]) {
                min = D[(int) e];
                minIndex = (int) e;
            }
        }

        //도달할 수 없는 경로일 때
        if (minIndex == -1) {
            minIndex = (int) Q.get(0);
        }

        Q.remove(Q.indexOf(minIndex));

        return minIndex;
    }

    private static void printSolution(double[] D, int vertexCount, int[] pathTracer) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < vertexCount; i++)
            System.out.println(i + " \t\t " + D[i]);
        System.out.println("---------------");
        for (int i = 0; i < vertexCount; ++i) {
            int j;
            System.out.print("Path = " + i);
            j = i;
            do {
                j = pathTracer[j];
                System.out.print("<-" + j);
            } while (j != 0);

            System.out.println();
        }
    }

    private static void applyDijkstra(double[][] W, int startVertex, int vertexCount) {
        //function Dijkstra(G, w, s)
        //  for each vertex v in V(G)
        //      d[v] := infinity
        //      pathTracer[v] := undefined
        //  d[s] := 0
        //  S := empty set
        //  Q := set of all vertices
        //  while Q is not empty
        //      u := extract_min(Q)
        //      S += u
        //      for each edge(u, v):
        //      if  d[v] > d[u] + w(u,v)
        //          d[v] := d[u] + w(u,v)
        //          pathTracer[v] := u;

        //function extract_min(Q)
        //  min = infinity;
        //  minIndex = null;
        //  for e in Q:
        //      if  e not in S  && min < d[e]:
        //      min = d[e];
        //      minIndex = e;
        //  Q := Q - next;
        //  return minIndex;

        double[] D = new double[vertexCount];
        LinkedList<Integer> Q = new LinkedList<>();
        for (int i = 0; i < vertexCount; i++) {
            D[i] = Integer.MAX_VALUE;
            Q.addLast(i);
        }
        int[] pathTracer = new int[vertexCount];
        D[startVertex] = 0;
        LinkedList<Integer> S = new LinkedList<>();

        while (!Q.isEmpty()) {
            int u = extract_min(Q, S, D);
            S.addLast(u);
            for (int v = 0; v < vertexCount; v++) {
                if (D[v] > D[u] + W[u][v] && W[u][v] != 0 && D[u] != Integer.MAX_VALUE) {
                    D[v] = D[u] + W[u][v];
                    pathTracer[v] = u;
                }
            }
        }
        printSolution(D, vertexCount, pathTracer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        double[][] adjacencyMatrix = new double[vertexCount][vertexCount];


        for (int i = 0; i < edgeCount; i++) {
            System.out.println("간선을 입력해주세요");
            int edgeStart = scanner.nextInt();
            int edgeEnd = scanner.nextInt();
            double weight = scanner.nextDouble();
            adjacencyMatrix[edgeStart][edgeEnd] = weight;
        }

        for (int j = 0; j < vertexCount; j++) {
            for (int k = 0; k < vertexCount; k++) {
                System.out.print(adjacencyMatrix[j][k] + " ");
            }
            System.out.println();
        }

        int startVertex = scanner.nextInt();

        applyDijkstra(adjacencyMatrix, startVertex, vertexCount);
    }
}
