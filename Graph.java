import java.util.*;

// Adjacency matrix
public class Graph {
    private int[][] adjacencyMatrix;
    private int vertices;

    public Graph(int v) {
        this.vertices = v;
        this.adjacencyMatrix = new int[v][v];
    }

    public void addEdge(int i, int j) {
        if (i < vertices && j < vertices) {
            adjacencyMatrix[i][j] = 1;
            // adjacencyMatrix[j][i] = 1; // Uncomment for undirected graph
        }
    }

    public void printGraph() {
        System.out.println("Graph represented as an adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// adjacency list
class Graph2 {
    private int V;
    private List<List<Integer>> adj;
    
    public Graph2(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
           adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    //  adj.get(v).add(u);
    }

    public void printGraph() {
        for(int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsUtil(start, visited);
    }

    public void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph2 graph = new Graph2(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.printGraph();
        System.out.println("BFS starting from node 0:");
        graph.bfs(0);
        System.out.println("\nDFS starting from node 0:");
        graph.dfs(0);
    }
}

class AdjacencyListGraph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjList;

    // Constructor
    public AdjacencyListGraph(int vertices) {
        this.V = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // For undirected graph
    }

    // Print graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ":");
            for (int neighbor : adjList[i]) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}

