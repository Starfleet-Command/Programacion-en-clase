import java.util.Arrays;
import java.util.Scanner;

public class Filas
{
  static int[] fila = new int[3];

  public static void main(String[] args)
  {
    int[] a={2,3};
    imprimir(a);
    System.out.println(Arrays.toString(a));

    push(2);
    print();
    push(3);
    print();
    push(4);
    print();
    push(10);
    print();
    pop();
    print();
    pop();
    print();
    pop();
    print();





    /* Metodos de la clase arrays: fill(array,value) , toString(array),copyOf(array,newLength), sort(array), binarySearcg(array,value) */
    /* Pasar por referencia, es decir, sobreescribir un valor de un arreglo en otro, hara que se sobre escriban ambos arreglos*/
  }

  public static void imprimir(int[] k){
    k[0]=4;
  }

  public static void push(int a){
    int i = fila.length-1;
    while(i-1>-1)
    {
      fila[i]=fila[i-1];
      i-= 1;
    }

    fila[0]= a;
  }

  public static void push2(int a){
    for(int i=fila.length-1;i>=0;i--)
    {
      fila[i]=fila[i-1];
    }
    fila[0]=a;
  }

    public static void print()
    {
      System.out.println(Arrays.toString(fila));
    }

    public static void pop(){


    for(int i=fila.length-1; i>=0; i--)
    {
      if(fila[i]!=0)
      {
        fila[i]=0;
        break;
      }
    }



    }
  }
