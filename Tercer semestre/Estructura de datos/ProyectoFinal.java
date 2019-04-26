/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Fco
 */

import java.io.*;
import java.util.*;

public class ProyectoFinal
{
public static void main(String[] args)
{
    Puntos                      punto     = new Puntos("3x15", 27.523303, -99.5645);
    Puntos                      punto2    = new Puntos("3x12", 27.495568, -99.540115);
    double                      distancia = distancia(punto, punto2);

    ArrayList<Vertice>          totpunt = new ArrayList<>();
    totpunt = readFile("proyFin.csv");
    int[][]                     adyace = agrupa(totpunt); //MATRIZ DE ADYACENCIA
    double[][]                  costos = costos(totpunt);

    Hashtable<Integer, Integer> hashes = new Hashtable<>();
    for (int s = 0; s < totpunt.size(); s++)
    {
        hashes.put(totpunt.get(s).getSrc(), totpunt.get(s).hashCode());
    }

    /*
       ArrayDeque<Integer> cola = new ArrayDeque();
       ArrayDeque visitados = new ArrayDeque();
       for(int z=0;z<adyace.length;z++)
       {
        visitados.add(z);
        for(int q=0;q<adyace.length;q++)
        {
            if(adyace[z][q]==1)
            {
                cola.addFirst(q);
                visitados.add(q);

            }
            while(!cola.isEmpty())
            {
                if(adyace[cola.getLast()][q]==1 && !visitados.contains(q) && !visitados.contains(cola.getLast()))
                {
                    cola.addFirst(q);
                    visitados.add(q);
                }
                cola.pollLast();

            }
        }
       }

       System.out.println(""+visitados.toString());
     */

    ProyectoFinal pf = new ProyectoFinal();


    Graph  graph2   = new Graph(totpunt.size());
    Edge[] esquinas = new Edge[totpunt.size()];
    for (int s = 0; s < totpunt.size(); s++)
    {
        if (totpunt.get(s).getPeso() < 10)
        {
            pf.addEdge(graph2, totpunt.get(s).getSrc(), totpunt.get(s).getDest(), totpunt.get(s).getPeso());
            Edge eje = new Edge(totpunt.get(s).getSrc(), totpunt.get(s).getDest(), totpunt.get(s).getPeso());
            esquinas[s] = eje;
        }
    }

    pf.prims_mst(graph2);

    Graphs dijkstra = pf.new Graphs(esquinas);
    dijkstra.calculateShortestDistances();
    dijkstra.printResult();

    for (int x = 0; x < adyace.length; x++)
    {
        for (int j = 0; j < adyace[x].length; j++)
        {
            System.out.print("" + adyace[x][j]);
        }
        System.out.println("");
    }
}

protected static double distancia(Puntos punt1, Puntos punt2)
{
    double lat1   = Math.toRadians(punt1.getLat());
    double lat2   = Math.toRadians(punt2.getLat());
    double delta1 = Math.toRadians(punt2.getLat() - punt1.getLat());
    double delta2 = Math.toRadians(punt2.getLon() - punt1.getLon());
    double r      = 6371;

    double formp1 = haversin(delta1) + Math.cos(lat1) * Math.cos(lat2) * haversin(delta2);

    double form2 = 2 * Math.atan2(Math.sqrt(formp1), Math.sqrt(1 - formp1));
    double form3 = r * form2;
    return form3;
}

public static double haversin(double value)
{
    double haver = Math.pow(Math.sin(value / 2), 2);
    return haver;
}

public static int[][] agrupa(ArrayList<Vertice> arreglo)
{
    int[][] adyace    = new int[arreglo.size()][arreglo.size()]; //SI USAMOS ARREGLO SIZE SE HACE UNO DE 16000. QUEREMOS SOLO LOS 1000
    int[][] adyaceret = new int[1000][1000];
    for (int a = 0; a < adyace.length; a++)
    {
        for (int r = 0; r < adyace[a].length; r++)
        {
            if (arreglo.get(r).getPeso() < 10 && a != r)
            {
                adyace[arreglo.get(r).getSrc()][arreglo.get(r).getDest()] = 1;
            }
            else
                adyace[arreglo.get(r).getSrc()][arreglo.get(r).getDest()] = 0;
        }
    }
    for (int f = 0; f < 1000; f++)
    {
        for (int s = 0; s < 1000; s++)
        {
            adyaceret[f][s] = adyace[f][s];
        }
    }
    return adyaceret;
}

public static double[][] costos(ArrayList<Vertice> arreglo)
{
    double[][] costo    = new double[arreglo.size()][arreglo.size()];
    double[][] costoret = new double[1000][1000];

    for (int a = 0; a < arreglo.size(); a++)
    {
        for (int r = 0; r < arreglo.size(); r++)
        {
            if (arreglo.get(a).getPeso() < 10)
            {
                costo[a][r] = arreglo.get(a).getPeso();
            }
            else
                costo[a][r] = Double.POSITIVE_INFINITY;
        }
    }
    for (int f = 0; f < 1000; f++)
    {
        for (int s = 0; s < 1000; s++)
        {
            costoret[f][s] = costo[f][s];
        }
    }

    return costoret;
}


private static ArrayList<Vertice> readFile(String filename)
{
    ArrayList<Vertice> data = new ArrayList<Vertice>();
    try{
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String         line;
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split(",");

            String   part1    = parts[0]; // 004
            String   part2    = parts[1];
            String   part3    = parts[2];
            Vertice  addition = new Vertice(Integer.parseInt(part1), Integer.parseInt(part2), Double.parseDouble(part3));
            data.add(addition);
        }
        reader.close();
        return data;
    }
    catch (Exception e) {
        System.err.format("Exception occured tying to read '%s'.", filename);
        e.printStackTrace();
        return null;
    }
}


static class Vertice
{
private int src;
private int dest;
private double peso;
public Vertice(int src, int dest, double peso)
{
    this.src  = src;
    this.dest = dest;
    this.peso = peso;
}

public int getSrc()
{
    return src;
}

public void setFin(int src)
{
    this.src = src;
}

public int getDest()
{
    return dest;
}

public void setDest(int dest)
{
    this.dest = dest;
}
public double getPeso()
{
    return peso;
}
public void setPeso(double peso)
{
    this.peso = peso;
}
}

static class Puntos
{
private double lat;
private double lon;
private String id;

public Puntos(String id, double lat, double lon)
{
    this.lat = lat;
    this.lon = lon;
    this.id  = id;
}



public double getLat()
{
    return lat;
}

public void setLat(double lat)
{
    this.lat = lat;
}

public double getLon()
{
    return lon;
}

public void setLon(double lon)
{
    this.lon = lon;
}

public String getId()
{
    return id;
}

public void setId(String id)
{
    this.id = id;
}
}

static class node1 {
int dest;
double weight;

node1(int a, double b)
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

static class nodes {
int vertex;
double key;
}

class comparator implements Comparator<nodes> {
@Override
public int compare(nodes node0, nodes node1)
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
void addEdge(Graph graph, int src, int dest, double weight)
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
    nodes[]   e      = new nodes[graph.V];

    // Stores the parents of a vertex
    int[] parent = new int[graph.V];

    for (int o = 0; o < graph.V; o++)
        e[o] = new nodes();

    for (int o = 0; o < graph.V; o++)
    {
        mstset[o] = false;

        e[o].key    = Double.POSITIVE_INFINITY;
        e[o].vertex = o;
        parent[o]   = -1;
    }

    mstset[0] = true;

    e[0].key = 0;


    PriorityQueue<nodes> queue = new PriorityQueue<>(graph.V, new comparator());

    for (int o = 0; o < graph.V; o++)
        queue.add(e[o]);


    while (!queue.isEmpty())
    {
        // Extracts a node with min key value
        nodes node0 = queue.poll();

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
    for (int o = 1; o < 1000; o++)
        System.out.println(parent[o] + " "
                           + "-"
                           + " " + o);
}

static class Edge {
private int fromNodeIndex;
private int toNodeIndex;
private double length;

public Edge(int fromNodeIndex, int toNodeIndex, double length)
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

public double getLength()
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
private double distanceFromSource = Double.POSITIVE_INFINITY;
private boolean visited;
private ArrayList<Edge> edges = new ArrayList<Edge>();   // now we must create edges

public double getDistanceFromSource()
{
    return distanceFromSource;
}

public void setDistanceFromSource(double distanceFromSource)
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
public class Graphs {
private Node[] nodes;
private int noOfNodes;
private Edge[] edges;
private int noOfEdges;

public Graphs(Edge[] edges)
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
                double tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();

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
    int    storedNodeIndex = 0;
    double storedDist      = Double.POSITIVE_INFINITY;

    for (int i = 0; i < this.nodes.length; i++)
    {
        double currentDist = this.nodes[i].getDistanceFromSource();

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
