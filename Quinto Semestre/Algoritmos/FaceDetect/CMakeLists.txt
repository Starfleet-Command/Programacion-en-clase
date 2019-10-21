#
# This is a CMake makefile.  You can find the cmake utility and
# information about it at http://www.cmake.org
#

cmake_minimum_required (VERSION 3.1)
project(fr)

set (CMAKE_CXX_STANDARD 11)

 set(SOURCE 	faceDetector.cpp
    )

 set(HEADERS	FaceDetector.h
    )

# automatic OpenCV finding
#find_package(OpenCV REQUIRED)

# if not, use manual specification of the OpenCVConfig.cmake path
# and comment previous line of automatic finding
find_package(OpenCV REQUIRED PATHS D:/OpenCV/opencv/user_build NO_DEFAULT_PATH)


# si encontró bien la opencv, debe mostrarte estos mensajes sin problema
# puedes chequear luego lo que está dentro de cada carpeta que se imprime
message(STATUS "OpenCV library status:")
message(STATUS "    config: ${OpenCV_DIR}")
message(STATUS "    version: ${OpenCV_VERSION}")
message(STATUS "    libraries: ${OpenCV_LIBS}")
message(STATUS "    include path: ${OpenCV_INCLUDE_DIRS}")


if(OpenCV_FOUND)
	message("-- Opencv Found")
endif()


set(fr_include 	${OpenCV_INCLUDE_DIRS}
	)
include_directories(${fr_include})

# Esto no necesitan hacerlo, dado que esto se configura dentro de la funcion find_packages
# set(fr_libraries 	D:/OpenCV/opencv/user_build/install/x86/vc15/lib D:/OpenCV/opencv/user_build/lib/Release)
# link_directories(${fr_libraries})
#


add_executable(fr main.cpp ${SOURCE} ${HEADERS})


target_link_libraries(fr ${OpenCV_LIBS})
