# exploding

Unattended test for candidates.

Please complete iterations 1 and 2.

Focus on making your code clear and testable.

## Requirements

* Iterations 1 and 2 below describe a card game. Implement in Scala a computer version to allow a user to play the game. 
* Cover the full scope of both iterations.
* Include a README with any assumptions made and instructions to play (eg _Run the game with `sbt run`_).
* An unsophisticated command-line UI will suffice, eg entering 'd' for drawing a card, etc.
* Break down the code into small focused modules.
* Fully test the application, using unit and integration tests as appropriate.
* The implementation should be production quality, reflecting what you would like to see deployed in the real world.



### Iteration 1: Basic roulette ruse

* There is one player and 17 cards. 
* One of the cards is explosive and the rest are blank.
* All the cards are shuffled and arranged face down in a draw pile.
* The player draws cards one after the other. 
* If the card is blank, it has no effect, and can be discarded. 
* If the card is explosive, the player loses.


### Iteration 2: Defuse cards

Enhance the game:

* Add three _Defuse_ cards to the deck, making a total of 20.
* Game set up:
  1. Give one defuse card to the player.
  2. Put the remaining two defuse cards with the rest in the draw pile, shuffle and arrange face down.
* The player's turn consists of two steps:
   1. Draw one card
   2. There are four alternatives:
      * Blank card: the turn finishes.
      * Defuse card: add the defuse card to the player's hand and the turn finishes.
      * Explosive card, if the player has a defuse card: 
        1. Discard the defuse card onto the discard pile.
        2. Return the explosive card to the draw pile.
        3. Re-shuffle the draw pile.
      * Explosive card, if the player does not have a defuse card: The player loses.


## Extension ideas

As part of a face to face interview, we will pair with you to discuss your submission and build up on it. We will discuss the extension examples below, or may decide to work on something else that we find interesting in your code. _These are just examples in case you would like to think about them. They are not part of the unattended submission._

* Allowing the user to configure the number of cards of each type in the deck
* Allowing the user to configure the number of players
* Including _See the future_ cards that allow the player to reveal the next three cards and _Skip_ cards, which allow the player to skip one card from the drawing pile.
