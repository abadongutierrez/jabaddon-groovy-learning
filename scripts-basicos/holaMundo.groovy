// Las cadenas pueden ser con comillas simples o comillas dobles
println 'Hola Mundo!'
println "Hola Mundo!"

def strHola = "Hola"
def strMundo = "Mundo"

// Las cadenas con comillas dobles nos permiten hacer uso de variables asi:
println "$strHola $strMundo!"

// Las cadenas con comillas simples NO permiten hacer uso de variables
println '$strHola $strMundo!'

// ${ codigo-groovy }
println "${strHola + ' ' + strMundo}!"
