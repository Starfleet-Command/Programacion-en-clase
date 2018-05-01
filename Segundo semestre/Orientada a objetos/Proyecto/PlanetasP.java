import java.util.*;


public class PlanetasP extends SistemasP
{

ArrayList<PlanetasP> planets = new ArrayList<PlanetasP>();
  int atmo,agua,temp,grav,recurs;



  public PlanetasP(int atmo,int agua, int recurs, int temp, int grav)
  {
    super();
      this.atmo = atmo;
      this.agua = agua;
      this.recurs = recurs;
      this.temp = temp;
      this. grav = grav;
  }

  public PlanetasP()
  {

  }



  public void CondicionPlaneta()
  {
    switch(this.atmo)
    {
    case 3:
    case 4:
    case 5:
    System.out.println("Atmósfera Inexistente");
    break;

    case 1:
    case 2:
    System.out.println("Atmósfera Débil");
    break;

    case 0:
    System.out.println("Atmósfera Excelente");
    break;
    }

    switch(this.grav)
    {
      case 3:
      case 4:
      case 5:
    System.out.println("Gravedad Muy baja");
    break;

    case 1:
    case 2:
    System.out.println("Gravedad Baja");
    break;

    case 0:
    System.out.println("Gravedad normal");
    break;
    }

    switch(this.agua)
    {
      case 3:
      case 4:
      case 5:
    System.out.println("Agua inexistente");
    break;

    case 1:
    case 2:
    System.out.println("Océanos salados");
    break;

    case 0:
    System.out.println("Rios y lagos de agua dulce");
    break;
    }

    switch(this.recurs)
    {
      case 3:
      case 4:
      case 5:
    System.out.println("Recursos muy escasos");
    break;

    case 1:
    case 2:
    System.out.println("Pocos Recursos");
    break;

    case 0:
    System.out.println("Recursos abundantes");
    break;
    }

    switch(this.temp)
    {
      case 3:
      case 4:
      case 5:
      System.out.println("Temperatura muy inestable");
      break;

      case 1:
      case 2:
      System.out.println("Temperaturas bajas");
      break;

      case 0:
      System.out.println("Temperaturas templadas");
      break;
    }
  }

  public void Instantiate(ArrayList<PlanetasP> planets)
  {
     Random atmosfera = new Random();
     Random aguador = new Random();
     Random recursos = new Random();
     Random temperatura = new Random();
     Random gravedad = new Random();


     int a=5,b=5,c=5,d=5,e=5;
     int atmos,aguas,recurso,tempe,gravi;

     if(super.isMejorado==true || (a>1 && b>1 && c>1 && d>1 && e>1))
     {
       a--;b--;c--;d--;c--;
       super.isMejorado=false;
     }



    atmos = atmosfera.nextInt(a);
    aguas = aguador.nextInt(b);
    recurso = recursos.nextInt(c);
    tempe = temperatura.nextInt(d);
    gravi = gravedad.nextInt(e);

    PlanetasP planet = new PlanetasP(atmos,aguas,recurso,tempe,gravi);
    planets.add(planet);
    planet.CondicionPlaneta();
  }

  public void Aterrizaje(SistemasP x,PlanetasP y) throws InterruptedException
  {
    int score1= x.escanerAtmo*10;
    int score2= x.escanerGrav*10;
    int score3= x.escanerAgua*10;
    int score4 = x.colonos/10;
    int score5=0;
    int score6=0;
    int score7=0;
    int score8=0;
    int score0=0;
    int score9=x.escanerRec*10;
    int score10=x.escanerTemp*10;

    switch(y.atmo)
    {
      case 0:
      score5=3000;
      break;

      case 1:
      case 2:
      score5=-1000;
      break;

      case 3:
      case 4:
      case 5:
      score5=-3000;
      break;
    }

    switch(y.agua)
    {
      case 0:
      score6=3000;
      break;

      case 1:
      case 2:
      score6=-1000;
      break;

      case 3:
      case 4:
      case 5:
      score6=-3000;
      break;
    }

    switch(y.recurs)
    {
      case 0:
      score7=3000;
      break;

      case 1:
      case 2:
      score7=-1000;
      break;

      case 3:
      case 4:
      case 5:
      score7=-3000;
      break;
    }

    switch(y.temp)
    {
      case 0:
      score8=3000;
      break;

      case 1:
      case 2:
      score8=-1000;
      break;

      case 3:
      case 4:
      case 5:
      score8=-3000;
      break;
    }

    switch(y.grav)
    {
      case 0:
      score0=3000;
      break;

      case 1:
      case 2:
      score0=-1000;
      break;

      case 3:
      case 4:
      case 5:
      score0=-3000;
      break;
    }


    int scorefinal= score1+score2+score3+score4+score5+score6+score7+score8;
    System.out.println("Y asi, concluyó la travesía de los últimos vestigios de la raza humana, en búsqueda de un nuevo hogar.La IA esperó haber hecho su trabajo de manera correcta, y así completar el propósito que le fue dada. Ve. Sobrevive.Esparcete. Salva a la raza humana");
    Thread.sleep(6000);
    System.out.println("Tu score final es: "+scorefinal);
    if(scorefinal<0)
    {
      System.out.println("Tristemente, no fue así. No se sabe que causó que la IA decidiera establecerse en donde lo hizo, ni en donde se equivocó. Solamente se sabe que de la raza humana no quedaron ni susurros.");
      Thread.sleep(5000);
    }
    else if(scorefinal>=0 && scorefinal<9000)
    {
      System.out.println("La raza humana apenas lo logró. Gracias al conocimiento traido desde casa, y la adaptabilidad del humano, lograron sobrevivir en un ambiente hostil. Su existencia no se puede comparar con la de la Tierra, pero están vivos. Y algunos dirían que eso es lo más importante de todo");
      Thread.sleep(8000);
    }
    else if(scorefinal>9000 & scorefinal<19000)
    {
      System.out.println("La raza humana lo logró. La IA cumplió su cometido, y llevó a la humanidad a un planeta en donde podrían empezar de nuevo. Aunque hubieran elementos en contra, la humanidad pudo disfrutar de una existencia equiparable a la de la tierra, comprometidos a cuidar de este planeta, y recordando a la IA que los llevó a todos a su hogar.");
      Thread.sleep(10000);
    }
    else if(scorefinal>19000)
    {
      System.out.println("No se sabe si fue azar o destino, pero el planeta escogido por la IA excedió todo pronóstico. Las condiciones eran mejores que las de la tierra, los recursos abundantes, y la situación idílica. Los colonizadores ahora recuerdan a la extinción de la Tierra como la razón de su poderío, mientras exploran el universo en naves con las que los viejos humanos no podrían haber ni soñado. ");
      Thread.sleep(10000);
    }

  }
}
