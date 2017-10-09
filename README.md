# GameApp

# Step 1

Launch the application via GameLauncher Class.

# Step 2

#Provide the below as command line inputs.

#Example 1

PLACE 0,0,NORTH

MOVE

REPORT

Output: 0,1,NORTH

#Example 2

PLACE 0,0,NORTH

LEFT

REPORT

Output: 0,0,WEST

#Example 3

PLACE 1,2,EAST

MOVE

MOVE

LEFT

MOVE

REPORT

Output: 3,3,NORTH

#Example 4

PLACE 0,9,NORTH

Output: Invalid Input Coordinates. Resetting latitute,longitude to (0,0,NORTH)

#Example 5

PLACE 0,4,NORTH

MOVE

Output: Falling out of coordinates.

#Example 6

PLACE 4,0,NORTH

MOVE

Output: Falling out of coordinates.
