//POLIMORFISMO

/* Cuando un método se sobreescribe een una subclase, el método puede tener comportamientos diferentes al cotidiano: por ejemplo, en lugar de hacer
Cat obj1 = new Cat(); puedes usar una referencia de una clase padre, como Fish v1 = new Salmon();


*/
import java.util.*;
public class Polymorph
{
  public static void main(String[] args)
  {
  /* Object[] arr = new Object[2];
  arr[0]= new Object[2];
  arr[1]= new Integer(1);

  System.out.println(arr[0].getClass()==Integer.class?"Integer":"Array");
  System.out.println(arr[1].getClass()==Integer.class?"Integer":"Array");

  */

  ArrayList<Object> arrays = new ArrayList<Object>();
  ArrayList<Object> minis = new ArrayList<Object>();
  Random aleatorio = new Random();
  Integer elMayor = new Integer(0);
//FILL
  for(int k=0;k<15;k++)
  {
    int define = aleatorio.nextInt(2);
    int aniade = aleatorio.nextInt(20);
    if(define==0)
    {
      arrays.add(aniade);
    }
    else
    {
      Integer ser = new Integer(aniade);
      Integer ser2 = new Integer(aniade-5);

      minis.add(ser);
      minis.add(ser2);

    }
  }

//READ
ArrayList<Integer> combinacion= new ArrayList<Integer>();
for(int u=0;u<arrays.size();u++)
{
  combinacion.add((int)arrays.get(u));
}

for(int k=0;k<minis.size();k++)
{
  combinacion.add((int)minis.get(k));
}
printArrayList(combinacion);
for(int u=0;u<combinacion.size();u++)
{
  if(combinacion.get(u).getClass()==Integer.class)
  {

      if(combinacion.get(u)>elMayor)
        elMayor= combinacion.get(u);

  }
}
System.out.println("El número más alto es: "+elMayor);
}


public static void printArrayList(ArrayList<Integer> lul)
{
  for(int r=0;r<lul.size();r++)
  {
    System.out.printf(" \t"+lul.get(r));
  }
}

}
