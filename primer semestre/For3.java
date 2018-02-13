public class For3
  {
public static void main(String[]args)
    {
for(int i=1; i<=9; i++)
      {
        for(int j=9; j>=i; j--)
        {
          System.out.printf("(%d,%d)",i,j);

        }
          System.out.println();
      }
    }
  }
