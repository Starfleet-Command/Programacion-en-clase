
import java.util.Scanner;


public class paresNones
{
    public static void main(String[] args)
{
    Scanner lector = new Scanner(System.in);
    Jugador jugador1 = new Jugador(0,"Samantha");
    Jugador jugador2 = new Jugador(0,"Ariel");



    jugador1.setSiguiente(jugador2);
    jugador1.setPrevio(jugador2);
    jugador2.setSiguiente(jugador1);
    jugador2.setPrevio(jugador1);

    System.out.println("Cuantas rondas quieres jugar?");
    int rondas = lector.nextInt();
    lector.nextLine();

    for(int r=0;r<rondas;r++)
    {
    int levanta =Juego(jugador1);
       if(levanta%2==0)
           {
               System.out.println("Pares!!");
               System.out.println("");
           }
    else
        {
               System.out.println("Nones!!");
               System.out.println("");
        }
    }



}

    public static int Juego(Jugador jugador1)
    {
        Scanner lector = new Scanner(System.in);
        Jugador jugact = jugador1;
    System.out.printf("Es el turno de %s ",jugact.getNombre());
    System.out.println("");
    System.out.println("Cuantos dedos levantas? (1-2)");
    jugact.setDedos(lector.nextInt());
    jugact= jugact.getSiguiente();
    System.out.printf("Es el turno de %s ",jugact.getNombre());
    System.out.println("");
    System.out.println("Cuantos dedos levantas? (1-2)");
    jugact.setDedos(lector.nextInt());
    return jugador1.getDedos()+jugador1.getSiguiente().getDedos();
    }

}
