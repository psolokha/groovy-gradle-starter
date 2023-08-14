import static org.example.Utils.printer

def textLine = "this is some interesting text here"

def match = "groovy" =~ "o"
printer match?match[0]:"Nothing"

def regex = /\w+ \d+/
def singleString = "four 4444"
def string = "one 1 two 22 three 333"

def pattern = ~regex //чтоб создать паттерн, если нужно
def singleStringMatcher = singleString ==~regex // строка соотвутствует паттерну в regex
printer(singleStringMatcher)

def regex1 = /(\w+) (\d+)/
def matcher = string =~ regex1

println matcher
println matcher[0]
println matcher[1]
println matcher[2]
println matcher[1][0]
println matcher[1..2]
matcher.each {group -> printer(group)}
