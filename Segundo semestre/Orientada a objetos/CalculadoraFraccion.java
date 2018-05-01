
import java.util.*;
public class CalculadoraFraccion
{
  public static void main(String[] args)
  {
    Scanner lector = new Scanner(System.in);
    boolean continuar = true;
    boolean continuapon = false;
  ArrayList<Fraccion> fracciones = new ArrayList<Fraccion>();
  char confirma = 'y';
  String a0,a1,a,num,den,b,spec,f,g;
  int c,d,e;




do{

  System.out.println("Quiere crear una fraccion? Se puede crear con numerador y denominador,solo con numerador,o sola (default es 0/1) [y/n]");

  a= lector.nextLine();
  if(a.charAt(0)==confirma)
  {
do{
continuapon=false;
    System.out.println("Cual es el numerador?");
    num= lector.nextLine();


    System.out.println("Cual es el denominador?");
    den = lector.nextLine();
    lector.nextLine();

    if(den==null && num==null)
    {
      Fraccion fracc1 = new Fraccion();
      fracciones.add(fracc1);
    }

    else if(den==null)
    {
      Fraccion fracc1 = new Fraccion(Integer.parseInt(num));
      fracciones.add(fracc1);
    }

    else
    {
    Fraccion fracc1 = new Fraccion(Integer.parseInt(num),Integer.parseInt(den));
    fracciones.add(fracc1);
  }

    System.out.println("Quiere continuar añadiendo fracciones? [y/n]");
    b= lector.nextLine();
    if(b.charAt(0)==confirma)
    {
      continuapon=true;
    }
  }
while(continuapon);
}


  System.out.println("Quiere convertir la fraccion añadida mas recientemente a String?[y/n]");
  a0 = lector.nextLine();
  if(a0.charAt(0)==confirma)
  {
    fracciones.get(fracciones.size()-1).ToString();
  }
  System.out.println("Quiere convertir la fraccion añadida mas recientemente a Double? [y/n]");
  a1= lector.nextLine();
  if (a1.charAt(0)==confirma)
  {
    fracciones.get(fracciones.size()-1).toDouble();
  }

  System.out.println("Quiere realizar alguna operacion? [y/n]");
  spec = lector.nextLine();
  if(spec.charAt(0)==confirma)
  {

  System.out.println("Con cuales fracciones desea realizar las operaciones (la primer fraccion mostrada a continuación es no. 0)");
  for(int k=0;k<fracciones.size();k++)
  {
    System.out.printf("%s / %s",fracciones.get(k).GetNumerador(),fracciones.get(k).GetDenominador());
    System.out.println("");
  }
System.out.println("Escriba el numero de la primer fraccion a utilizar");
c = lector.nextInt();

System.out.println("Escriba el numero de la segunda fraccion a utilizar (esta fraccion resta y divide a la otra fraccion)");
d = lector.nextInt();

System.out.println("Escriba la operacion que va a realizar: 1=suma, 2=resta, 3=multiplicacion, 4= division 5=comprueba igualdad");
e= lector.nextInt();
lector.nextLine();

Fraccion[] fracci = new Fraccion[2];
fracci[0]= fracciones.get(c);
fracci[1]= fracciones.get(d);

switch(e)
{
  case 1:
  System.out.println("Su resultado es:");
  fracci[0].add(fracci[1]);
  break;
  case 2:
  System.out.println("Su resultado es:");
  fracci[0].substract(fracci[1]);
  break;
  case 3:
  System.out.println("Su resultado es:");
  fracci[0].multiply(fracci[1]);
  break;
  case 4:
  System.out.println("Su resultado es:");
  fracci[0].divide(fracci[1]);
  break;
  case 5:
  System.out.println("Su resultado es:");
  fracci[0].Equals(fracci[1]);

}
}

System.out.println("Desea reducir a los terminos mas bajos a la fraccion más recientemente añadida?[y/n]");
f = lector.nextLine();

if(f.charAt(0)==confirma)
{
  fracciones.get(fracciones.size()-1).toLowestTerms();
}




System.out.println("Desea continuar?[y/n]");
g = lector.nextLine();
if(g.charAt(0)==confirma)
{
  continuar = true;
}
else continuar = false;

}
while(continuar);

  }

  public int GCD(int a, int b)
  {
    if(b==0)
    return a;

    return GCD(b,a%b);
  }
}
