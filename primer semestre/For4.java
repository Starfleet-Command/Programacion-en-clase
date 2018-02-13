public class For4
  {
public static void main(String[]args)
    {
for(int i=0; i<=40; i++)
      {
        System.out.printf("%d",i);
        if(i%2==0)
        {
          System.out.printf("(%d es par)",i);

        }
        if(i%3==0)
        {
          System.out.printf("(%d es divisible entre 3)",i);
        }
          System.out.println();
      }
    }
  }
