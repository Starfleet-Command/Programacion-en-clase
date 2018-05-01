import java.util.*;
public class Cliente
{
  private int id;
  private String nombre;
  private String apellido;
  private int edad;
  private Tarjeta tc;
  private static int count =0;
  private ArrayList<Tarjeta> listatarj = new ArrayList<Tarjeta>();


  public Cliente(int id, String nombre, String apellido, int edad)
  {
    count++;
    this.id=id;
    this.nombre=nombre;
    this.apellido=apellido;
    this.edad=edad;
  }

  public void setTarjeta(Tarjeta tc)
  {
    this.tc=tc;
  }

  public void PrintCliente()
  {
      System.out.printf("ID: %d\n Nombre: %s %s \n Edad: %d \n",id,nombre,apellido,edad);
      if(tc!=null)
      tc.printTC();

      else System.out.println("el cliente no tiene tarjeta asignada");
  }

}
