import java.util.*;

class Graph {

    private Map<Integer, List<int[]>> graph;

    public Graph(int n, int[][] edges) {
        graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{node1, 0});

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distance = new HashMap<>();

        distance.put(node1, 0);

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (visited.contains(currentNode)) {
                continue;
            }

            if (currentNode == node2) {
                return currentDistance;  // Stop when the target node is reached
            }

            visited.add(currentNode);

            for (int[] neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = neighbor[0];
                int edgeCost = neighbor[1];

                int newDistance = currentDistance + edgeCost;

                if (!distance.containsKey(nextNode) || newDistance < distance.get(nextNode)) {
                    distance.put(nextNode, newDistance);
                    minHeap.offer(new int[]{nextNode, newDistance});
                }
            }
        }

        return -1;  // If the target node is not reached
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        System.out.println(g.shortestPath(3, 2)); // Output: 6
        System.out.println(g.shortestPath(0, 3)); // Output: -1
        g.addEdge(new int[]{1, 3, 4});
        System.out.println(g.shortestPath(0, 3)); // Output: 6
    }
}
