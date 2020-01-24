# Game Design
## NAME
Andrew Krier

Role: Design and implementation. Some framework borrowed from Robert Duvall's lab_bounce

### Description

This game is a two player defensive variant of Breakout where each player is protecting a side of the screen. Each 
player has two paddles that they control with the same keys, one anchored to the side they are defending, and one floating
in the player's half of the screen. The player is protecting their bricks that have varying durability, and if the ball 
passes by the baseline they are defending, each of their bricks take damage. The player to lose all of their bricks
loses the round, there are three total rounds with different brick patterns. 

### Design Flow

The primary runner of this program is the InitialScreen class, this initializes and manages the screen for the user, 
keeps track of player wins, calls the updates for all the objects onscreen and handles all the user input from the keys 
pressed. This class also monitors whether a player has run out of blocks and will then advance to the next level.

Two vital classes inherit from the Rectangle class, the Bouncer and Block classes. The Bouncer class manages the 
paddles a player can control in the game this is primarily in handling key inputs and distributing them to the 
appropriate team since collisions with the ball is handled in the Ball class. The Block class manages each Block's 
durability status, which in turn updates its displayed color according to a color array. Each Block's location is also 
controlled here, but this is contained within the constructor since the Blocks don't move. Individual Blocks maintain 
their own collision detection with the ball since it can update the durability internally without the ball needing to 
update every one.

The Ball class extends a Circle class that manages the Ball's Block collisions, and detecting whether it has left the 
area of play. This is also where the cheat keys are found. 'V' will speed the ball up, 'O' will damage all of one
players' Blocks, and 'P' will damage all of the other players' Blocks. 

The Level class is without a doubt the most convoluted class of all of these so far. First the class pulls in the 
options for level design from files and consolidates them into a 4-D array. It also instantiates all of each team's 
bouncers and the ball. Depending on what level number it has passed it adds all the proper objects to the group and 
returns. The level also manages the steps of all the objects passed to it. It updates the ball location, checks for 
all collisions, and checks if the ball leaves the screen and for end of level conditions. If level number is zero, this
class initializes the opening message and waits for 'B' to be pressed. If the level number is four it displays the 
winner according to which player had more wins in the end.

### Assumptions Made

