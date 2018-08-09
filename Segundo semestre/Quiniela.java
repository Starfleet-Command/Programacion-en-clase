import java.util.*;
public class Quiniela
{
  public static void main(String[] args)
  {
     int puntos,golfavor,golcontra,partgan,partemp,difgoles;



    Equipo a =new Equipo("Rusia");
    Equipo b =new Equipo("A. Saudita");
    Equipo c =new Equipo("Egipto");
    Equipo d =new Equipo("Uruguay");
    Equipo[] grupoA = new Equipo[]{a,b,c,d};

    Equipo e =new Equipo("Marruecos");
    Equipo f =new Equipo("Iran");
    Equipo g =new Equipo("Portugal");
    Equipo h =new Equipo("España");
    Equipo[] grupoB = new Equipo[]{e,f,g,h};

    Equipo i =new Equipo("Francia");
    Equipo j =new Equipo("Australia");
    Equipo k =new Equipo("Peru");
    Equipo l =new Equipo("Dinamarca");
    Equipo[] grupoC = new Equipo[]{i,j,k,l};

    Equipo m =new Equipo("Argentina");
    Equipo n =new Equipo("Islandia");
    Equipo o =new Equipo("Croacia");
    Equipo p =new Equipo("Nigeria");
    Equipo[] grupoD = new Equipo[]{m,n,o,p};

    Equipo q =new Equipo("Costa Rica");
    Equipo r =new Equipo("Serbia");
    Equipo s =new Equipo("Brasil");
    Equipo t =new Equipo("Suiza");
    Equipo[] grupoE = new Equipo[]{q,r,s,t};

    Equipo u =new Equipo("Alemania");
    Equipo v =new Equipo("Mexico");
    Equipo w =new Equipo("Suecia");
    Equipo x =new Equipo("Corea del Sur");
    Equipo[] grupoF = new Equipo[]{u,v,w,x};

    Equipo y =new Equipo("Bélgica");
    Equipo z =new Equipo("Panamá");
    Equipo aa =new Equipo("Túnez");
    Equipo ab =new Equipo("Inglaterra");
    Equipo[] grupoG = new Equipo[]{y,z,aa,ab};

    Equipo ac=new Equipo("Polonia");
    Equipo ad =new Equipo("Senegal");
    Equipo ae =new Equipo("Colombia");
    Equipo af =new Equipo("¨Japón");
    Equipo[] grupoH = new Equipo[]{ac,ad,ae,af};

ArrayList<Equipo[]> grupos = new ArrayList<Equipo[]>();
grupos.add(grupoA);
grupos.add(grupoB);
grupos.add(grupoC);
grupos.add(grupoD);
grupos.add(grupoE);
grupos.add(grupoF);
grupos.add(grupoG);
grupos.add(grupoH);

Quiniela quin = new Quiniela();
for(int er=0; er<grupos.size();er++)
{
  quin.Matches(grupos.get(er));
}


  }

  public void Matches(Equipo[] grupo)
  {
    Scanner lector=new Scanner(System.in);
    int local, visitante;
    int num=1;
    System.out.println("Escriba su resultado planeado para los siguientes partidos en el formato: LOCAL: 1ra linea. VISITANTE:2da linea");

    System.out.printf("%s vs. %s",grupo[0].nombre,grupo[1].nombre);
    System.out.println("");
    local=lector.nextInt();
    visitante=lector.nextInt();
    AsignaResultados(grupo,grupo[0],grupo[1],local,visitante);

    System.out.printf("%s vs. %s",grupo[2].nombre,grupo[3].nombre);
    local=lector.nextInt();
    visitante=lector.nextInt();
    AsignaResultados(grupo,grupo[2],grupo[3],local,visitante);

    System.out.printf("%s vs. %s",grupo[0].nombre,grupo[2].nombre);
    System.out.println("");
    local=lector.nextInt();
    visitante=lector.nextInt();
    AsignaResultados(grupo,grupo[0],grupo[2],local,visitante);

    System.out.printf("%s vs. %s",grupo[1].nombre,grupo[3].nombre);
    System.out.println("");
    local=lector.nextInt();
    visitante=lector.nextInt();
    AsignaResultados(grupo,grupo[1],grupo[3],local,visitante);

    System.out.printf("%s vs. %s",grupo[0].nombre,grupo[3].nombre);
    System.out.println("");
    local=lector.nextInt();
    visitante=lector.nextInt();
    AsignaResultados(grupo,grupo[0],grupo[3],local,visitante);

    System.out.printf("%s vs. %s",grupo[1].nombre,grupo[2].nombre);
    System.out.println("");
    local=lector.nextInt();
    visitante=lector.nextInt();
    AsignaResultados(grupo,grupo[1],grupo[2],local,visitante);
    SetTabla(grupo);

  }

  public void AsignaResultados(Equipo[] grupo,Equipo local, Equipo visitante,int gollocal, int golvisita)
  {
    if(gollocal>golvisita)
    {
      local.partgan++;
    }
    else if (golvisita>gollocal)
    {
      visitante.partgan++;
    }
    else if(golvisita==gollocal)
    {
      local.partemp++;
      visitante.partemp++;
    }

    local.golfavor+=gollocal;
    local.golcontra+=golvisita;
    local.difgoles=local.golfavor-local.golcontra;
    local.puntos=((local.partgan*3)+(local.partemp));

    visitante.golfavor+=golvisita;
    visitante.golcontra+=gollocal;
    visitante.difgoles=visitante.golfavor-visitante.golcontra;
    visitante.puntos=((visitante.partgan*3)+visitante.partemp);

  }

  public void SetTabla(Equipo[] grupo)
  {
    int mayor=0;
    int mayordif=0;
    int mayoranot=0;
    boolean tiebreak1=false;
    boolean tiebreak2=false;

    for(int k=0;k<grupo.length;k++)
    {
      if(grupo[k].puntos>mayor)
      {
        mayor=grupo[k].puntos;
      }
      if(grupo[k].puntos==mayor)
      {
        tiebreak1=true;
      }
    }

    if(tiebreak1==true)
    {
      for(int s=0;s<grupo.length;s++)
      {
        if(grupo[s].difgoles>mayordif)
        {
          mayordif=grupo[s].difgoles;
        }
        if(grupo[s].difgoles==mayordif)
        {
          tiebreak2=true;
        }
      }
    }
    if(tiebreak1==false && tiebreak2==false)
    {
      grupo= Sorter1(grupo,0);
      PrintTabla(grupo);
    }
    else if(tiebreak1==true && tiebreak2==false)
    {

    }
    else
    {

    }
  }

  public void PrintTabla(Equipo[] grupo)
  {
    System.out.println("Equipo: \t Pts. \t JG \t JE \t Dif. \t GF \t GC");
    for(int e=0;e<grupo.length;e++)
    {
      System.out.printf("%s \t %d \t %d \t %d \t %d \t %d \t %d",grupo[e].nombre,grupo[e].puntos,grupo[e].partgan,grupo[e].partemp,grupo[e].difgoles,grupo[e].golfavor,grupo[e].golcontra);
      System.out.println("");
    }
  }

public Equipo[] Sorter1(Equipo[] grupo,int y)
{
  int mayor1=0;
  Equipo placehold;
  for(int r=y;r<grupo.length;r++)
  {
    if(grupo[r].puntos>mayor1)
    {
      grupo[r].puntos=mayor1;
      placehold= grupo[r];
      grupo[r]=grupo[y];
      grupo[y]=placehold;
    }

  }
  if(grupo[3].puntos<grupo[2].puntos && grupo[2].puntos<grupo[1].puntos && grupo[1].puntos<grupo[0].puntos)
  {
    return grupo;
  }
  else return Sorter1(grupo,y++);
}

public Equipo[] Sorter2(Equipo[] grupo,int y)
{
  int mayor1=0;
  Equipo placehold;
  for(int r=y;r<grupo.length;r++)
  {
    if(grupo[r].difgoles>mayor1)
    {
      grupo[r].difgoles=mayor1;
      placehold= grupo[r];
      grupo[r]=grupo[y];
      grupo[y]=placehold;
    }

  }
  if(grupo[3].difgoles<grupo[2].difgoles && grupo[2].difgoles<grupo[1].difgoles && grupo[1].difgoles<grupo[0].difgoles)
  {
    return grupo;
  }
  else return Sorter2(grupo,y++);
}

}
