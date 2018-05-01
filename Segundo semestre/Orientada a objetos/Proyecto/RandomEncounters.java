import java.util.*;
public class RandomEncounters
{
  protected int encounter,consequence;
public RandomEncounters(int encounter, int consequence)
{
  this.encounter= encounter;    //UN numero dicta cual encuentro es, el otro cuales consecuencias
  this.consequence=consequence;
}

public void InstantiateEncounters() throws InterruptedException
{
  switch(this.encounter)
  {
    case 0:
    System.out.println("En las exploraciones, la IA recibe transmisiones idénticas al código de control de la nave que era transmitido por la base en la Tierra. cuando se estaba realizando el despegue. Al investigar la fuente, descubre que es una sonda espacial, cuyo nombre está tan escondido por micro-impactos que casi no es legible. Su nombre lee: DISCOVERY. Explorar más a fondo?");
    Thread.sleep(8000);
    break;
    case 1:
    System.out.println("El sistema de detección de colisiones despierta a la IA a la mitad de uno de los trayectos para avisarle que ha detectado una lluvia de meteoritos en trayectoria de choque contra la nave, y el sistema de navegación no puede evitar tantos pequeños impactos. El tomar el camino largo puede proteger a varios sistemas, pero el tiempo tomado también puede causar estragos. Escapar de los meteoritos?");
    Thread.sleep(8000);
    break;
    case 2:
    System.out.println("Los sistemas de la nave están hechos para durar. Pero no duran para siempre. El suministro de energía eléctrica a los escáneres esta fallando, y la IA debe decidir si intentar salvarlos, posiblemente causando fallas en otros sistemas, o dejarlos decaer y perder efectividad. Intentar salvar a los escáneres?");
    Thread.sleep(8000);
    break;
    case 3:
    System.out.println("El sistema de alerta temprana despierta a la IA, y avisa que ha detectado un objeto de procedencia orgánica desconocido en trayectoria de intercepción a la nave. Se desconoce todo sobre la nave, incluyendo si está tripulada, sus intenciones, y habilidades ofensivas. dejar que la nave entre en contacto con el objeto extraterrestre?");
    Thread.sleep(8000);
    break;
    case 4:
    System.out.println("Un meteoro errante casi ha impactado la nave, de no ser por el sistema de detección de colisiones, que hizo un viraje de emergencia. Sin embargo, esto ha causado estragos en la seccion de bases de datos: Varios gigabytes de información preciada sobre lo que hace a los humanos únicos está flotando en el espacio. La IA puede concentrar sus esfuerzos en reducir el daño a una base de datos. Salvar la base de datos cultural?");
    Thread.sleep(8000);
    break;
    case 5:
    System.out.println("La IA es despertada de su estasis por un sistema de alarma automatizado, que le avisa que se han muerto colonos en algun punto del trayecto. Sus restos son mandados al espacio, con el pésame de la Inteligencia.");
    this.consequence=1;
    Thread.sleep(4000);
    break;
    case 6:
    System.out.println("La IA, después de un análisis a fondo de los datos recolectados hasta ahora, determina que puede intentar mejorar los escáneres, para que detecten mejores hábitats para la humanidad.");
    this.consequence=2;
    Thread.sleep(4000);
    break;
  }
}

public void StaticConsequences(SistemasP sistemas)
{


  switch(this.consequence)
  { 
    case 1:
      sistemas.colonos= sistemas.colonos-1000;
    break;
    case 2:
      sistemas.mejoraEscaneres();
    break;
    case 3:
      sistemas.databaseCultural=sistemas.databaseCultural+20;
    break;
    case 4:
      sistemas.databaseCientifico=sistemas.databaseCientifico+20;
    break;
    case 5:
      sistemas.databaseCultural=sistemas.databaseCultural-20;
    break;
    case 6:
      sistemas.databaseCientifico=sistemas.databaseCientifico-20;
    break;
    case 7:
    sistemas.databaseCultural=sistemas.databaseCultural-15;
    sistemas.databaseCientifico=sistemas.databaseCientifico-15;
    break;
  }

}

public void RandomConsequences(SistemasP sistemas)
{
  Random k = new Random();
  int consecuencial = k.nextInt(10);
  consecuencial = this.consequence;

  switch(consecuencial)
  {
    case 0:
    sistemas.escanerAtmo= sistemas.escanerAtmo-10;
    break;

    case 1:
    sistemas.escanerAgua=sistemas.escanerAgua-10;
    break;

    case 2:
    sistemas.escanerGrav=sistemas.escanerGrav-10;
    break;

    case 3:
    sistemas.escanerTemp=sistemas.escanerTemp-10;
    break;

    case 4:
    sistemas.escanerRec=sistemas.escanerRec-10;
    break;

    case 5:
    sistemas.aterrizaje=sistemas.aterrizaje-10;
    break;

    case 6:
    sistemas.colonos=sistemas.colonos-1000;
    break;

    case 7:
    sistemas.databaseCultural=sistemas.databaseCultural-10;
    break;

    case 8:
    sistemas.databaseCientifico = sistemas.databaseCientifico-10;
    break;

    case 9:
    sistemas.lastimaComponentes();
    break;
  }
}





}
