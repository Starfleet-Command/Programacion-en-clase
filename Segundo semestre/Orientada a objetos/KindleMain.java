import java.util.*;
public class KindleMain
{
  public static void main(String[] args)
  {
  Scanner lector = new Scanner(System.in);
  char confirm = 'y';
   String resp1,resp2,resp3,nombre,autor,nomleer,eliminar;
   String reciente ="";
   int numero;
   Kindle kindle = new Kindle();


  System.out.println("Desea añadir un nuevo libro a su biblioteca?[Y/N]" );
  resp1 = lector.next();
  lector.nextLine();
  if(confirm== resp1.charAt(0))
  {
    kindle.crear();
    reciente = kindle.retLibro();
  }

  kindle.printLibros();

  System.out.println("Desea leer un libro?");
  resp2 = lector.next();
  lector.nextLine();
if(confirm== resp2.charAt(0))
  {
    System.out.println("Cual libro desea leer?");
    nomleer = lector.nextLine();
    reciente = nomleer;

kindle.leyendo(nomleer);
  }
kindle.reciente(reciente);

System.out.println("Desea eliminar un libro de su biblioteca?");
resp3 = lector.next();
lector.nextLine();
if(confirm== resp3.charAt(0))
  {
    System.out.println("Cual libro desea eliminar?");
    eliminar = lector.nextLine();
    kindle.elimLibros(eliminar);
  }


  }
}
