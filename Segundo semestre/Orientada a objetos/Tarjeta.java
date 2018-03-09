public class Tarjeta
{
private String numero;
private double saldo;
private Fecha fechaExpedicion;
private Fecha fechaExpiracion;
private TipoTc tipotc;

public Tarjeta(String numero, double saldo, int diaexpe, int mesexpe, int anoexpe, int diaexpi, int mesexpi, int anoexpi, TipoTc tipotc)
{
  this.numero=numero;
  this.saldo=saldo;
  this.tipotc = tipotc;
  fechaExpiracion=new Fecha(diaexpi,mesexpi,anoexpi);
  fechaExpedicion=new Fecha(diaexpe,mesexpe,anoexpe);

}

public Tarjeta()
{

}
public String getNumero()
{
  return numero;
}
public double getSaldo()
{
  return saldo;
}


public void compras(double cantidad)
{
  if(cantidad>saldo)
  {
    System.out.println("Saldos insuficientes para la compra");
  }
    else saldo=saldo-cantidad;
}

public void TipoTarj()
{
  System.out.println("El tipo de tarjeta es "+tipotc);
  System.out.printf("Tasa de interes mensual: %.2f \n ",tipotc.TasaInteresMensual());
  System.out.printf("Tasa de interes anual: %.2f \n ",tipotc.TasaInteresAnual());


}

public void printTC()
{
  System.out.printf("Tarjeta de Crédito: %s\n Saldo: %.2f\n",numero,saldo);
  System.out.printf("Fecha de Expiración: %s \n Fecha de Expedición: %s \n",fechaExpiracion.FormatoFecha(),fechaExpedicion.FormatoFecha());
  TipoTarj();
}




}
