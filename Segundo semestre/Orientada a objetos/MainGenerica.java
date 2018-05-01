public class MainGenerica
{
public static void main(String[] args)
{
  ClaseGenerica<Integer> intObj = new ClaseGenerica<Integer>(88);
  intObj.ClassType();

  ClaseGenerica<String> strObj = new ClaseGenerica<String>("Hola mundo");
  strObj.ClassType();
}
}
