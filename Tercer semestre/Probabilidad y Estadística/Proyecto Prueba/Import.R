setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba")

datos <- read.csv("Datos4.csv", header = TRUE,sep=",")
datos
Inc <- c(datos$Hours)
typeof(Inc)
histograma1 <- hist(Inc,col="pink",main = "Histograma1", breaks= c(0,2,4,6,8,10,12,14,16,18,20))

min(Inc)
max(Inc)
histograma2= hist(Inc, breaks=5,main= "Histograma 2",col="cyan")
install("agricolae")
library("agricolae")
Tabla1 <- table.frec(histograma1)
Tabla1
promedio <- mean(Inc)
mediana <- median(Inc)
varianza <- var(Inc)
desviacion <- sqrt(Inc)
library("modeest")
moda <- mfv(Inc)
Medidas <- c("media"=promedio , "mediana"= mediana , "Moda"=moda, "Varianza"=varianza,"Desviacion"=desviacion)

