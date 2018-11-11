# Intervalo de confianza para la media poblacional 
setwd("C:/Users/L01104232/Documents/R")
datos <- read.csv("Ejemplo2.csv", header = TRUE,sep=";")
datos
muestra <- c(datos$INCTOT)
n <- length(muestra)
media <- round(mean(muestra,2))
varianza <- var(muestra)
Desviación <- round(sqrt(varianza),2)
confianza = 0.95
significancia = 1 - confianza 
z<-qnorm(significancia/2, mean = 0, sd = 1, lower.tail = FALSE)
errorst<- round(z*Desviación/sqrt(n),2)
intervalo <-c("Intervalo de confianza del",confianza,"para la media",media-errorst,media+errorst)
print(intervalo)