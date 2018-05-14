public interface Sueldo
{

  default public void gibSueldo(int sueldo)
  {
    System.out.println("El sueldo de este men es de "+sueldo);
  }
}
