@Grab(group='net.sf.json-lib', module='json-lib', version='2.3')
import net.sf.json.JSONObject
import net.sf.json.groovy.JsonSlurper

def extractFileNameFromArgument(argName, text) {
	return text.substring(argName.length(), text.length())
}

def readFileNCreateJsonObject(fileName) {
    text = new File(fileName).text

    try {
        return new JsonSlurper().parseText(text)
    }
    catch (net.sf.json.JSONException ex) {
    	throw new Exception("ERROR: Hubo un error con el JSON del archivo [${fromFile}] [${ex.getMessage()}]", ex)
    }	
}

file = null
println("Args:" + this.args)
this.args.each {
	if (it.startsWith("-Dfile=")) {
		file = extractFileNameFromArgument("-Dfile=", it)
	}
}

if (file == null) {
	println("Usage: groovy JsonFormatter.groovy -Dfile=<json-file>")
	return
}

json = readFileNCreateJsonObject(file)

new File('jsonFormatted.json').text = json.toString(4)

