import java.util.Scanner;

public class reloj
{
  public static void main(String[] args)
  {
    Scanner lectura = new Scanner(System.in);
    int hora, min, sec, horasec, minsec,doce,distancia1,distancia2,suma;
    int hora2,min2,sec2,horasec2,minsec2,suma2,diferencia1,diferencia2;

    System.out.println("Inserta la hora en formato de 24 horas");
    hora = lectura.nextInt();

    System.out.println("Inserta los minutos");
    min = lectura.nextInt();

    System.out.println("Inserta los segundos");
    sec = lectura.nextInt();

    horasec = hora * 3600;
    minsec = min * 60;
    doce= 43200;
    suma = horasec + minsec + sec;
    distancia1= doce-suma;
    distancia2= suma-doce;



    if (suma<=doce) {
    System.out.printf("El tiempo transcurrido desde la ultima rotacion de doce horas es %d segundos. %n",distancia1);


    }

    else if (suma>doce)
    {
      System.out.printf("El tiempo transcurrido desde la ultima rotacion de doce horas es %d segundos. %n",distancia2);

    }
    else;

/*-------------------------------------------------------------------------------------------------------------------*/


    Scanner lectura2 = new Scanner(System.in);

    System.out.println("Inserta una segunda hora en formato de 24 horas");
    hora2 = lectura2.nextInt();

    System.out.println("Inserta los minutos");
    min2 = lectura2.nextInt();

    System.out.println("Inserta los segundos");
    sec2 = lectura2.nextInt();

    horasec2 = hora2 * 3600;
    minsec2 = min2 * 60;
    suma2 = horasec2 + minsec2 + sec2;
    diferencia1 = suma2-suma;
    diferencia2 = suma-suma2;

    if (suma2<43200 && suma<43200 && suma<suma2)
    {
      System.out.printf("La diferencia entre horas es de %d segundos.%n ", diferencia1);
    }
    else if (suma2<43200 && suma<43200 && suma2<suma) {
      System.out.printf("La diferencia entre horas es de %d segundos.%n ", diferencia2);
    }
    else if (suma2>43200 && suma>43200 && suma<suma2) {
      System.out.printf("La diferencia entre horas es de %d segundos.%n",diferencia1);
    }
    else if (suma2>43200 && suma>43200 && suma2<suma) {
      System.out.printf("La diferencia entre horas es de %d segundos.%n ", diferencia2);
    }
    else;


  }


}
