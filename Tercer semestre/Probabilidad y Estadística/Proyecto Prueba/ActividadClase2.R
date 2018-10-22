setwd("C:/Users/Juan Fco/Desktop/Programacion/Tercer Semestre/Probabilidad y Estadística/Proyecto Prueba")
Salario <- c(2038,1758,1721,1637,2097,2047,2205,1787,2287,1940,2311,2054,2406,1471,1460)
Salario
percentil_30 <- quantile(Salario,0.3);percentil_30
mediana <- quantile(Salario,0.5);mediana
percentil_25_50_75 <- quantile(Salario,c(0.25,0.50,0.75))
percentil_25_50_75