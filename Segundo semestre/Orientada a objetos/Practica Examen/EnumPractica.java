public enum EnumPractica
{
  POET(1),
  HAUNT(3),
  OBLIVION(2),
  POMPEII(4),
  WINTEROFOURYOUTH(5)

  ;

  private final int favorito;

  private EnumPractica(int favorito)
  {
    this.favorito=favorito;
  }

  public int getEscala()
  {
    return favorito;
  }

  public String miFavorito(String nombre)
  {
     String twang = ("La verdad es que mi canción favorita es "+nombre);
    return twang;
  }

}
