import java.util.Scanner;
public class FactRecursivo
{
  public static void main(String[] args)
  {
    int usuario,resultado,sumatoria;
    Scanner lector = new Scanner(System.in);
    System.out.println("Deme un numero y le dare su factorial, su sumatoria, y si es divisible entre 2");
    usuario= lector.nextInt();

  resultado =  Operaciones(usuario);
  sumatoria= Sumatoria(usuario);

  System.out.println("El factorial es: "+resultado);


  System.out.println("La sumatoria es: "+sumatoria);

  if (usuario%2==0) {
    System.out.println("Su numero es divisible entre 2");
  }
  else System.out.println("Su numero no es divisible entre 2");
}

  public static int Operaciones(int operando)
  {
    int sumatoria = 0;
    if(operando==0) {
      return 0;
    }

    if(operando==1)
    {
      return 1;
    }


  return operando*=Operaciones(operando-1);
}

  public static int Sumatoria(int operar)
  {
    if (operar==0)
    return 0;

    return operar += Sumatoria(operar-1);
  }
}
