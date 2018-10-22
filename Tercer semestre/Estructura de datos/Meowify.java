import java.util.Random;
public class Meowify
{
    public static void main(String[] args)
    {
        Cancion can1 = new Cancion("One Of These Days",176,"Vance Joy","Nation of Two");
        Cancion can2 = new Cancion("Glory",190,"Bastille","Wild World");
        Cancion can3 = new Cancion("Smells Like Teen Spirit",210,"Nirvana","Nevermind");
        Cancion can4 = new Cancion("Spirits",200,"The Strumbellas","Hope");
        Cancion can5 = new Cancion("High As Hope",210,"Florence + The Machine","High as Hope");
        Cancion canNew = new Cancion("Hurricane Drunk",220,"Florence + The Machine","Lungs(Deluxe Edition)");

        can1.setSiguiente(can2);
        can2.setSiguiente(can3);
        can2.setSiguiente(can3);
        can3.setSiguiente(can4);
        can4.setSiguiente(can5);
        can5.setPrevia(can4);
        can4.setPrevia(can3);
        can3.setPrevia(can2);
        can2.setPrevia(can1);



        Cancion nowPlay= playRandom(can1);
        nowPlay= skipAhead(nowPlay);
        nowPlay= skipAhead(nowPlay);
        System.out.println(""+nowPlay.getNombre());
        nowPlay=skipBack(nowPlay);
        aniadeCancion(canNew,nowPlay);
        printPlaylist(nowPlay);
        remueveCancion("Spirits",can1);
        printPlaylist(nowPlay);



    }
    public static Cancion skipAhead(Cancion song)
    {
        if(song.getSiguiente()!=null)
        {
        song=song.getSiguiente();
        }
        return song;
    }
    public static Cancion skipBack(Cancion song)
    {
        if(song.getPrevia()!=null)
        {
        song=song.getPrevia();
        }
        return song;
    }

    public static Cancion playRandom(Cancion song)
    {
        Cancion temps = song;
        Random rand = new Random();

        int size=0;
        while (temps!=null)
                {
                    temps= temps.getSiguiente();
                    size++;
                }
        int aleat = rand.nextInt(size);
        for(int e=0;e<aleat;e++)
        {
            song=song.getSiguiente();
        }

        System.out.println("Ahora reproduciendo: "+song.getNombre());
        return song;
    }

    public static void aniadeCancion(Cancion song,Cancion playlist)
    {
        while (playlist.getSiguiente()!=null)
                {
                    playlist= playlist.getSiguiente();
                }
        playlist.setSiguiente(song);
        song.setPrevia(playlist);
    }

    public static void remueveCancion(String nombre,Cancion playlist)
    {
        while (playlist.getPrevia()!=null)
                {
                   playlist=playlist.getPrevia();
                }

        while (playlist.getSiguiente()!=null && playlist.getNombre().equals(nombre)==false)
                {
                    playlist= playlist.getSiguiente();
                }
        if(playlist.getSiguiente()==null)
        {
            System.out.println("Tu cancion no se encontró en el playlist. ");
        }
        else
        {
            playlist.getPrevia().setSiguiente(playlist.getSiguiente());
            playlist.getSiguiente().setPrevia(playlist.getPrevia());
            System.gc();
        }
    }

    public static void printPlaylist(Cancion playlist)
    {
        while (playlist.getPrevia()!=null)
                {
                   playlist=playlist.getPrevia();
                }
        System.out.println("");
        System.out.println("Playlist:");
        while(playlist!=null)
        {
            System.out.println(""+playlist.getNombre());
            playlist=playlist.getSiguiente();
        }
    }


}
