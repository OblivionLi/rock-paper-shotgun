# rock-paper-shotgun
---
Play the classic game rock-paper-scissors but on steroids against a computer player.
---
* A player can create its own gamemode:
  * If the player provides an empty list of gestures for the gamemode; the classic gamemode will be provided (rock-paper-scissors)
  * Otherwise the player can choose any gestures of N size from a list of 14 gestures i.e. `[ROCK, FIRE, SCISSORS, SPONGE, PAPER, AIR, WATER]`
* The name of the player and score will be saved in a file
  * For a win - the player will win 100 points
  * For a draw - the player will win 50 points
  * For a loss - the player will win nothing
---
List of gestures: 
---
###### `[ROCK, FIRE, SCISSORS, SNAKE, HUMAN, TREE, WOLF, SPONGE, PAPER, AIR, WATER, DRAGON, DEVIL, LIGHTNING, GUN]`
##### Example 1:
---
###### If user chooses `ROCK`
* `ROCK` beats `FIRE`
* `ROCK` beats `SCISSORS`
* `ROCK` beats `SNAKE`
* `ROCK` beats `HUMAN`
* `ROCK` beats `TREE`
* `ROCK` beats `WOLF`
* `ROCK` beats `SPONGE`
---
* `ROCK` loses `PAPER`
* `ROCK` loses `AIR`
* `ROCK` loses `WATER`
* `ROCK` loses `DRAGON`
* `ROCK` loses `DEVIL`
* `ROCK` loses `LIGHTNING`
* `ROCK` loses `GUN`
---
##### Example 2:
---
###### If user chooses `DRAGON`
* `DRAGON` beats `DEVIL`
* `DRAGON` beats `LIGHTNING`
* `DRAGON` beats `GUN`
* `DRAGON` beats `ROCK`
* `DRAGON` beats `FIRE`
* `DRAGON` beats `SCISSORS`
* `DRAGON` beats `SNAKE`
---
* `DRAGON` loses `HUMAN`
* `DRAGON` loses `TREE`
* `DRAGON` loses `WOLF`
* `DRAGON` loses `SPONGE`
* `DRAGON` loses `PAPER`
* `DRAGON` loses `AIR`
* `DRAGON` loses `WATER`
---
### The algorithms determins if a gesture wins or loses against another gesture if we divide the whole list in half starting from the gesture itself; the second half will always win against the chosen gesture while in the first half the chosen gesture will win or loss based on the index location
