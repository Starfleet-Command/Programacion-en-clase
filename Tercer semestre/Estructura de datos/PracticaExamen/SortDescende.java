import java.util.ArrayDeque;
import java.util.ArrayList;
public class SortDescende
{
public static void main(String[] args)
{
    int[]              elementos = { 1, 4, 5, 7, 8, 11, 14 };

    int[]              elementos2    = { 5, 11, 3, 6, 8, 11, 1 };
    int[]              resultDescend = new int[elementos.length];
    ArrayList<Integer> resultAsc     = new ArrayList<>();
    resultDescend = SortDesciende(elementos);

    for (int e:resultDescend)
    {
        System.out.print(" " + e);
    }
    System.out.println(" ");
    resultAsc = sortAsciende(elementos2);
    for (int e:resultAsc)
    {
        System.out.print(" " + e);
    }
}
public static int[] SortDesciende(int[] numeros)
{
    int[]               invert = new int[numeros.length];
    ArrayDeque<Integer> estak  = new ArrayDeque<>();

    for (int r = 0; r < numeros.length; r++)
    {
        estak.addFirst((numeros[r]));
    }


    for (int u = 0; u < numeros.length; u++)
    {
        invert[u] = estak.pollFirst();
    }
    return invert;
}

public static ArrayList<Integer> sortAsciende(int[] numeros)
{
    int                temp1, temp2;
    ArrayList<Integer> asciende = new ArrayList<>();

    for (int e = 0; e < numeros.length; e++)
    {
        asciende.add(e, numeros[e]);
    }

    for (int r = 0; r < numeros.length; r++)
    {
        for (int p = 0; p < asciende.size() - 1; p++)
        {
            if (asciende.get(p + 1) < asciende.get(p))
            {
                temp1 = asciende.get(p + 1);
                temp2 = asciende.get(p);
                asciende.remove(p + 1);
                asciende.remove(p);
                asciende.add(p, temp1);
                asciende.add(p + 1, temp2);
            }
        }
    }

    return asciende;
}
}
