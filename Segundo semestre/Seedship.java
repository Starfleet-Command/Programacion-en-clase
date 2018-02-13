import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Seedship
{


  public static void main(String[] args) throws InterruptedException
  {

    int atmo = 100;
    int grav = 100;
    int agua = 100;
    int recurso = 100;
    int colonos = 100000;





System.out.println("Y cuando se dieron cuenta que la tierra no se mantendría por mucho tiempo, crearon una nave. No un arca, sino una semilla. Una nave llena de potencial, que representaría a la humanidad en el espacio");
Thread.sleep(5000);

System.out.println("Para pilotear la nave, crearon una obra de arte en tecnología. Una Inteligencia Artificial, que pudiera pensar como humano y sobrevivir a los rigores del espacio.");
Thread.sleep(5000);


System.out.println("Dos mil años despues del lanzamiento de la nave, finalmente llegó al primer destino que se habia considerado. La IA, esperanzada más de lo que sería logico asumir, calibra las antenas con dirección a la tierra. Nada. Los 100,000 colonos contenidos en la nave son los últimos humanos existentes en el universo. ");
Thread.sleep(5000);

System.out.println("Al llegar al planeta indicado, la IA hizo un chequeo final de sistemas:");
System.out.println("");
Thread.sleep(3000);
escaner();

System.out.println("El planeta tenía las siguientes características:");

planetas(atmo,grav,agua,recurso,colonos);
Thread.sleep(5000);





}
//-------------------------------------------------------------------
public static void escaner()  throws InterruptedException
{
  String atmo = "100";
  String grav = "100";
  String agua = "100";
  String recurso = "100";
  String humanos = "100,000";

  System.out.printf("Escaner Atmosferico: %s \t",atmo);
  Thread.sleep(500);
  System.out.printf("Escaner Gravitacional: %s %n",grav);
  Thread.sleep(500);
  System.out.printf("Escaner Acuatico: %s \t \t",agua);
  Thread.sleep(500);
  System.out.printf("Escaner de Recursos: %s %n",recurso);
  Thread.sleep(500);
  System.out.printf("Colonos: %s",humanos);
  Thread.sleep(500);

  System.out.println("");
}

public static void planetas(int atmo, int grav, int agua,int recurso, int colon) throws InterruptedException
{

  Scanner lector = new Scanner(System.in);


  Random planetas = new Random();
  Random sistemas = new Random();

int system = sistemas.nextInt(90);



int planet1 = planetas.nextInt(3);
int planet2 = planetas.nextInt(3);
int planet3 = planetas.nextInt(3);
int planet4 = planetas.nextInt(3);

int atmosf = planet1;
int gravi = planet2;
int aguas = planet3;
int recursos = planet4;



switch(atmosf)
{
case 0:
System.out.println("Atmósfera Inexistente");
break;

case 1:
System.out.println("Atmósfera Débil");
break;

case 2:
System.out.println("Atmósfera Excelente");
break;
}

switch(gravi)
{
case 0:
System.out.println("Gravedad Muy baja");
break;

case 1:
System.out.println("Gravedad Baja");
break;

case 2:
System.out.println("Gravedad normal");
break;
}

switch(aguas)
{
case 0:
System.out.println("Agua inexistente");
break;

case 1:
System.out.println("Océanos salados");
break;

case 2:
System.out.println("Rios y lagos de agua dulce");
break;
}

switch(recursos)
{
case 0:
System.out.println("Recursos muy escasos");
break;

case 1:
System.out.println("Pocos Recursos");
break;

case 2:
System.out.println("Recursos abundantes");
break;
}


System.out.println("Ahora, la Inteligencia Artificial debía decidir si iba a fundar una colonia en el planeta. El fundar la colonia representaría la culminación del viaje, y el cumplimiento del proposito de la IA. Si los colonos sobreviven.");
Thread.sleep(4000);
System.out.println("Fundar una colonia? (S/N)");
String confirmo = lector.nextLine();

if(confirmo=="si")
{
  score(atmo,grav,agua,recurso,colon,atmosf,gravi,aguas,recursos);

}

else if(confirmo=="no")
{
  planetas(atmo,grav,agua,recurso,colon);
}
}

public static void score(int atm,int grav, int agu, int recu, int colon, int planeta1, int planeta2, int planeta3, int planeta4)
{
  int score1= atm*10;
  int score2= grav*10;
  int score3= agu*10;
  int score4 = colon/10;
  int score5=0;
  int score6=0;
  int score7=0;
  int score8=0;

  switch(planeta1)
  {
    case 0:
    score5=-3000;
    break;

    case 1:
    score5=-1000;
    break;

    case 2:
    score5=3000;
    break;
  }

  switch(planeta2)
  {
    case 0:
    score6=-3000;
    break;

    case 1:
    score6=-1000;
    break;

    case 2:
    score6=3000;
    break;
  }

  switch(planeta3)
  {
    case 0:
    score7=-3000;
    break;

    case 1:
    score7=-1000;
    break;

    case 2:
    score7=3000;
    break;
  }

  switch(planeta4)
  {
    case 0:
    score8=-3000;
    break;

    case 1:
    score8=-1000;
    break;

    case 2:
    score8=3000;
    break;
  }


int scorefinal= score1+score2+score3+score4+score5+score6+score7+score8;

System.out.println("Tu score final es: "+scorefinal);
}




}
