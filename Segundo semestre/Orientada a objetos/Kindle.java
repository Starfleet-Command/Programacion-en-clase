import java.util.InputMismatchException;
import java.util.*;
public class Kindle
{
 public static ArrayList<Libro> libros = new ArrayList<Libro>();
  String nombre,autor,resp3,reciente;
  int numero;
  char confirm = 'y';
  Scanner lector = new Scanner(System.in);


public Kindle()
{

}


public void printLibros()
{

System.out.println("Su lista de libros es:");

for(int k=0; k<libros.size(); k++)
{
  System.out.printf("%s - %s  -  %d páginas",libros.get(k).returnLibro(),libros.get(k).returnAutor(),libros.get(k).returnPage() );
  System.out.println("");
}
}

public void crear()

{
  try
  {
  System.out.println("Cual es el nombre del libro");
  nombre = lector.nextLine();

  System.out.println("Cual es el nombre del autor?");
  autor = lector.next();

  System.out.println("Cual es el numero de paginas?");
  numero= lector.nextInt();

  Libro libro = new Libro(nombre,autor,numero);
  libros.add(0,libro);

  System.out.println("Desea añadir otro libro?[Y/N]");
  resp3 = lector.next();
  lector.nextLine();
  if(confirm==resp3.charAt(0))
    {
      crear();
    }
  }
  catch(Exception e)
  {
    System.out.println("Los campos que usted mando son invalidos");
  }
}

public String retLibro()
{
  return nombre;
}

public void elimLibros(String nombre)
{

  System.out.println(""+nombre);
for(int e=0; e<libros.size();e++)
{
  if(nombre.equalsIgnoreCase(libros.get(e).returnLibro()))
  {
    libros.remove(e);
    printLibros();
    System.out.println("Elemento eliminado");
  }

  else System.out.println("El elemento que usted quiere eliminar no existe");
}

}

public void leyendo(String nomleer)
{
  for(int e=0; e<libros.size();e++)
  {
    if(nomleer.equalsIgnoreCase(libros.get(e).returnLibro()))
    {
  System.out.println("Usted esta leyendo: "+nomleer);
  System.out.println("");

  }

  else System.out.println("El libro que usted pidió no existe");
}
}

public void reciente(String recent)
{
  System.out.println("El libro más reciente que usted leyo es:"+recent);
  System.out.println("");


}
}
