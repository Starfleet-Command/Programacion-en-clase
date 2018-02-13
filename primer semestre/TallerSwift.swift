import UIKit

var str = "Hello, playground"

var myVariable = 42

myVariable = 50

let segundavariable = 34

let apples = 3
let oranges = 5

let appleSummary = "yo tengo \(apples+oranges) manzanas"

var animales = "perro,gato,pez"
animales[1]

var arreglovacio = [String]()

var votos = [

"PAN":4,
"PRI":3,
"PRD":1]

votos["PAN"]

var lista = [1,2,3,4,5,6,7,8]
for x in lista {
  x
}

switch apples {
case 1:
  print("Hola")
case 2:
  print("Adios")
default:
  print("Test")
}

func saludar (nombre: String) -> String {
return "Hola \(nombre)"
}

print(saludar(nombre: "Gerardo"))
