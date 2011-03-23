// La propiedad "edad" de la Persona es inmutable y mandara error si se trata de cambiar
class Persona {
    def nombre
    def apellido
    final edad = 50
}

// Si se manda la edad en el constructor tambien mandaria error
persona = new Persona(nombre: "Bill", apellido: "Gates")
println persona.nombre
println persona.apellido
println persona.edad

println "Se puede editar el nombre?"
persona.nombre = "Steve"
println "Si, el nombre es $persona.nombre"

try {
    println "Se puede editar la edad?"
    persona.edad = 51
}
catch (groovy.lang.ReadOnlyPropertyException ex) {
    println "No se puede: $ex.message"
}
