public class Bidimensionales
{
  public static void main(String[] args)
  {



    int[][] matriz = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}};
    reloj(matriz);
  }

  public static void reloj(int[][] array)
  {
int alta =array[0][0]+array[0][1]+array[0][2]+array[1][0]+array[2][0]+array[2][1]+array[2][2];
int temp=0;

      for(int i=0;i<array.length-2;i++)
      {
        for(int j=0;j<array[0].length-2;j++)
        {
          temp= array[i][j]+array[i][j+1]+array[i][j+2]+array[i+1][j+1]+array[i+2][j]+array[i+2][j+1]+array[i+2][j+2];
          if(temp>alta)
          {
            alta=temp;
          }
        }
      }
        System.out.println("El reloj de arena más grande es: "+alta);


  }

}
