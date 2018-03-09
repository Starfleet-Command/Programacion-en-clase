public class ArrayList
{
  public static void main(String[] args)
  {
   //Arreglos dinamicos que no necesitan tener un tamaño declarado, y nuevos elementos llenan espacios previos vacios

   //Añadir y reorganizar elementos en cualquier indice

   ArrayList<String> name = new ArrayList<String>();
   name.set(0,Jose);
   String variable = name.get(0);
   name.size();

   //Para reorganizar valores se usan:

   name.add(Juan); //Pon el valor a final de la lista. Puedes usar (1,Juan) para poner el lugar exacto
   name.remove(1); //Para quitar y recorrer toda la lista 1
   name.indexOf(Jose); //para ver en cual indice esta este valor. Si no existe regresa -1
   int sum =0;

   for(int i=0; i<name.size();i++)
   {
     sum+= name.get(i);
   }

   for (int i=name.size()-2; i<0;i--)
   {
     int a = name.get(i);
     int b = list.get(i+1);
     name.set(i,a+b);
   }

   System.out.println(name);



  }
}
