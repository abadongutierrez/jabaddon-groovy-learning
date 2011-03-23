// Recibe x y y tiene un valor default
def multiplicar(x, y = 1) {
    x * y
}

// En este caso el segundo parametro al ser un arreglo puede tener o no valores a la hora de llamar el metodo
def mensaje(numero, String[] contenido) {
    println "$numero - $contenido"
}

println multiplicar(2)
println multiplicar(2, 2)
println multiplicar(2, 3)

mensaje(1)
mensaje(2, "Este es un", "mensaje")
mensaje 3, "Este es un", "mensaje", "mucho", "mas largo"
