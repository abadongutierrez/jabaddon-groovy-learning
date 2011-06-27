/*
 * Ejemplo del uso de .each en varios tipos de objetos en Groovy
 */

/*
 * En cadenas
 */
comillasSimples = 'Comillas simples'
println "La clase de ${comillasSimples} es ${comillasSimples.class}"
comillasSimples.each { println it }
comillasDobles = "Comillas dobles"
println "La clase de ${comillasDobles} es ${comillasDobles.class}"
comillasDobles.each { println it }

/*
 * En listas, mapas y arreglos
 */
map = [uno: "uno", dos: "dos", tres: "tres"]
map.each { println it }

array = [1, 2, 3, 4, 5]
array.each { println it }

list = ["uno", 1, "dos", 2, "tres", 3] as List
list.each { println it }

/*
 * Con objetos simples
 */
class Persona {
    String nombre
    String apellido
    Long edad

    String toString() {
        "{${nombre}, ${apellido}, ${edad}}"
    }
}

p = new Persona(nombre: "Rafael", apellido: "Gutierrez", edad: 32)
p.each { println it }