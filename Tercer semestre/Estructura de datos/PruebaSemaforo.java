public class PruebaSemaforo
{
  public static void main(String[] args)
  {
  Semaforo sem = new Semaforo(0,false,false);
  sem.PrintEstado();
  sem.Prender();
  sem.Cambia();
  sem.PrintEstado();
  sem.Apagar();
  sem.Apagar();
  }
}
