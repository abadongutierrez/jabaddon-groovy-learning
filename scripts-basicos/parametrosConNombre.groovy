// Ejemplo tomado como tal del libro "Programming Groovy"
class Robot {
  def type, height, width

  def access(location, weight, fragile) {
    println "Received fragile? $fragile, weight: $weight, loc: $location"
  }
}
robot = new Robot(type: 'arm' , width: 10, height: 40)
println "$robot.type, $robot.height, $robot.width"

// Groovy si detecta que el numero argumentos que recibe el metodo son mayores de los declarados y los argumentos
// de mas son parametros con nombre, Groovy asume que el primer parametro (en este caso location) del metodo
// es un Mapa y todos los argumentos con nombre los agrupa y se los asigna al Mapa (en este caso x, y y z) y
// despues asigna los demas argumentos en el orden en que se presentan 
robot.access(50, x: 30, y: 20, z: 10, true)
robot.access(x: 30, y: 20, z: 10, 50, true)
