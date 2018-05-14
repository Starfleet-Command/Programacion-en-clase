import java.util.ArrayList;
public class SongMain
{
  public static void main(String[] args)
  {

    Song song1 = new Song(120,3,"5:03","Hallelujah","Jeff Buckley");
    Song song2 = new Song(90,4,"3:00","Poet","Bastille");

    ArrayList<Song> canciones =new ArrayList<Song>();
    canciones.add(song1);
    canciones.add(song2);

    for(Song canc : canciones)
    {
      System.out.println(canc.ToString());
      System.out.println(canc.nextShowing());
    }
    System.out.println(song1.compareTo(song2));

  UbisoftSandbox kek = new UbisoftSandbox(song1,song2);
  kek.ClassType();
  }
}
