#include "FaceDetector.h"
using namespace cv;
using namespace std;

FaceDetector::FaceDetector(std::string face_cascade_name, int next_height_)
{
        face_cascade.load(face_cascade_name);
        next_height = next_height_;
}

FaceDetector::FaceDetector()
{
        face_cascade.load("/usr/local/Cellar/opencv/4.0.1/share/opencv4/haarcascades/haarcascade_frontalface_alt.xml"); //Hay que hacer esto genericamente
        next_height = 40;

}



//# funcion detectar
vector<Rect> FaceDetector::nextFrame( Mat frame )
{
        //declarar nueva matriz para grises

        vector<Rect> faces;
        Mat frame_gray;

        if(face_cascade.empty())
        {
                cout << "No se encontraron los datos de referencia para Cascade";
        }
        if(frame.empty())
        {
                cout << "Se ha terminado el stream de video";
        }

        //convertir la matriz a una matriz de escala de grises
        cvtColor( frame, frame_gray, COLOR_BGR2GRAY );
        //
        // equalizeHist( frame_gray, frame_gray );

        //@ si la cara es menor a 40px se asignan 40px
        if(next_height < 40)
        {
                next_height = 40;
        }

        //Detectar caras (∆)
        face_cascade.detectMultiScale( frame_gray, faces, 1.1, 4, 0, Size(next_height, next_height) );

        //@ for para remarcar cada cara detectada y guardada en el arreglo
        for( size_t i = 0; i < faces.size(); i++ )
        {

                if(i == 0)
                {
                        next_height = faces[0].height;
                }

                //@ encuentra la cara mas pequeña existente
                if((next_height > faces[i].height) && (i > 0))
                {
                        next_height = faces[i].height;
                }

                //obtener el 80% del tamaño de la imagen
                next_height = next_height * 0.8;
        }

        return faces;
        //    //mostrar video en vivo con lo que se obtuvo
        //    imshow( window_name, frame );
}

/*
   ∆ = Se detectan las caras existentes en la matriz en escala de grises y las guarda en el
   arreglo de faces, para esto revisa la cara con un cuadro que va incrementando en 1.1 veces
   su tamaño y busca por caras 4 veces pro frame para tener mayor exactitud, para revisar la
   imagen se hacen matrices del 80% del tamaño de la cara mas pequeña detectada en el ultimo
   frame, si no se han detectado caras se revisa por un tamaño de 40x40 recorriendo ese valor
   por los cuadros existentes en la imagen.
 */
