public class Cuenta{

public String nombre;
public double saldo;

public void Depositos(double cantidad){
saldo = saldo+cantidad;

}

public String Consulta()
{
return saldo;
}
}
