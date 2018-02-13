public class EjemploRecursiva
{
  public static void main(String[] args)
  {

    int a=100;
    conteo(a);
  }

    public static void conteo(int num)
    {

        if(num<=0)
          return;
        else
        {
          System.out.printf("%d ",num);
          conteo(num-1); //DEPENDE DE LA POSICIÓN DEL CONTEO SI ESTE ES ASCENDENTE/DESCENDENTE
          return;
        }

      }

    }
