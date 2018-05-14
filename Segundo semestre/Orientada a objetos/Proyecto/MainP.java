import java.util.*;
public class MainP
{
  public static void main(String[] args) throws InterruptedException
  {
    //VARIABLES
    Scanner lector = new Scanner(System.in);
    Random rand = new Random();
    int escanerAtmo,escanerAgua,escanerGrav,escanerTemp,escanerRec,aterrizaje,colonos,databaseCultural,databaseCientifico,contador,k;
    boolean decision=false;
    escanerAtmo=100;
    escanerAgua=100;
    escanerGrav=100;
    escanerTemp=100;
    escanerRec=100;
    aterrizaje=100;
    colonos=10000;
    databaseCultural=100;
    databaseCientifico=100;
    contador=0;

SistemasP sistemas = new SistemasP(escanerAtmo, escanerAgua, escanerGrav, escanerTemp, escanerRec,  aterrizaje, colonos, databaseCultural, databaseCientifico);
PlanetasP plans = new PlanetasP();

    //PRINCIPAL



    System.out.println("Y cuando se dieron cuenta que la tierra no se mantendría por mucho tiempo, crearon una nave. No un arca, sino una semilla. Una nave llena de potencial, que representaría a la humanidad en el espacio");
    System.out.println("");
    Thread.sleep(5000);

    System.out.println("Para pilotear la nave, crearon una obra de arte en tecnología. Una Inteligencia Artificial, que pudiera pensar como humano y sobrevivir a los rigores del espacio.");
    System.out.println("");
    Thread.sleep(5000);


    System.out.println("Dos mil años despues del lanzamiento de la nave, finalmente llegó al primer destino que se habia considerado. La IA, esperanzada más de lo que sería logico asumir, calibra las antenas con dirección a la tierra. Nada. Los 10,000 colonos contenidos en la nave son los últimos humanos existentes en el universo. ");
    System.out.println("");
    Thread.sleep(5000);

    System.out.println("Al llegar al planeta indicado, la IA hizo un chequeo final de sistemas:");
    System.out.println("");
    Thread.sleep(3000);
    sistemas.printSistemas();

    Thread.sleep(2000);
    System.out.println("El planeta tenía las siguientes características:");
    System.out.println("");
    plans.Instantiate(plans.planets);
    contador++;

    System.out.println("Ahora, la Inteligencia Artificial debía decidir si iba a fundar una colonia en el planeta. El fundar la colonia representaría la culminación del viaje, y el cumplimiento del proposito de la IA. Si los colonos sobreviven.");
    System.out.println("");
    Thread.sleep(4000);
    System.out.println("Fundar una colonia? (Si/No)");

    if(lector.nextLine().equals("Si"))
    {
      plans.Aterrizaje(sistemas,plans.planets.get(contador-1));
      System.exit(0);
    }

    System.out.println("La IA decidió que ese planeta no era el indicado para la raza humana. Sin embargo, no todo fue para nada, porque tuvo la oportunidad de mejorar sus escáneres.");

    sistemas.mejoraEscaneres();



    while ((decision==false))
    {
      System.out.println("");
      System.out.println("El siguiente planeta visitado tenía estas características: ");
      plans.Instantiate(plans.planets);
      contador++;
       k= rand.nextInt(10);

      System.out.println("Fundar una colonia? (Si/No)");

      if(lector.nextLine().equals("Si"))
      {
        decision=true;
        plans.Aterrizaje(sistemas,plans.planets.get(contador-1));
        System.exit(0);
      }
      if(k<5)
      {
          Random a = new Random();


          int encuentro = a.nextInt(7);
          int consec =9;

          RandomEncounters encuentros = new RandomEncounters(encuentro,consec);
          encuentros.InstantiateEncounters();
          if(encuentros.consequence ==1 || encuentros.consequence == 2)
          {
            encuentros.StaticConsequences(sistemas);
            System.out.println("La nave ahora tiene este balance de sistemas");
            sistemas.printSistemas();
          }
          else
          {
            System.out.println("true para confirmar, false para negar");
            String capturar = lector.nextLine(); //DEBE HABER UN TRY CATCH DE INVALID INPUT
            boolean entweder = false;
              if(capturar.equals("true"))
              {
                entweder=true;
              }
              else entweder = false;
            
            RandomDecisiones decisionesR = new RandomDecisiones(encuentros.encounter,encuentros.consequence,entweder);
            decisionesR.DescribeConsecuencias(sistemas);
            decisionesR.StaticConsequences(sistemas);
            System.out.println("La nave ahora tiene este balance de sistemas");
            sistemas.printSistemas();
          }
      }

    }


  }
}
