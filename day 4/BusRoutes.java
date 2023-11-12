import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        
        queue.offer(source);
        visitedStops.add(source);

        int buses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                List<Integer> currentRoutes = stopToRoutes.getOrDefault(currentStop, new ArrayList<>());
                for (int route : currentRoutes) {
                    if (visitedRoutes.contains(route)) {
                        continue;
                    }

                    visitedRoutes.add(route);

                    for (int nextStop : routes[route]) {
                        if (visitedStops.contains(nextStop)) {
                            continue;
                        }

                        if (nextStop == target) {
                            return buses + 1;
                        }

                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }
            buses++;
        }

        return -1;
    }
}
