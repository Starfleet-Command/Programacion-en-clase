setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba")
datoexamen <- read.csv("Datos Examen 1.csv", header = TRUE,sep=";")
inclusion <- c(datoexamen$A01021926)
inclusion
library(modeest)
library(agricolae)
histoexamen <- hist(inclusion)
tablaexamen <- table.freq(histoexamen)
tablaexamen
mediaexamen <- mean(inclusion)
medianaexamen <- median(inclusion)
modaexamen <- mfv(inclusion)
varianzaexamen <- var(inclusion)
desviacionexamen <- sqrt(varianzaexamen)
mediaexamen
medianaexamen
modaexamen
varianzaexamen
desviacionexamen
cuantilexamen50 <- quantile(inclusion,0.50)
cuantilexamen50
cuantilexamen65 <- quantile(inclusion,0.65)
cuantilexamen65
