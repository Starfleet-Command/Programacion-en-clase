from math import *

ecuacion= input("Write f(x)")

print("1. Newton Raphson")
print("2. Bisection")
print("3. False Position")
print("4. Secant")

valor=input("Select the number of the method you want to use: ")

tolerancia =input("Write the tolerance (in decimal notation): ")



if int(valor)==1:
    ecuacionder = input("Write the derivative of f(x): ")

elif int(valor)==2:
    x0 =input("Write x0: ")
    print(ecuacion)
    x1 =input("Write x1: ")



def f(x):

    return (x**2 - 7)

def bisection_method(a, b, tol):
    if f(a)*f(b) > 0:
        #end function, no root.
        print("No root found.")
    else:
        while (b - a)/2.0 > tol:
            midpoint = (a + b)/2.0
            if f(midpoint) == 0:
                return(midpoint) #The midpoint is the x-intercept/root.
            elif f(a)*f(midpoint) < 0: # Increasing but below 0 case
                b = midpoint
            else:
                a = midpoint

        return(midpoint)

x=bisection_method(-1,5,0.0001)
print(x)
