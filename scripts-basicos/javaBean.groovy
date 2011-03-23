// def declara una propiedad en una clase, haciendo que en la clase existan metodos getters y setters
class Persona {
    def nombre
    def apellido
}

// Existe un constructor que recibe un mapa con las propiedades
persona = new Persona(nombre: "John", apellido: "Smith")

println persona.nombre
println persona.apellido
println persona.getNombre()
println persona.getApellido()

persona.nombre = "John2"
persona.apellido = "Smith2"
println persona.getNombre()
println persona.getApellido()

persona.setNombre("John3")
persona.setApellido("Smith3")
println persona.nombre
println persona.apellido

