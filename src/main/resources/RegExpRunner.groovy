import static org.example.Utils.printer

def textLine = "this is some interesting text here"

def match = "groovy" =~ "o"
printer match?match[0]:"Nothing"
