import java.util.ArrayList;
public class Dijkstra
{
public static void main(String[] args)
{
}
public ArrayList<Integer> dijkstras(int origen, int destino, int[][] costos)
{
    ArrayList<Integer> camino    = new ArrayList<>();
    ArrayList<Integer> costo     = new ArrayList<>();
    ArrayList<Integer> vecinos   = new ArrayList<>();
    int                distancia = Integer.MAX_VALUE;
    int                nodo      = origen;
    boolean            fin       = false;
    camino.add(nodo);

    while (fin == false)
    {
        nodo = siguiente(nodo, destino);
        camino.add(nodo);

        if (nodo == destino)
        {
            fin = true;
        }
    }
    return camino;
}
public int siguiente(int nodo, int destino)
{
    int siguiente = 2; //Este valor es reemplazado por el método que escoges para obtener el siguiente unitario (iterando sobre matriz de adjacencia o usando alguna otra estructura de datos con más de 1 siguiente). Regresa el nodo.
    return siguiente;
}
}
