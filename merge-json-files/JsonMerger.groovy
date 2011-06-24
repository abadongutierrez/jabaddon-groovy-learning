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

def createNamesArrayFromJsonsKeys(jsonTo, jsonFrom) {
	array = [] as TreeSet
    jsonTo.keySet().each {
    	array.add(it)
    }
    jsonFrom.keySet().each {
    	array.add(it)
    }
    return array
}

fromFile = null
toFile = null
println("Args:" + this.args)
this.args.each {
	if (it.startsWith("-Dfrom=")) {
		fromFile = extractFileNameFromArgument("-Dfrom=", it)
	}

	if (it.startsWith("-Dto=")) {
		toFile = extractFileNameFromArgument("-Dto=", it)
	} 
}

if (fromFile == null || toFile == null) {
	println("Usage: groovy JsonMerger.groovy -Dfrom=<json-from-file> -Dto=<json-to-file>")
	return
}
else {
	println("From: [${fromFile}], to: [${toFile}] ")
}

jsonFrom = readFileNCreateJsonObject(fromFile)
jsonTo = readFileNCreateJsonObject(toFile)

namesArray = createNamesArrayFromJsonsKeys(jsonTo, jsonFrom)

json = new JSONObject()
namesArray.each {
	if (jsonFrom.containsKey(it)) {
		json.put(it, jsonFrom.get(it))
	}
	else {
		json.put(it, jsonTo.get(it))
	}
}

new File('jsonFinal.json').text = json.toString(4)