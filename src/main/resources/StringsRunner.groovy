
def name = "Pasha"

println "my name is $name"
println 'my name is $name'
println name[-2]
println name.indexOf('s')
println name[1..name.length()-1]

def string1 = """This
is
what 
i
mean"""

println string1-("what")

println name * 3

def getWithPrefix(String line) {
    "prefix-" + line
}

println "this text with prefix word: ${getWithPrefix(name)}"
def str = /^'regex\"$/
println str