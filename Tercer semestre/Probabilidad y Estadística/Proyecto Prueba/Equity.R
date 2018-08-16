setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba") #Establecemos el directorio de trabajo

equity=c(-8.1,-5.1,-3.1,-1.4,1.2,3.2,4.1,4.6,4.8,5.7,5.9,6.3,7.9,7.9,8.0,8.1,9.2,9.5,9.7,10.3,12.3,13.3,14.0,15.0,22.1)
equity

TablaEquity <- as.data.frame(table( equity = factor(cut(equity, breaks=5))))
TablaEquity
hist(equity, col="pink")
promedio <- mean(equity)
mediana <- median(equity)
moda <- mfv(equity)
varianza <- var(equity)
desviacion <- sqrt(varianza)

c("El promedio es"= promedio)
c(",la mediana es"=mediana)
c(",la moda es"=moda)
c("la varianza es"=varianza)
c(", y la desviación es "=desviacion)
c("El rango es"=range(equity))
