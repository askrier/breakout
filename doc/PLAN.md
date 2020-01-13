# Game Plan
## NAME
Andrew Krier

### Breakout Variant

Devilish was interesting for how it managed two paddles simultaneously, one floating around the screen and the other anchored to the base. This could be interesting to integrate in a two player game where each player has to manage two paddles.

### General Level Descriptions

Each level consists of two sides that start symmetric. There is a space in the middle where no blocks will spawn, then an area on each side where blocks can spawn. They will form in the same shape on both sides to ensure an equal chance for both players. Each player will have two paddles, one anchored to the baseline within the blocks, and the other will be free floating among the empty space as well as the blocks. The free floating padde will not be able to cross the middle barrier. The blocks act as "lives" so that when a player has zero remaining blocks on their side they lose that match.

![breakout diagram](doc/Breakout_Game_Diagram.png "Breakout Game Diagram")

### Bricks Ideas

Bricks more towards the middle could have lighter durability than the ones closer to the baselines, and the bricks could be different shapes to create unreliable bouncing conditions.

### Power Up Ideas

Power ups would be accessed via the other player's blocks. Power ups could include, a faster speed that your paddles move, a three-ball block, and a reinforcement power up where all the blocks that had been damaged but not removed recover to full health.

### Cheat Key Ideas

A potential cheat key would be to allow the free floating paddle to cross the middle barrier into enemy territory. 

### Something Extra

Something extra would be to implement penalties when the ball crosses the baseline on your side and goes off the screen, this could be assessed in either temporary slowed movement or random loss of one durability on an arbitrary number of blocks.
