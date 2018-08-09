public class Sorter implements Comparator<Equipo>
{
  public int compare(Equipo a, Equipo b)

    {
        return a.puntos - b.puntos;
    }


}
