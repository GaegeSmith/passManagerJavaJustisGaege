from useful import *

Terminal.clear()


lets = Strings.lets('a','z') + Strings.lets('A','Z') + Strings.lets('0', '9') + ["!", "@", "#", "$", "%", "^", "&", "(", ")"]

def createCipher():
    letGrid = Grid.create(len(lets), len(lets))
    counter = 0
    for row in range(len(letGrid)):
        counter = row % len(letGrid)

        for col in range(len(letGrid[row])):
            letGrid[row][col] = lets[(counter + col) % len(letGrid)]
    
    print(Grid.build(letGrid))

