import java.util.ArrayList;
import java.util.ArrayDeque;
public class Prim
{
public static void Prim(int[][] costos)
{
    ArrayList<Vertice>  visitados  = new ArrayList<>();
    ArrayDeque<Vertice> sinVisitar = new ArrayDeque<>();
    Vertice             inicio     = new Vertice(0, 0);
    Vertice             minver     = new Vertice(0, 0);

    int                 minkey = 0;

    visitados.add(inicio);

    for (int r = 0; r < costos.length; r++)
    {
        if (costos[r][inicio.getY()] != Integer.MAX_VALUE)
        {
            Vertice vecinos1 = new Vertice(r, inicio.getY());
            sinVisitar.add(vecinos1);
        }
    }



    while (sinVisitar.isEmpty() != true)
    {
        for (int u = 0; u < costos.length; u++)
        {
            if (costos[sinVisitar.getFirst().getX()][u] < minkey)
            {
                minkey = costos[sinVisitar.getFirst().getX()][u];
                minver.setX(sinVisitar.getFirst().getX());
                minver.setY(u);
            }
        }

        visitados.add(minver);

        for (int e = 0; e < costos.length; e++)
        {
            if (costos[e][minver.getY()] != Integer.MAX_VALUE)
            {
                Vertice vecino = new Vertice(e, minver.getY());
                sinVisitar.add(vecino);
            }
        }
    }
}

static class Vertice
{
private int x;
private int y;
public Vertice(int x, int y)
{
    this.x = x;
    this.y = y;
}

public int getX()
{
    return x;
}

public void setX(int x)
{
    this.x = x;
}

public int getY()
{
    return y;
}

public void setY(int y)
{
    this.y = y;
}
}
}
