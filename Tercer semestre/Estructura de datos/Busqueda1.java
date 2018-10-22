import java.util.*;
import java.lang.Integer;
public class Busqueda1{
  public static void main(String[] args) {
    String[] potato   = {"Aba","Abc","Aca","Achi","Achu","Aes","Aga","Ahe","Ahi","Aho","Aja","Aje","Aji","Ajo","Ala","Ale","Ali","Alla","Alli","Ama","Ame","Ami","Amo","Ana","Ano","Aña","Año","Apa","Api","Ara","Are","Aro","Arra","Arre","Asa","Ase","Asi","Aso","Ata","Ate","Ato","Aun","Ave","Avo","Aya","Ayo","Azo","Bah","Bao","Bar","Bel","Ben","Bes","Bey","Bio","Bis","Bit","Bla","Ble","Boa","Boj","Bol","Bon","Bou","Box","Boy","Bua","Bue","Bum","Bus","Buz","Cae","Cai","Cal","Can","Cao","Cap","Car","Cas","Cay","Caz","Cea","Ceo","Ces","Cia","Cid","Cie","Cio","Clo","Coa","Col","Con","Cor","Coy","Coz","Cui","Cus","Cuy","Cuz","Chai","Chal","Chan","Chao","Chas","Chat","Chau","Chef","Ches","Chia","Chic","Chie","Chii","Chin","Chio","Chip","Chis","Chop","Choz","Chua","Chuj","Chus","Chut","Chuz","Dad","Dan","Dar","Das","Dea","Del","Den","Des","Dey","Dia","Dij","Din","Dio","Diu","Dix","Dom","Don","Dos","Doy","Dua","Duo","Dux","Duz","Eco","Ecu","Echa","Eche","Echo","Ees","Efe","Ego","Eje","Ele","Ella","Elle","Ello","Eme","Emu","Ene","Eñe","Eon","Epa","Epo","Era","Ere","Erg","Ero","Erra","Erre","Erro","Esa","Ese","Eso","Eta","Evo","Fai","Fan","Far","Fas","Fax","Faz","Fea","Feo","Fer","Fes","Fez","Fia","Fie","Fil","Fin","Fio","Fis","Fon","Fua","Fue","Fui","Ful","Full","Gag","Gal","Gap","Gas","Gay","Gea","Gel","Gen","Geo","Ges","Gil","Gin","Gis","Gol","Gro","Gua","Hall","Han","Hao","Has","Hay","Haz","Her","Hez","Hin","Hoy","Hoz","Hui","Hum","Huy","Iba","Icho","Ichu","Ice","Ida","Ido","ies","Ion","Ira","Ire","Isa","Iza","Izo","Jai","Jan","Jau","Jea","Jet","Jis","Jur","Lar","Las","Lay","Lea","Led","Lee","Lei","Len","Leo","Les","Lev","Ley","Lia","Lid","Lie","Lio","Lis","Loa","Loe","Loo","Los","Lua","Lue","Lui","Lux","Luz","Llar","Lles","Mach","Mal","Mam","Man","Mar","Mas","Mea","Mee","Meo","Mes","Mia","Mie","Mil","Mio","Mir","Mis","Miz","Moa","Mod","Mol","Mor","Mua","Mue","Mui","Mur","Mus","Muy","Nao","Nas","Nea","Nen","Neo","Nia","Nin","Nis","Non","Nos","Ñas","Ñor","Ños","Ñus","Oas","Obo","Oca","Ocho","Oda","Oes","Off","Ohm","Oia","Oid","Oil","Oir","Ois","Ojo","Ola","Ole","Oli","Olla","Ona","Opa","Ope","Opo","Ora","Ore","Ori","Oro","Osa","Ose","Oso","Oto","Ova","Ove","Ovo","Oxe","Oye","Oyo","Paf","Pal","Pan","Pao","Par","Paz","Pche","Pchs","Pea","Pech","Pee","Pei","Peo","Pes","Pez","Pia","Pie","Pin","Pio","Pis","Ple","Poa","Poch","Pom","Pon","Pop","Por","Pos","Pre","Pro","Psi","Pua","Pub","Pue","Puf","Pum","Pun","Puo","Pus","Put","Que","Qui	","Rad","Rae","Rai","Rap","Ras","Rea","Red","Rei","Reo","Res","Rey","Ria","Rie","Rin","Rio","Roa","Rob","Roe","Roi","Rol","Ron","Roo","Ros","Rua","Ruc","Rue","Run","Ruo","Rus","Sah","Sal","San","Sao","Saz","Sea","Sed","Sel","Sen","Seo","Ser","Ses","Set","Sic","Sij","Sil","Sin","Sis","Siu","Sol","Son","Sor","Sos","Soy","Spa","Sud","Sur","Sus","Tac","Tal","Tan","Tao","Tas","Tau","Taz","Tea","Tell","Ten","Ter","Tes","Tex","Tez","Tia","Tic","Tio","Toa","Toe","Tol","Ton","Too","Top","Tos","Tul","Tun","Tup","Tus","Ube","Ubi","Uce","Uchu","Uci","Ues","Ufa","Ufo","Uju","Una","Une","Uni","Uno","Uña","Uñe","Uñi","Uño","Upa","Upe","Upo","Ura","Uro","Usa","Use","Uso","Uta","Uva","Uve","Uvi","Uzo","Val","Van","Vas","Vea","Ved","Ven","Veo","Ver","Ves","Vez","Via","Vid","Vil","Vio","Vip","Vis","Vos","Voy","Voz","Xis","Yal","Yaz","Yen","Yes","Yin","Yip","Yod","Yos","Zar","Zas","Zen","Zis","Zoo","Zua","Zum"
  };
  int[] numerico = new int[12];
  Random r = new Random();
  for (int u=0;u<numerico.length-1 ;u++ ) {
    numerico[u]=r.nextInt(5);

  }
  numerico[11]=2; //SALVAGUARDA PARA NO GENERAR STACKOVERFLOW
  boolean  shit= false;
  int liminf=0;
  int limsup=potato.length;
  int posicion=0;
  String usuario = "Yod";

//BUSQUEDA LINEAL
  for(int i = 0; i<potato.length; i++) {
    if (potato[i].compareTo(usuario)==0)
    {
      shit = true;
      posicion=i;
    }
  }
    if(shit==true)
    {
    System.out.println("Su palabra esta en la posición"+posicion);

    }



  int respuesta =Comparative(usuario,potato,liminf,limsup);
  System.out.println("Su palabra está en la posicion "+respuesta);

  int respuestanum = ComparativeNum(2,numerico,0,numerico.length);
  System.out.println("El numero 2, si existe, esta en la posicion: "+respuestanum);
  }

//BUSQUEDA BINARIA RECURSIVA
  public static int Comparative(String segundo,String[] buscando, int liminf, int limsup)
  {


      int posmid=(liminf+limsup)/2;
      int opera=segundo.compareTo(buscando[posmid]);
      if(opera==0)
      {
        return posmid;
      }

      else if (opera>0)
      {
        liminf=posmid;
      }
      else if(opera<0)
      {
        limsup=posmid;
      }
      return Comparative(segundo,buscando,liminf,limsup);

  }

//BINARIA RECURSIVA PROBLEMA NUMERICO
  public static int ComparativeNum(Integer num,int[] buscare, int liminf, int limsup)
  {


      int posmid=(liminf+limsup)/2;
      int opera=num.compareTo(buscare[posmid]);
      if(opera==0)
      {
        return posmid;
      }

      else if (opera>0)
      {
        liminf=posmid;
      }
      else if(opera<0)
      {
        limsup=posmid;
      }
      return ComparativeNum(num,buscare,liminf,limsup);

  }



}
