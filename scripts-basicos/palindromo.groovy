// Se modifica el metaClass para agregar un closure llamado "esPalindromo" que no recibe argumentos
// "delegate" es la instancia de la variable
String.metaClass.esPalindromo = {
	->
	delegate == delegate.reverse()
}

palabra = "afafa"
println "$palabra es un palindromo? ${palabra.esPalindromo()}"
palabra = "Groovy"
println "$palabra es un palindromo? ${palabra.esPalindromo()}"