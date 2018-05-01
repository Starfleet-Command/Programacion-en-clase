import java.util.*;

public class SistemasP
{
int escanerAtmo,escanerAgua,escanerGrav,escanerTemp,escanerRec,aterrizaje,colonos,databaseCultural,databaseCientifico,syst;
protected boolean isMejorado=false;


public SistemasP(int atmo, int agua, int grav, int temp, int rec, int aterrizaje, int colonos, int cultural, int cientifico)
{
  this.escanerAtmo=atmo;
  this.escanerAgua=agua;
  this.escanerGrav=grav;
  this.escanerTemp=temp;
  this.escanerRec=rec;
  this.aterrizaje=aterrizaje;
  this.colonos=colonos;
  this.databaseCultural=cultural;
  this.databaseCientifico=cientifico;
}

public SistemasP()
{

}

public void lastimaComponentes()
{
  Random sistema = new Random();
  syst = sistema.nextInt(5);

  switch(syst)
  {
    case 0:
    escanerAtmo = escanerAtmo-20;
    break;
    case 1:
    escanerAgua = escanerAgua-20;
    break;
    case 2:
    escanerGrav = escanerGrav-20;
    break;
    case 3:
    escanerTemp = escanerTemp-20;
    break;
    case 4:
    escanerRec = escanerRec-20;
    break;

  }
}

  public void mejoraEscaneres()
  {

    Random sistema = new Random();
    syst = sistema.nextInt(2);

    if(syst==1)
    {
      System.out.println("La mejora se pudo realizar con éxito");
      isMejorado=true;
      System.out.println("");
    }
    else {
      System.out.println("Tristemente, la mejora falló");
      isMejorado= false;
      System.out.println("");
    }

  }



public void printSistemas() throws InterruptedException
{
  System.out.printf("Escaner Atmosferico: %s \t",escanerAtmo);
  Thread.sleep(500);
  System.out.printf("Escaner Gravitacional: %s %n",escanerGrav);
  Thread.sleep(500);
  System.out.printf("Escaner Acuatico: %s \t \t",escanerAgua);
  Thread.sleep(500);
  System.out.printf("Escaner de Recursos: %s %n",escanerRec);
  Thread.sleep(500);
  System.out.printf("Escaner de Temperatura: %s %n",escanerTemp);
  Thread.sleep(500);
  System.out.printf("Colonos: %s %n",colonos);
  Thread.sleep(500);
  System.out.printf("Base de datos cultural: %s \t ",databaseCultural);
  Thread.sleep(500);
  System.out.printf("Base de datos científica: "+databaseCientifico);

  System.out.println("");
}


}
