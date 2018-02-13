public class Moda2
{
public static int mode(int[] n)
{
  Arrays.sort(n);

  int count2 = 0;
  int count1 = 0;
  int pupular1 =0;
  int popular2 =0;


  for (int i = 0; i < n.length; i++)
  {
          pupular1 = n[i];
          count1 = 1;    //see edit

      for (int j = i + 1; j < n.length; j++)
      {
          if (pupular1 == n[j]) count1++;
      }

      if (count1 > count2)
      {
              popular2 = pupular1;
              count2 = count1;
      }

      else if(count1 == count2)
      {
          popular2 = Math.min(popular2, pupular1);
      }
  }

  return popular2;
}
}
