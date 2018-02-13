import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class ProyectoFinal
{
  public static void main(String[] args) throws IOException
  {
    int a, b, c,k,w,u,saldo,elim,pon;
    int cont;
    String nombre = "demo1.csv";
    String datosLeidos,eliminando,completo,poner;

    BufferedReader br;
    FileReader lector2;
    String arreglo[] = new String[6];
    String[][] arreglo2 = new String[100][];

    cont=0;
    u=0;





    Scanner lector = new Scanner(System.in);


    System.out.println("Escriba el código de nómina"); //Tiene que ser de 1 a 100
    a= lector.nextInt();

    System.out.println("Escriba las asignaciones de ese código"); //Tiene que escribir un numero entero
    b= lector.nextInt();
    System.out.println("Escriba las deducciones de ese código");  //Tiene que escribir un numero entero no mayor al salario del cliente
    c= lector.nextInt();
    lector.nextLine();

    System.out.println("Quiere eliminar un código?"); // Tiene que escribir string "si" (CaseSensitive) para que funcione la eliminacion
    eliminando= lector.nextLine();

    System.out.println("Quiere añadir un código?"); //Igual que en eliminar
    poner = lector.nextLine();






      lector2 = new FileReader(nombre);
       br = new BufferedReader(lector2);

      //----------------Lista de empleados--------------------------------------/

      System.out.println("La lista de empleados es: ");


      while ( (datosLeidos = br.readLine()) != null) //SI aparece xxxxxxx implica que ese valor fue eliminado y no se debe de poner
      {



         System.out.println(datosLeidos);
         arreglo = datosLeidos.split(",");
         arreglo2[u]= arreglo;






      //----------------------------Recibo--------------------------------------/
      saldo = Integer.parseInt(arreglo2[u][4]) + b - c; //Arreglo2 en 4




      if (Integer.toString(a).equals(arreglo2[u][0]) )
      {
        System.out.printf("El recibo de pagos de este trabajador es %s (Sueldo base), %d (Asignaciones totales), %d (Deducciones totales), %s (Saldo Final) \n ", arreglo2[u][4], b, c, saldo );
        System.out.printf("Su ficha de información es: %s (Numero de nomina), %s (Nombre), %s (Apellidos), %s (Puesto), %s (Fecha de Ingreso) %n ", arreglo2[u][0],arreglo2[u][1], arreglo2[u][2],arreglo2[u][3],arreglo2[u][5]);
      }
      else;
u++;
}


      lector2.close();


      if(eliminando.equals( "si"))
      {
        System.out.println("Que usuario desea eliminar?");
        elim = lector.nextInt();
        arreglo2= Eliminado(arreglo2,elim);
      }

      if (poner.equals("si"))
      {
        System.out.println("Escriba que numero de nomina tendra el nuevo usuario");
         pon= lector.nextInt();
        arreglo2= Agregar(arreglo2,pon);
      }

//-----------------------------Escritor en el archivo--------------------------/


    File archivador;
     archivador = new File("Extraproyecto.csv");
     archivador.createNewFile();


     FileWriter escritor = new FileWriter(archivador);
     PrintWriter pw = new PrintWriter(escritor);

cont=0;
while(arreglo2[cont] != null)
{


 completo = String.join(",",arreglo2[cont]);
 System.out.println(completo);
 pw.println(completo);
 cont++;

}
     escritor.close();



 }

 //------------------------Metodos---------------------------------------------/

   public static String[][] Eliminado(String [][] arreglo3, int quita)
   {

   for (int l=0;l<arreglo3.length ;l++ ) {
     if(arreglo3[l] != null)

     if (Integer.toString(quita).equals(arreglo3[l][0]))
     {
       for (int i=0;i<arreglo3[0].length;i++ )
       {
         arreglo3[l][i] = "xxxxxxx";

       }

     }
   }
    return arreglo3;
   }

   public static String[][] Agregar(String[][] arreglo3, int poner )
   {

     Scanner e= new Scanner(System.in);
     String[] arreglo5 = new String[6];

     for (int z=0;z<arreglo3.length ;z++ ) {
       if(arreglo3[z] == null)
       {

      if (poner==z)

       for (int u=0;u<6;u++  ) {

         System.out.println("Vamos a agregar un nuevo usuario" );
          arreglo5[u]= e.nextLine();
          arreglo3[z]= arreglo5;
     }
   }

   }
   return arreglo3;
 }

  }
