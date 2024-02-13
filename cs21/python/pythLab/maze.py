# Alyssa Mae King Ngo
# 153023
# September 29, 2016

"""
I hereby attest to the truth of the following facts:

I have not discussed the Python language code in my program with anyone other than my instructor or 
the teaching assistants assigned to this course.

I have not used Python language code obtained from another student, or any other unauthorized source, 
either modified or unmodified.

If any Python language code or documentation used in my program was obtained from another source, 
such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
"""

def mazeSize(num):
    multi = num + 2
    return multi

def mazeFunction(size):
    room = maze * (size ** 2)
    return room

def paths(player):
    if len(newMaze) == 9:
        newMaze[:] = ['East', 'West East South', 'West', 
        'South', 'North East', 'West South', 
        'North East', 'West East', 'North West']
    elif len(newMaze) == 16: 
        newMaze[:] = ['East', 'West East South', 'West East', 'West', 
        'East South', 'North West East', 'West East', 'West South', 
        'North South', 'East', 'West South', 'North South', 
        'North East', 'West East', 'North West East', 'North West']
    elif len(newMaze) == 25: 
        newMaze[:] = ['East South', 'West East South', 'West East', 'West South', 'South', 
        'North South', 'North', 'South', 'North South', 'North West',
        'North East', 'West South', 'North East', 'North West East', 'West South'
        'East', 'North West East South', 'West South', 'East', 'North West South',
        'East', 'North West', 'North East', 'West East', 'North West']

    return newMaze[player]
    
print('Welcome to the Maze!')
print('Select a level: 1, 2, or 3')
lvl = int(input()) 
# gets the level difficulty of the game

maze = [' ']
loc = int(input('Starting point: ')) 
# get the player's starting pt. in the chosen maze

mult = mazeSize(lvl) 
# calls mazeSize which determines the length of sides of the maze, and the north and south increments of the maze
# mult gets the argument lvl, then adds 2 to it 

newMaze = mazeFunction(mult)
# calls mazeFunction which provides the dimensions of the maze 

exitSpace = int(input('Exit location: '))
# gets the exit point of the maze desired by player
#(len(mazeFunction(mult))) - 1

ans = ''
# created the variable ans to prepare the while loop

while loc != exitSpace and ans != 'quit': 
    print('Available Directions: ' + paths(loc))
    print('Which direction will you take?')
    ans = raw_input()
    # program will check in the available directions
    # which are stored in the function paths
    # which contains the mutated newMaze 
    # which stores the available directions for each difficulty of the game
    
    checkr = ans.lower() in paths(loc).lower()
    # this makes the input and available paths case-insensitive 
    # and finds if ans is available in the given directions

    if checkr == False and ans != 'quit': 
        print('Please choose an available direction.')
        continue
    # this is to tell the player to type in the available direction
    # this skips the further processes as well
    # since the input was not in the choices anyway
    
    # Thanks to this link for showing me how to make string conditions ignore case. 
    # http://stackoverflow.com/questions/319426/how-do-i-do-a-case-insensitive-string-comparison-in-python

    elif ans.lower() == 'north': 
        loc = loc - mult
    elif ans.lower() == 'south':
        loc = loc + mult
    # north and south choices rely on mult 

    elif ans.lower() == 'east':
        loc = loc + 1
    elif ans.lower() == 'west':
        loc = loc - 1

if ans == 'quit': 
    print('Try again next time.')

if loc == exitSpace: 
    print('Found the exit!')
    
print('Goodbye.')


