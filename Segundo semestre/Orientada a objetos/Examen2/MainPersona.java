import java.util.ArrayList;
public class MainPersona
{
  public static void main(String[] args)
  {
    int numpers=0;
  ArrayList<Persona> people = new ArrayList<Persona>();
  Direccion dir1 = new Direccion("Luis Cabrera","516","10200","Ciudad de Mexico");

  Persona pers1 = new Persona("Jose Maria",dir1,19,12,2001);
  Persona pers2 = new Persona("Yann le Lorier",dir1,18,10,1997);
  Persona pers3 = new Persona("Octavio",dir1,15,5,1996);

people.add(pers1);
people.add(pers2);
people.add(pers3);

for(int k=0; k<people.size();k++)
{
  if(people.get(k).esMayordeEdad(people.get(k).getFecha()) ==true)
  {
    numpers++;
  }
}

for(int k=0; k<people.size();k++)
{
  System.out.println(" "+people.get(k).toString());
}

System.out.println("El numero de personas mayores de edad es: "+numpers);

  }
}
