def mensajeOriginal = "Este es mi mensaje original, programado con Groovy"
def strBuilder = new StringBuilder();

for (c in mensajeOriginal.toCharArray()) {
	print c
}

println ""

mensajeOriginal.length().times {
	print "."
}
