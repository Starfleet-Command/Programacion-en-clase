import java.util.ArrayList;
public class QuickSort {
protected static ArrayList<String> QuickInt(ArrayList<String> lista, int min, int max)
{
    if (min < max)
    {
        int pivote = ParticionInt(lista, min, max);
        QuickInt(lista, min, pivote - 1);
        QuickInt(lista, pivote + 1, max);
    }
    return lista;
}

protected static int ParticionInt(ArrayList<String> lista, int low, int high)
{
    String pivot = lista.get(high);

    int    i = (low - 1);

    for (int j = low; j < high; j++)
    {
        if (lista.get(j).compareTo(pivot) < 0)
        {
            i++;
            String temp  = lista.get(i);
            String temp2 = lista.get(j);
            lista.set(j, temp);
            lista.set(i, temp2);
        }
    }
    String temp  = lista.get(i + 1);
    String temp2 = lista.get(high);
    lista.set(i + 1, temp2);
    lista.set(high, temp);
    return(i + 1);
}

public static void main(String[] args)
{
    ArrayList<String> nombres = new ArrayList<>();
    nombres.add("Miguel");
    nombres.add("Samuel");
    nombres.add("Jose");
    nombres.add("Juan");
    nombres.add("Andrea");
    nombres.add("Simon");
    nombres.add("Daniel");
    nombres.add("Samantha");
    nombres.add("Lia");
    nombres = QuickInt(nombres, 0, nombres.size() - 1);
    for (int u = 0; u < nombres.size(); u++)
    {
        System.out.println("" + nombres.get(u));
    }
}
}
