public class RandomDecisiones extends RandomEncounters
{
 int consequence,encounter;
private boolean decision;
public RandomDecisiones(int encounter, int consequence,boolean decision)
{
  super(encounter,consequence);
  this.encounter=super.encounter;
  this.consequence=super.consequence;
  this.decision=decision;

}

public void DescribeConsecuencias(SistemasP sist) throws InterruptedException
{
  switch(this.encounter)
  {
    case 0:
    if(this.decision==true)
    {
      System.out.println("La mayoría de la tecnología es arcaica, pero la nave claramente ha sido interceptada en algún punto de su trayecto por vida inteligente. Ahora, junto con los discos de oro detallando a la cultura humana, se encuentran unos discos de hechura idéntica, relatando la existencia de otra vida mediante pictogramas. Esto incrementa el valor de la base de datos cultural.");
      super.consequence=3;
      Thread.sleep(5000);
    }
    else
    {
      System.out.println("Al darse la vuelta para regresar a su trayecto, el sistema de navegación coloca a la nave en el camino recién recorrido por el Discovery. Los remanentes de combustibles nucleares dejados en la estela afectan a la nave de maneras desconocidas");
      super.RandomConsequences(sist);
      Thread.sleep(5000);
    }
    break;
    case 1:
    if(this.decision==true)
    {
      System.out.println("Escapar de los meteoritos logró prevenir el daño a todos los sistemas de la nave, pero gracias al tiempo extra tardado en rodear al campo de asteroides, fallaron muchas cápsulas criogénicas, provocando así la muerte de mil colonos");
      Thread.sleep(5000);
      super.consequence=1;
    }
    else
    {
      System.out.println("La IA decide confiar en sus habilidades de navegación para llegar hasta su destino a salvo. Logra mantener la integridad de la nave, pero inevitablemente hay micrometeoritos que causan estragos en los sistemas de la nave");
      super.RandomConsequences(sist);
      Thread.sleep(5000);
    }
    break;

    case 2:
    if(this.decision==true)
    {
      System.out.println("La IA usa todo su conocimiento de preservación para reparar y mantener los circuitos eléctricos que conforman la red de sensores. Sin embargo, sus esfuerzos son insuficientes, y se ve forzada a re-rutear energía de las bases de datos para mantener a los sensores a flote. Cientos de miles de canciones, conocimiento científico, y los logros colectivos de la humanidad, sacrificados para llegar a un nuevo hogar. ");
      super.consequence=7;
      Thread.sleep(5000);

    }
    else
    {
      System.out.println("Los escáneres no son tan importantes. La IA no puede dejar que sus colonos mueran, ni que pierdan lo que los hace humanos. Periodicamente le llegan mensajes de error de los escáneres, pero ha aprendido a ignorarlos");
      sist.lastimaComponentes();
      Thread.sleep(5000);

    }
    break;

    case 3:
    if(this.decision==true)
    {
      System.out.println("El encontrar a la primer raza alienígena conocida por la humanidad es un evento demasiado grande como para ser detenido por la cobardía y los riesgos. La IA extiende un saludo 'universal'; Una serie de números primos, supuestamente deducibles por cualquier especie inteligente. Pasan unos tensos segundos antes que la nave responda con un saludo similar, junto con la transmisión de los conocimientos básicos de su especie. Despues de hacer lo mismo, las dos naves siguen en su camino, habiendo hecho un nuevo amigo en el universo. ");
      super.consequence=4;
      Thread.sleep(5000);
    }
    else
    {
      System.out.println("La curiosidad mató al gato, y este gato trae consigo la última esperanza de la humanidad, algo demasiado valioso como para perderlo por conocimientos potenciales. La IA decide no establecer comunicaciones con la nave, y prosigue en su camino. Sin embargo, no puede dejar de pensar que hubo una oportunidad desperdiciada");
      Thread.sleep(5000);
    }
    break;

    case 4:
    if(this.decision==true)
    {
      System.out.println("'Sin cultura, no habría memoria. Sin memoria, no hay civilización'. Bajo esta máxima se ha regido la IA para decidir a cuál base de datos salvar primero. Rápidamente logra regresar la situación en la base de datos cultural a la normalidad, y se han prevenido daños posteriores. Sin embargo, esto vino a expensas de la otra base de datos, de la cual se perdió mucho más.");
      super.consequence=6;
      Thread.sleep(5000);
    }
    else
    {
      System.out.println("'Cogito, ergo sum'. Bajo esta máxima se ha regido la IA para decidir a cuál base de datos salvar primero. Rápidamente logra regresar la situación en la base de datos científica a la normalidad, y se han prevenido daños posteriores. Sin embargo, esto vino a expensas de la otra base de datos, de la cual se perdió mucho más.");
      super.consequence = 5;
      Thread.sleep(5000);
    }
    break;
  }
}


//AQUI VAN LAS CONSECUENCIAS DE LAS DECISIONES TOMADAS EN RANDOMENCOUNTERS
}
