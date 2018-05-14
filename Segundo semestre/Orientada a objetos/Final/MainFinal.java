import java.util.ArrayList;
public class MainFinal
{
  public static void main(String[] args)
  {
    boolean esRentado=false;
    ArrayList<Vehiculos> almacen = new ArrayList<Vehiculos>();

    Vehiculos moto1 = new Motos("Mercedes","A0102",01,2000,80,2017,20,2);
    Vehiculos moto2 = new Motos("Suzuki","A0103",02,2500,80,2014,20,2);
    Vehiculos furg1 = new Furgonetas("Nissan","E15",03,4000,90,2010,1500,4.0,100,4);
    Vehiculos furg2 = new Furgonetas("Volvo","E19",04,6000,100,2011,1500,3.2,100,3);
    Vehiculos deport1 = new Deportivos("Lamborghini","K12",05,150,50,2009,2,2,true,70,2);
    Vehiculos deport2 = new Deportivos("Mercedes-Benz","K16",06,400,40,2013,2,2,true,50,6);

    almacen.add(moto1);
    almacen.add(moto2);
    almacen.add(furg1);
    almacen.add(furg2);
    almacen.add(deport1);
    almacen.add(deport2);

    for(int a=0;a<almacen.size();a++)
    {
      if(almacen.get(a).getID()%2==0)
      {
        esRentado=true;
      }
      else esRentado=false;

      System.out.println("El vehículo con ID "+almacen.get(a).getID()+ " Tiene el "+almacen.get(a).getGasolina() +"% de gasolina, y su estado actual de renta es:  "+esRentado + ". Su costo de alquiler sería: $"+almacen.get(a).Alquiler(almacen.get(a).getDias(),almacen.get(a).getCapacidad(),almacen.get(a).getGasolina()) + ". Su costo base de renta es: "+almacen.get(a).getCost());

      if(esRentado==true)
      {
        System.out.println("El vehículo está rentado por: "+almacen.get(a).getDias() + " días.");
        System.out.println("");
      }
    }


  }
}
