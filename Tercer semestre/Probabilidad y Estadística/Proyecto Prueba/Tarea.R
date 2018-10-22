setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba")
Ventas <- c(11,11,11,11,15,16,17,17,17,18,19,19,20,21,22,23,24,26,28,34)
Ventas
histograma1 <- hist(Ventas,col="pink",main = "Ejercicio 1", breaks=5)

polygon.freq(histograma1,frequency = 1)
ogive.freq(histograma1,x="valor",y="frecuencia acumulada")

Ejercicio2 <- c(2158,265,310,546,1872,506,1253,950,1078,1084,501,668,1687,1046,1624,1897,2030,1602,4254,4651,4110,4986,4681,5771,955,1537,322,30,1360,806,1120,1106,996,619,634,1001,1311,1918,1416,1895,1415,1678,5587,5701,6196,6228,4186,5757,138,120,934,2352,1050,373,829,1179,736,1113,872,447,1236,2033,1053,1777,1586,2302,5514,6092,5478,6174,4866,5031)
Mediana <- median(Ejercicio2)
Mediana
Media <- mean(Ejercicio2)
Media
Varianza <- var(Ejercicio2)
Varianza
StDev <- sqrt(Varianza)
StDev
Rango <- max(Ejercicio2)-min(Ejercicio2)
Rango
library(FinCal)
CoefVariacion <- coefficient.variation(StDev,Media)
CoefVariacion

library(modeest)
Ejercicio5 <- c(13, 0, -6, 2, 13, 4, 8)
media5 <- mean(Ejercicio5)
mediana5 <- median(Ejercicio5)
moda5 <- mfv(Ejercicio5)

Ejercicio6 <- c(2, 5, 10, 12, 4, 4, 5, 17, 11, 8, 9, 8, 12, 21, 6, 8, 7, 13, 18, 3)
histogramaEj6 <- hist(Ejercicio6)
TablaEj6 <- table.freq(histogramaEj6)
TablaEj6

