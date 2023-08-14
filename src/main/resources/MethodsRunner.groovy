
def prHello() {
    println("Hello!")
    return "Hello!"
}

def printer = { text -> println "$text"}

printer("line1...")

static def myMethod(someVar) {
    someVar.call("Groovy")
}

myMethod(printer)

def sum = {
    a,b,c -> return (a+b+c)
}

printer(sum("god","bless","Groovy"))

def list1 = [4,3,5,7,8]

printer(list1.findAll(it -> it > 4))
printer(list1.collect(it -> it + 1))