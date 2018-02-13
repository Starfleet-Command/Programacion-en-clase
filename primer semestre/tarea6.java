public class tarea6
{
    public static void main(String[] args)
    {
        int Arreglo1[]=new int[5];

        Arreglo1[0]=3;
        Arreglo1[1]=5;
        Arreglo1[2]=1;
        Arreglo1[3]=2;
        Arreglo1[4]=5;

        int Arreglo2[]=new int[5];

        for(int i=4; i>=0; i--) {
            Arreglo2[i]=Arreglo1[i];

            System.out.println(Arreglo2[i]);
            }


    }
}
