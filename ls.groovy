/*
 * Ejemplo de la ejecucion de un comando del sistema operativo y como mostrar en pantalla su resultado
 */
def command = "ls -l"
def proc = command.execute()
print "${proc.in.text}"
