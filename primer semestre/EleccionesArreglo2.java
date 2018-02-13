import java.util.Arrays;

public class EleccionesArreglo2
{

  public static void main(String[] args)
  {
    int votosA,votosB,votosC,votosD,votosTot;
    int mayorC=0, numCuadro=0, coorC=0,coorR=0,i=0;
    double porcA,porcB,porcC,porcD;

    int[] arreglo3 = new int[4];

    int[] matrizA = {194,180,221,432,820};

    int[] matrizB = {48,20,90,50,61};

    int[] matrizC = {206,320,140,821,946};

    int[] matrizD = {45,16,20,14,18};

    int  matriz[][] = {{1,194,48,206,45},{2,180,20,320,16},{3,221,90,140,20},{4,432,50,821,14},{5,820,61,946,18}};



    System.out.println("Distrito \t Candidatos");
    System.out.println("\t  A\t B\t  C\t D");

    display(matriz);


//-----------------------*Calculos Candidatos*----------------------------------

votosA= matrizA[0]+ matrizA[1]+matrizA[2]+matrizA[3]+matrizA[4];
votosB= matrizB[0]+ matrizB[1]+matrizB[2]+matrizB[3]+matrizB[4];
votosC= matrizC[0]+ matrizC[1]+matrizC[2]+matrizC[3]+matrizC[4];
votosD= matrizD[0]+ matrizD[1]+matrizD[2]+matrizD[3]+matrizD[4];
votosTot = votosA+votosB+votosC+votosD;

System.out.printf("Los votos totales son %d",votosTot);
System.out.println("");



porcA= ((double)votosA/(double)votosTot)*100;
porcB= ((double)votosB/(double)votosTot)*100;
porcC= ((double)votosC/(double)votosTot)*100;
porcD= ((double)votosD/(double)votosTot)*100;


//A

System.out.printf("El numero total de votos del candidato A es de %d",votosA);
System.out.println("");
System.out.printf("Su porcentaje total de votos es de %f porciento",porcA);
System.out.println("");

//B

System.out.printf("El numero total de votos del candidato B es de %d",votosB);
System.out.println("");
System.out.printf("Su porcentaje total de votos es de %f porciento",porcB);
System.out.println("");

//C

System.out.printf("El numero total de votos del candidato C es de %d",votosC);
System.out.println("");
System.out.printf("Su porcentaje total de votos es de %f porciento",porcC);
System.out.println("");

//D

System.out.printf("El numero total de votos del candidato D es de %d",votosD);
System.out.println("");
System.out.printf("Su porcentaje total de votos es de %f porciento",porcD);
System.out.println("");

//----------------------------*Candidato Ganador*-------------------------------

if (porcA>50) {
  System.out.println("Ganó el candidato A");
}

else if (porcB>50) {
  System.out.println("Ganó el candidato B");
}

else if (porcC>50) {
  System.out.println("Ganó el candidato C");
}

else if (porcD>50) {
  System.out.println("Ganó el candidato D");
}

else if (porcA <50 && porcB<50 && porcC<50 && porcD < 50)
{
  double matriz2[] = {porcA,porcB,porcC,porcD};

  Arrays.sort(matriz2);

  if (porcA==matriz2[3] || porcA==matriz2[2])
  {
    System.out.println("El candidato A avanza");
  }

  if (porcB==matriz2[3] || porcB==matriz2[2])
  {
    System.out.println("El candidato B avanza");
  }

  if (porcC==matriz2[3] || porcC==matriz2[2])
  {
    System.out.println("El candidato C avanza");
  }

  if (porcD==matriz2[3] || porcD==matriz2[2])
  {
    System.out.println("El candidato D avanza");
  }

}
}

//---------------------*Visualiz. Columna*--------------------------------------
    public static void display(int matriz[][])
    {

      for(int hil =0; hil<matriz.length; hil++)
      {
        for(int col=0; col<matriz[hil].length;col++)
        {

          System.out.printf("%d \t",matriz[hil][col]);

        }

      System.out.println("");
    }
  }
//------------------------------------------------------------------------------
}

/* MacBook-Pro-de-Juan-8:Programacion juanfra$ java EleccionesArreglo2
Distrito 	 Candidatos
	  A	 B	  C	 D
1 	194 	48 	206 	45
2 	180 	20 	320 	16
3 	221 	90 	140 	20
4 	432 	50 	821 	14
5 	820 	61 	946 	18
Los votos totales son 4662
El numero total de votos del candidato A es de 1847
Su porcentaje total de votos es de 39.618190 porciento
El numero total de votos del candidato B es de 269
Su porcentaje total de votos es de 5.770056 porciento
El numero total de votos del candidato C es de 2433
Su porcentaje total de votos es de 52.187902 porciento
El numero total de votos del candidato D es de 113
Su porcentaje total de votos es de 2.423852 porciento
Ganó el candidato C
*/ 
