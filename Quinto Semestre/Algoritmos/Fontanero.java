import java.util.ArrayList;
import java.util.Collections;
class Trabajo implements Comparable<Trabajo>
{
String nombre;
int duracion;

Trabajo(String nombre, int duracion)
{
    this.nombre   = nombre;
    this.duracion = duracion;
}

@Override
public int compareTo(Trabajo s)
{
    return this.duracion - s.duracion;
}

@Override
public String toString()
{
    return " " + this.nombre;
}
}

class Fontanero
{
public void ordenaTrabajos(ArrayList<Trabajo> trabajos)
{
    Collections.sort(trabajos); //Funcion objetivo: minimizar el tiempo de espera de cada cliente. Esto se logra ordenando de menor a mayor.
    System.out.println("El orden en el que se deben de realizar los trabajos es: ");
    for (int r = 0; r < trabajos.size(); r++)
    {
        System.out.println(" " + trabajos.get(r));
    }
}
public static void main(String[] args)
{
    ArrayList<Trabajo> trabajos = new ArrayList<>();
    Fontanero          fuentes  = new Fontanero();
    Trabajo            t1       = new Trabajo("Plomeria", 20);
    Trabajo            t2       = new Trabajo("Jardin", 120);
    Trabajo            t3       = new Trabajo("Aluminio", 75);
    Trabajo            t4       = new Trabajo("Instalacion", 380);
    Trabajo            t5       = new Trabajo("Lunch Break", 30);

    trabajos.add(t1);
    trabajos.add(t2);
    trabajos.add(t3);
    trabajos.add(t4);
    trabajos.add(t5);

    fuentes.ordenaTrabajos(trabajos);
}
}
