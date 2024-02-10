import java.util.*;

public class GraphSearch {

    private Map<String, List<String>> graph = new HashMap<>();

    public GraphSearch(List<String> edges) {
        for (String edge : edges) {
            String[] vertices = edge.split(", ");
            // If vertex doesn't exist in graph, initialize and add the adjacent vertex
            graph.computeIfAbsent(vertices[0], k -> new ArrayList<>()).add(vertices[1]);
            // Since the graph is undirected, add the connection in the other direction as well
            graph.computeIfAbsent(vertices[1], k -> new ArrayList<>()).add(vertices[0]);
        }
    }

    // bfs algorithm implementation
    public Result bfs(String start, String goal) {
        long startTime = System.nanoTime(); // Record the start time

        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0)); // Add starting node to queue

        while (!queue.isEmpty()) {
            Node node = queue.poll(); // Get and remove the head of the queue
            if (node.vertex.equals(goal)) {
                long endTime = System.nanoTime(); // Record the end time
                return new Result(node.distance, endTime - startTime); // Return result if goal is found
            }
            if (!visited.contains(node.vertex)) {
                visited.add(node.vertex); // Mark as visited
                // Add all unvisited neighbors to the queue
                for (String neighbour : graph.getOrDefault(node.vertex, new ArrayList<>())) {
                    queue.add(new Node(neighbour, node.distance + 1));
                }
            }
        }

        long endTime = System.nanoTime(); // Record the end time if goal is not found
        return new Result(-1, endTime - startTime); // Return result indicating path not found
    }

    // dfs algorithm implementation
    public Result dfs(String start, String goal) {
        long startTime = System.nanoTime(); // Record the start time
        Set<String> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        stack.push(new Node(start, 0)); // Add starting node to stack

        while (!stack.isEmpty()) {
            Node node = stack.pop(); // Get and remove the top element of the stack
            if (node.vertex.equals(goal)) {
                long endTime = System.nanoTime(); // Record the end time
                return new Result(node.distance, endTime - startTime); // Return result if goal is found
            }
            if (!visited.contains(node.vertex)) {
                visited.add(node.vertex); // Mark as visited
                // Add all unvisited neighbors to the stack
                for (String neighbour : graph.getOrDefault(node.vertex, new ArrayList<>())) {
                    stack.push(new Node(neighbour, node.distance + 1));
                }
            }
        }

        long endTime = System.nanoTime(); // Record the end time if goal is not found
        return new Result(-1, endTime - startTime); // Return result indicating path not found
    }

    // Helper class to store nodes and their distance from the start node
    private class Node {
        String vertex;
        int distance;

        public Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // Helper class to store the results of the search
    public class Result {
        int distance;
        long time; // Time is in nanoseconds

        public Result(int distance, long time) {
            this.distance = distance;
            this.time = time;
        }
    }
}

