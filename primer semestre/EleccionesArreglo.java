public class EleccionesArreglo
{
  public static void main(String[] args)
  {
    int votosA,votosB,votosC,votosD,votosTot;
    double porcA,porcB,porcC,porcD;


    int[] matrizA = {194,180,221,432,820};

    int[] matrizB = {48,20,90,50,61};

    int[] matrizC = {206,320,140,821,946};

    int[] matrizD = {45,16,20,14,18};

    int  matriz[][] = new int [5][4]

    int[] distrito = {1,2,3,4,5};

//---------------------*Visualiz. Columna*--------------------------------------

    System.out.println("Distrito \t Candidatos");
    System.out.println("\t  A\t B\t  C\t D");


      for(int col =0; col<matrizA.length; col++)
      {


        System.out.printf("%d\t %d\t %d\t %d\t %d ",distrito[col],matrizA[col],matrizB[col],matrizC[col],matrizD[col]);

      System.out.println("");
    }

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
if (porcA <50 && porcB<50 && porcC<50 && porcD < 50)
{

for (i=0;i<50;i++ )
{

  matriz[i][e]+matriz[i+1][e]
  if (i==) {

  }
}
}




}



}
