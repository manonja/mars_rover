# mars_rover

### The Problem
Write a program which takes in commands and moves one or more robots around
Mars. Program writen in Scala. 

#### Requirements:
- The world should be modelled as a grid with size m x n
- Your program should read the input, update the robots, and print out the final states of
the robots
- Each robot has a position (x, y), and an orientation (N, E, S, W)
- Each robot can move forward one space (F), rotate left by 90 degrees (L), or rotate
right by 90 degrees (R)
- If a robot moves off the grid, it is marked as ‘lost’ and its last valid grid position and
orientation is recorded
- Going from x -> x + 1 is in the easterly direction, and y -> y + 1 is in the northerly
direction. i.e. (0, 0) represents the south-west corner of the grid

#### Examples:
The input takes the form:
4 8
(0, 2, N) FFLFRFF
(2, 3, E) LFRFF

The first line of the input ‘4 8’ specifies the size of the grid. The subsequent lines each represent
the initial state and commands for a single robot. (0, 2, N) specifies the initial state of the form
(x, y, orientation). FFLFRFF represents the sequence of movement commands for the robot.

The output should take the form:
(1, 2, N)
(3, 4, W) LOST

Where each line represents the final position and orientation of the robots of the form (x, y,
orientation) and optionally whether the robot was lost. NB. This output is an example and does
not correspond to the example input shown above.

As an example, for the input:
4 8
(2, 3, N) FLLFR
(1, 0, S) FFRLF

The output would be:
(2, 3, W)
(1, 0, S) LOST

### Quick Start
- Clone the project in a new directory
- `sbt run`

For mac users, make sure to have sbt installed: `brew install sbt`

### Possible Improvements
- Takes input from the console 
- Combine HandleMoveX() and HandleMoveY() into one function


