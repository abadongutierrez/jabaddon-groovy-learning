/*
 * Ejemplo de como listar los directorios y archivos de un folder
 */
def file = new File('.')
file.eachFile {
    println it.isDirectory() ? "directory: -> ${it.name}" : 
                               "file:      -> ${it.name}"
}
