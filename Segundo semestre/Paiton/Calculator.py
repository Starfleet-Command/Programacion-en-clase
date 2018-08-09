

num1 = input("Escriba el primer numero: ")
operacion = input("Escriba la operacion que quiere realizar ")
num2 = input("Escriba el segundo numero: ")


def Suma(sumando,sumando2):
    return float(sumando)+float(sumando2)

def Resta(original,restando):
    return float(original)-float(restando)

def Division(original,dividendo):
    return float(original)/float(dividendo)

def Multiplicacion(num1,num2):
    return float(num1)*float(num2)

if operacion.lower()=="suma":
     placeholder = Suma(num1,num2)
     print (placeholder)

elif operacion.lower()=="resta":
     placeholder = Resta(num1,num2)
     print (placeholder)

elif operacion.lower()=="multiplicacion":
     placeholder = Multiplicacion(num1,num2)
     print (placeholder)

elif operacion.lower()=="division":
     placeholder = Division(num1,num2)
     print (placeholder)
