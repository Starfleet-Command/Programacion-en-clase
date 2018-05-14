public class Song implements Comparable<Song>,Stringair
{
  protected int bpm,tempo;
  protected String length,name,author;

public Song(int bpm,int tempo, String length, String name, String author)
{
  this.bpm=bpm;
  this.tempo=tempo;
  this.length=length;
  this.name=name;
  this.author=author;
}

public int compareTo(Song song2)
{
  if(this.tempo<song2.tempo)
  {
    return -1;
  }
  else if(this.tempo==song2.tempo)
  {
    return 0;
  }
  else return 1;
}

public String ToString()
{
  String twang = (bpm + ","+tempo + "," +length+","+name+"," +author);
  return twang;
}

public String nextShowing()
{
  String twung = (name + " "+ "Will be shown at "+ author + "'s next concert" );
  return twung;
}

}
