import java.util.*;
public class ExamenDijkstra
{
public static void main(String[] args)
{
    //SINTAXIS: NODO SALIDA __ NODO LLEGADA __ LONGITUD
    Edge[]         edges = {
        new Edge(1,  8, 0), new Edge(1,  2, 0), new Edge(2,  3, 8),
        new Edge(2,  7, 8), new Edge(3, 10, 6), new Edge(3,  4, 0),
        new Edge(3,  6, 6), new Edge(4,  5, 8), new Edge(5,  6, 6),
        new Edge(6, 11, 6), new Edge(6, 12, 6), new Edge(6, 13, 0),
        new Edge(6,  9, 6), new Edge(7,  9, 8), new Edge(8, 17, 8),new Edge(9,15, 6), new Edge(9, 16, 0), new Edge(10, 15, 6), new Edge(13, 14, 6), new Edge(14, 17, 6), new Edge(16, 17, 8)
    };
    ExamenDijkstra ed = new ExamenDijkstra();
    Graph          g  = ed.new Graph(edges);
    g.calculateShortestDistances();
    g.printResult();
}
static class Edge {
private int fromNodeIndex;
private int toNodeIndex;
private int length;

public Edge(int fromNodeIndex, int toNodeIndex, int length)
{
    this.fromNodeIndex = fromNodeIndex;
    this.toNodeIndex   = toNodeIndex;
    this.length        = length;
}

public int getFromNodeIndex()
{
    return fromNodeIndex;
}

public int getToNodeIndex()
{
    return toNodeIndex;
}

public int getLength()
{
    return length;
}

// determines the neighbouring node of a supplied node, based on the two nodes connected by this edge
public int getNeighbourIndex(int nodeIndex)
{
    if (this.fromNodeIndex == nodeIndex)
    {
        return this.toNodeIndex;
    }
    else
    {
        return this.fromNodeIndex;
    }
}
}
static class Node {
private int distanceFromSource = Integer.MAX_VALUE;
private boolean visited;
private ArrayList<Edge> edges = new ArrayList<Edge>();   // now we must create edges

public int getDistanceFromSource()
{
    return distanceFromSource;
}

public void setDistanceFromSource(int distanceFromSource)
{
    this.distanceFromSource = distanceFromSource;
}

public boolean isVisited()
{
    return visited;
}

public void setVisited(boolean visited)
{
    this.visited = visited;
}

public ArrayList<Edge> getEdges()
{
    return edges;
}

public void setEdges(ArrayList<Edge> edges)
{
    this.edges = edges;
}
}
public class Graph {
private Node[] nodes;
private int noOfNodes;
private Edge[] edges;
private int noOfEdges;

public Graph(Edge[] edges)
{
    this.edges = edges;

    // create all nodes ready to be updated with the edges
    this.noOfNodes = calculateNoOfNodes(edges);
    this.nodes     = new Node[this.noOfNodes];

    for (int n = 0; n < this.noOfNodes; n++)
    {
        this.nodes[n] = new Node();
    }

    // add all the edges to the nodes, each edge added to two nodes (to and from)
    this.noOfEdges = edges.length;

    for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++)
    {
        this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
        this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
    }
}

private int calculateNoOfNodes(Edge[] edges)
{
    int noOfNodes = 0;

    for (Edge e : edges)
    {
        if (e.getToNodeIndex() > noOfNodes)
            noOfNodes = e.getToNodeIndex();
        if (e.getFromNodeIndex() > noOfNodes)
            noOfNodes = e.getFromNodeIndex();
    }

    noOfNodes++;

    return noOfNodes;
}


public void calculateShortestDistances()
{
    // node 0 as source
    this.nodes[1].setDistanceFromSource(0);
    int nextNode = 0;

    // visit every node
    for (int i = 0; i < this.nodes.length; i++)
    {
        // loop around the edges of current node
        ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

        for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++)
        {
            int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);

            // only if not visited
            if (!this.nodes[neighbourIndex].isVisited())
            {
                int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();

                if (tentative < nodes[neighbourIndex].getDistanceFromSource())
                {
                    nodes[neighbourIndex].setDistanceFromSource(tentative);
                }
            }
        }

        // all neighbours checked so node visited
        nodes[nextNode].setVisited(true);

        // next node must be with shortest distance
        nextNode = getNodeShortestDistanced();
    }
}

private int getNodeShortestDistanced()
{
    int storedNodeIndex = 0;
    int storedDist      = Integer.MAX_VALUE;

    for (int i = 0; i < this.nodes.length; i++)
    {
        int currentDist = this.nodes[i].getDistanceFromSource();

        if (!this.nodes[i].isVisited() && currentDist < storedDist)
        {
            storedDist      = currentDist;
            storedNodeIndex = i;
        }
    }

    return storedNodeIndex;
}

// display result
public void printResult()
{
    String output = "Numero de nodos = " + this.noOfNodes;
    output += "\n Numero de 'esquinas' = " + this.noOfEdges;

    for (int i = 0; i < this.nodes.length; i++)
    {
        output += ("\n La distancia mas corta del nodo 0 al nodo " + i + " es " + nodes[i].getDistanceFromSource());
    }

    System.out.println(output);
}

public Node[] getNodes()
{
    return nodes;
}

public int getNoOfNodes()
{
    return noOfNodes;
}

public Edge[] getEdges()
{
    return edges;
}

public int getNoOfEdges()
{
    return noOfEdges;
}
}
}
