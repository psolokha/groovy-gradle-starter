import static org.example.Utils.printer

def list = [1, 4.4, "data", ['f', 't', 'j'], 5f]

printer(list.get(3).get(1))
printer(list[4..0])
printer(list.contains('t'))
printer(list<<50)
printer(list - "data")



def employee = [
        "name" : "Pavel",
        "surname" : "Solokha",
        "age" : 37
]

printer(employee.age)

employee.put("city", "Voskresensk")

printer employee.city

employee.eachWithIndex {k,v, i -> printer("$i | $k : $v")}



def rangeInclusive = 1..10
def rangeExclusive = 1..<10

printer rangeInclusive
printer rangeExclusive

assert rangeExclusive.getFrom() == 1
assert rangeExclusive.getTo() == 9

rangeInclusive.each {i -> printer("value = $i")}
