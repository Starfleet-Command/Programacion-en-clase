setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba") #Establecemos el directorio de trabajo




horas <- c(15,       #construimos una variable que contenga nuestros datos
           23.7,
           19.7,
           15.4,
           18.3,
           23,
           14.2,
           20.8,
           13.5,
           20.7,
           17.4,
           18.6,
           12.9,
           20.3,
           13.7,
           21.4,
           18.3,
           29.8,
           17.1,
           18.9,
           10.3,
           26.1,
           15.7,
           14,
           17.8,
           33.8,
           23.2,
           12.9,
           27.1,
           16.6)
horas   
Tablahoras <- as.data.frame(table( horas = factor(cut(horas, breaks=5)))) #contruimos una tabla de frecuencias de 5 clases con nuestros dato 
Tablahoras  # le pedimos que nos muestre la tabla de frecuencias
hist(horas, main = "Sam", col = "pink")
promedio <- mean(horas)
mediana <- median(horas)
moda <- mode(horas)
varianza <- var(horas)
desviacion <- sqrt(varianza)
Medidas <- c("mediana"=mediana,"promedio"=promedio,"moda"=moda)
