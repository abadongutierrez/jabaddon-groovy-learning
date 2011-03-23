// 'def' es un remplazo para el nombre del tipo.
// Esta es una variable 'definida'
def variable = 1
println("variable = " + variable)
variable = "Hola"
println("variable = " + variable)

// Esta es una variable que al no estar 'definida' va al binding de Groovy
// NOTA: El binding solo exsite para Scripts Groovy
otraVariable = "Hola"
println("otraVariable = " + otraVariable)
otraVariable = 1
println("otraVariable = " + otraVariable)

/*
Los emtodos solo puede acceder a:
- el binding,
- atributos definidos en la clase base,
- propiedades dinamicas definidas por la MetaClass
*/
void imprimeVariable() {
	println("variable = " + variable);
}

void imprimeOtraVariable() {
	println("otraVariable = " + otraVariable);
}

try {
	imprimeVariable()
}
catch (e) {
	println("Hubo un error tratando de imprimir la variable")
}

try {
	imprimeOtraVariable()
}
catch (e) {
	println("Hubo un error tratando de imprimir la otraVariable")
}

class Persona {
	String nombre
	def apellido
	
	def nombreCompleto() {
		def nombreCompleto = nombre + " " + apellido
		nombreCompleto
	}
	
	// Al no estar con 'def' Groovy cree que variable es una propiedad de la clase
	def unMetodoTratandoDeDefinirUnaVariableSinDef() {
		variable = "hola"
		println("decir $variable")
	}
}

def persona = new Persona(nombre: "Rafael", apellido: "Gutierrez")
println("persona = " + persona.nombreCompleto())
persona.unMetodoTratandoDeDefinirUnaVariableSinDef()