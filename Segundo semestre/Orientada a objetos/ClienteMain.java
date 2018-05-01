//La relacion entre dos clases se da mediante composición, adición, y herencia.

//En una composición, una clase esta compuesta por objetos de otras clases.
import java.util.*;
public class ClienteMain
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    ArrayList<Cliente> lista = new ArrayList<Cliente>();
    char respuesta = 'Y';
    char answer = 'N';
    int contador =0;
    String nombre,apellido;
    int id,edad;

    do{
      System.out.println("Nombre?");
       nombre = sc.next();

      System.out.println("Apellido?");
       apellido = sc.next();

      System.out.println("Edad?");
       edad = sc.nextInt();

      System.out.println("ID?");
       id = sc.nextInt();


      Cliente client = new Cliente(id, nombre,apellido, edad);

      System.out.println("Desea añadirle una tarjeta?(Y/N)");
      char ans = sc.next().charAt(0);
      System.out.println();

      if(ans=='y')
      {
        System.out.println("Numero?");
        String numero = sc.next();

        System.out.println("Limite de Credito?");
        Double balance = sc.nextDouble();

        System.out.println("Fecha de expedicion? (DD/MM/YYYY)?");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int anio = sc.nextInt();

          System.out.println("¿Tipo de tarjeta de Crédito? Seleccione la opción deseada");
          System.out.println("1.CLASICA");
          System.out.println("2.ORO");
          System.out.println("3.PLATINUM");
          System.out.println("4.BLACK");

          int type = sc.nextInt();

          Tarjeta tc = new Tarjeta();


          switch(type){
            case 1:
            Tarjeta tcClasica = new Tarjeta(numero,balance,dia,mes,anio,dia,mes,anio+5,TipoTc.CLASICA);
            break;
            case 2:
            Tarjeta tcOro = new Tarjeta(numero,balance,dia,mes,anio,dia,mes,anio+5,TipoTc.ORO);
            break;
            case 3:
            Tarjeta tcPlat = new Tarjeta(numero,balance,dia,mes,anio,dia,mes,anio+5,TipoTc.PLATINUM);
            break;
            case 4:
            Tarjeta tcBlack = new Tarjeta(numero,balance,dia,mes,anio,dia,mes,anio+5,TipoTc.BLACK);
            break;
            default:
            Tarjeta tcdefault = new Tarjeta(numero,balance,dia,mes,anio,dia,mes,anio+5);

          }
          client.setTarjeta(tc);

            lista.add(client);
            contador++;

            System.out.println("Deseas agregar otro cliente?(Y/N)");
            answer = sc.next().charAt(0);
            System.out.println();
      }

    } while(answer =='Y');

    for(int i=0; i<lista.size();i++)
    {
      if(lista.get(i) != null)
      lista.get(i).PrintCliente();
    }




  /*  Tarjeta tarj1 = new Tarjeta("534373828362",40000,19,12,2000,19,12,2020,TipoTc.CLASICA);
    tarj1.printTC();

    Cliente cliente1 = new Cliente(1926,"Juan","Gortarez",19);
    cliente1.setTarjeta(tarj1);
    cliente1.PrintCliente();

    */
  }
}
