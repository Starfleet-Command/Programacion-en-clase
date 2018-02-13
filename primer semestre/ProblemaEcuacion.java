mport java.util.Scanner;
public class ProblemaEcuacion
    {
        public static void main(String[] args)
        {


        Scanner lector = new Scanner(System.in);

        System.out.println("Cuántas ecuaciones tienes para resolver? (Presiona 2 para dos ecuaciones y 3 para tres ecuaciones");

        int grado = lector.nextInt();

        if (grado==2)
        {
            int[][] xa =new int[2][2]; int [][] yxb = new int [2][2]; int[][] ya =new int[2][2];


            System.out.println("Primer ecuación"); System.out.println("Coeficiente x: "); ya [0][0] = lector.nextInt(); System.out.println("Coeficiente y: ");
            xa [0][1]= lector.nextInt(); System.out.println("Resultado: "); xa [0][0]= lector.nextInt();

            System.out.println("Segunda ecuación "); System.out.println("Coeficiente x: "); ya [1][0]= lector.nextInt(); System.out.println("Coeficiente y: ");
            xa [1][1]= lector.nextInt(); System.out.println("Resultado: "); xa [1][0]= lector.nextInt();

            yxb [0][0]= ya [0][0]; yxb [0][1]= xa [0][1]; yxb [1][0]= ya [1][0]; yxb [1][1]= xa [1][1];

            ya [0][1]=  xa [0][0]; ya [1][1]= xa [1][0];

            System.out.println("");

            double rx= ((ya [0][1]*xa [1][1])-(xa [0][1]*xa [1][0]))/((ya [0][0]*xa [1][1])-(xa [0][1]*ya [1][0]));
            System.out.println("X: "+rx  );

            double ry= ((ya [0][0]*xa [1][0])-(xa [0][0]*ya [1][0]))/((ya [0][0]*xa [1][1])-(xa [0][1]*ya [1][0]));
            System.out.println("Y: "+ry);

        }
                else

        {

            int[][] xa= new int[3][3]; int[][] ya= new int[3][3]; int[][] za= new int[3][3]; int[][] zyxb= new int[3][3];


            System.out.println("Primer ecuación"); System.out.println("Coeficiente x: "); ya[0][0]= lector.nextInt();
            System.out.println("Coeficiente y: "); xa[0][1]= lector.nextInt(); System.out.println("Coeficiente z: "); xa[0][2]= lector.nextInt();
            System.out.println("Resultado; "); xa[0][0]= lector.nextInt();

            System.out.println("Segunda ecuación"); System.out.println("Coeficiente x: "); ya[1][0]= lector.nextInt(); System.out.println("Coeficiente y: "); xa[1][1]= lector.nextInt();
            System.out.println("Coeficiente z: "); xa[1][2]= lector.nextInt(); System.out.println("Resultado: "); xa[1][0]= lector.nextInt();


            System.out.println("Tercer ecuacion "); System.out.println("Coeficiente x: "); ya[2][0]= lector.nextInt(); System.out.println("Coeficiente y: "); xa[2][1]= lector.nextInt(); System.out.println("Coeficiente z: ");
            xa[2][2]= lector.nextInt(); System.out.println("Resultado: "); xa[2][0]= lector.nextInt();



            ya[0][1]=xa[0][0]; ya[0][2]=xa[0][2]; ya[1][1]=xa[1][0]; ya[1][2]=xa[1][2]; ya[2][1]=xa[2][0]; ya[2][2]=xa[2][2];


            za[0][0]=ya[0][0]; za[0][1]=xa[0][1]; za[0][2]=xa[0][0]; za[1][0]=ya[1][0]; za[1][1]=xa[1][1]; za[1][2]=xa[1][0]; za[2][0]=ya[2][0]; za[2][1]=xa[2][1]; za[2][2]=xa[2][0];


            zyxb[0][0]=ya[0][0]; zyxb[0][1]=xa[0][1]; zyxb[0][2]=xa[0][2]; zyxb[1][0]=ya[1][0]; zyxb[1][1]=xa[1][1]; zyxb[1][2]=xa[1][2]; zyxb[2][0]=ya[2][0]; zyxb[2][1]=xa[2][1]; zyxb[2][2]=xa[2][2];

            System.out.println("");

            double rx= ((xa[0][0]*xa[1][1]*xa[2][2])+(xa[0][1]*xa[1][2]*xa[2][0])+(xa[1][0]*xa[2][1]*xa[0][2])-(xa[1][1]*xa[0][2]*xa[2][0])-(xa[0][1]*xa[1][0]*xa[2][2])-(xa[1][2]*xa[2][1]*xa[0][0]))/((ya[0][0]*xa[1][1]*xa[2][2])+(xa[0][1]*xa[1][2]*ya[2][0])+(ya[1][0]*xa[2][1]*xa[0][2])-(xa[0][2]*xa[1][1]*ya[2][0])-(xa[0][1]*ya[1][0]*xa[2][2])-(xa[1][2]*xa[2][1]*ya[0][0]));
            System.out.println("X: "+rx);

            double ry=((ya[0][0]*xa[1][0]*xa[2][2])+(xa[0][0]*xa[1][2]*ya[2][0])+(ya[1][0]*xa[2][0]*xa[0][2])-(xa[1][0]*xa[0][2]*ya[2][0])-(xa[0][0]*ya[1][0]*xa[2][2])-(xa[1][2]*ya[0][0]*xa[2][0]))/((ya[0][0]*xa[1][1]*xa[2][2])+(xa[0][1]*xa[1][2]*ya[2][0])+(ya[1][0]*xa[2][1]*xa[0][2])-(xa[0][2]*xa[1][1]*ya[2][0])-(xa[0][1]*ya[1][0]*xa[2][2])-(xa[1][2]*xa[2][1]*ya[0][0]));
            System.out.println("Y: " +ry);

            double rz=((ya[0][0]*xa[1][1]*xa[2][0])+(ya[0][0]*xa[1][0]*ya[2][0])+(ya[1][0]*xa[2][1]*xa[0][0])-(xa[1][1]*xa[0][0]*ya[2][0])-(xa[0][1]*ya[1][0]*xa[2][0])-(xa[1][0]*ya[0][0]*xa[2][0]))/((ya[0][0]*xa[1][1]*xa[2][2])+(xa[0][1]*xa[1][2]*ya[2][0])+(ya[1][0]*xa[2][1]*xa[0][2])-(xa[0][2]*xa[1][1]*ya[2][0])-(xa[0][1]*ya[1][0]*xa[2][2])-(xa[1][2]*xa[2][1]*ya[0][0]));
            System.out.println("Z: "+rz);
        }


    }

}
