import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class ExamenPrim
{
static class node1 {
int dest;
int weight;

node1(int a, int b)
{
    dest   = a;
    weight = b;
}
}


static class Graph {
int V;
LinkedList<node1>[] adj;
Graph(int e)
{
    V   = e;
    adj = new LinkedList[V];
    for (int o = 0; o < V; o++)
        adj[o] = new LinkedList<>();
}
}

static class node {
int vertex;
int key;
}

class comparator implements Comparator<node> {
@Override
public int compare(node node0, node node1)
{
    if (node0.key < node1.key)
    {
        return -1;
    }
    else if (node0.key > node1.key)
    {
        return 1;
    }
    else
        return 0;
}
}

// method to add an edge
// between two vertices
void addEdge(Graph graph, int src, int dest, int weight)
{
    node1 node0 = new node1(dest, weight);
    node1 node  = new node1(src, weight);
    graph.adj[src].addLast(node0);
    graph.adj[dest].addLast(node);
}

// method used to find the mst
void prims_mst(Graph graph)
{
    Boolean[] mstset = new Boolean[graph.V];
    node[]    e      = new node[graph.V];

    // Stores the parents of a vertex
    int[] parent = new int[graph.V];

    for (int o = 0; o < graph.V; o++)
        e[o] = new node();

    for (int o = 0; o < graph.V; o++)
    {
        mstset[o] = false;

        e[o].key    = Integer.MAX_VALUE;
        e[o].vertex = o;
        parent[o]   = -1;
    }

    mstset[0] = true;

    e[0].key = 0;


    PriorityQueue<node> queue = new PriorityQueue<>(graph.V, new comparator());

    for (int o = 0; o < graph.V; o++)
        queue.add(e[o]);


    while (!queue.isEmpty())
    {
        // Extracts a node with min key value
        node node0 = queue.poll();

        // Include that node into mstset
        mstset[node0.vertex] = true;

        // For all adjacent vertex of the extracted vertex V
        for (node1 iterator : graph.adj[node0.vertex])
        {
            // If V is in PriorityQueue
            if (mstset[iterator.dest] == false)
            {
                // If the key value of the adjacent vertex is
                // more than the extracted key
                // update the key value of adjacent vertex
                // to update first remove and add the updated vertex
                if (e[iterator.dest].key > iterator.weight)
                {
                    queue.remove(e[iterator.dest]);
                    e[iterator.dest].key = iterator.weight;
                    queue.add(e[iterator.dest]);
                    parent[iterator.dest] = node0.vertex;
                }
            }
        }
    }

    // Prints the vertex pair of mst
    for (int o = 1; o < graph.V; o++)
        System.out.println(parent[o] + " "
                           + "-"
                           + " " + o);
}

public static void main(String[] args)
{
    int        V     = 20; //TAMAÑO DE LA GRAFICA
    ExamenPrim ep    = new ExamenPrim();
    Graph      graph = new Graph(V);

    ep.addEdge(graph, 1, 2, 14); //SINTAXIS: Graph, FUENTE, DESTINO, PESO
    ep.addEdge(graph, 1, 8, 12);
    ep.addEdge(graph, 2, 3, 23);
    ep.addEdge(graph, 2, 7, 17);
    ep.addEdge(graph, 3, 4, 5);
    ep.addEdge(graph, 3, 6, 18);
    ep.addEdge(graph, 4, 5, 12);
    ep.addEdge(graph, 5, 6, 6);
    ep.addEdge(graph, 6, 11, 7);
    ep.addEdge(graph, 6, 12, 11);
    ep.addEdge(graph, 6, 13, 2);
    ep.addEdge(graph, 7, 9, 12);
    ep.addEdge(graph, 8, 17, 28);
    ep.addEdge(graph, 9, 16, 10);
    ep.addEdge(graph, 9, 6, 6);
    ep.addEdge(graph, 9, 15, 7);
    ep.addEdge(graph, 10, 15, 6);
    ep.addEdge(graph, 13, 14, 44);
    ep.addEdge(graph, 14, 17, 3);
    ep.addEdge(graph, 16, 17, 33);
    ep.addEdge(graph, 17, 8, 28);
    ep.addEdge(graph, 17, 14, 33);


    ep.prims_mst(graph);
}
}
