setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba")

bola <- 1:6
lanz = function(y){ y <- sample(bola, 3 , replace = FALSE) }
suma = 0
contador=0
for (i in 1:10000) { a <- lanz(y)
suma[i] <- lanz(bola)

}
length(suma)
x <- table(suma)
x
fdp <- x/length(suma)
fdp
histograma <- hist(suma, breaks =c(0,1,2,3), main = "Distribucion de Probabilidad ", col="pink")
media <- mean(suma)
Varianza <- var(suma)
media
Varianza
contador