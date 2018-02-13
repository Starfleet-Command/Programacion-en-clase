import java.util.Scanner;
public class ProbExamen2
{
  public static void main(String[] args)
  {


    int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t;
    int var1,var2,var3,var4;


    Scanner lector = new Scanner(System.in);

    System.out.println("Digame el ancho de la matriz");
    var1= lector.nextInt();

    System.out.println("Digame el alto de la matriz");
    var2= lector.nextInt();

    var3= ((var1*var2)/2);
    var4= ((var1*var2)/2);

    int[] matriz= new int [var3];
    int[] matriz2= new int [var4];


    for (a=0;a<var3 ;a++ ) {
      System.out.println("Digame los valores de la primera matriz");
      matriz[a]= lector.nextInt();

    }

    for (a=0;a<var4 ;a++ ) {
      System.out.println("Digame los valores de la segunda matriz");
      matriz2[a]= lector.nextInt();
    }
    int[][] matriz3 = new int [var1][var2];

    for (b=0;b<var1 ;b++ ) {

      for (c=0;c<var2 ;c++ ) {

    matriz3[b][b]= (matriz[b]+ matriz2[c]);

}


    for (int renglones =0; renglones <var1; renglones++)
    {
      for(int columnas =0; columnas<var2; columnas++)
      {

        matriz3[renglones][columnas]= matriz3[b][b];
        System.out.printf("%d\t",matriz3[renglones][columnas]);
      }
      System.out.println("");

    }

  }

/* java ProbExamen2
Digame el ancho de la matriz
2
Digame el alto de la matriz
2
Digame los valores de la primera matriz
1
Digame los valores de la primera matriz
2
Digame los valores de la segunda matriz
1
Digame los valores de la segunda matriz
2
3	3
3	3
4	4
4	4
/*






  }
}
