# Author 
Code is written by Eugene Le Roux see: https://www.linkedin.com/in/eugeneleroux

If you are interested in another code project of mine (Java & Scala Multi Microservices + Persistence + Queue + All composed together with Docker), see:
https://github.com/sunday-take-away 

## Iterations
This is for iteration 2, see: [Iteration 2 Specifications](docs/specification.md).
This iteration 2 code will remain on the master branch.

For the previous iteration 1, see branch "**iteration1**".

For both iterations, if you follow the commits - you will see TDD testing and ability to refactor code.
Naturally, you need to look at the commits relevant to branches.

# Exploding Card Game
Card game where user has option to draw from a set of cards.
If the card drawn is an explosive card the player looses.
Player continue to play or quit while they are ahead.

Player is given one defuse card, if an explosive card is encountered - player will be saved.

## How to play the game
You will need to do this using a command line terminal.

You have 2 options, use sbt to run the card game or package the card game.

1. `sbt run`
2. `java -jar kiwipower-exploding-assembly-0.0.1-SNAPSHOT.jar` (when code is assembled into self contained jar)

For both of the above choices, it should be clear what to do from the options provided.

## Assumptions
* Draw pile has cards already arranged face down.
* "Face down" means card is drawn from the top.
* Defuse cards will be added to the pile initially (as per spec) *"Add three Defuse cards to the deck, making a total of 20"*.
* Taking out 2x defuse cards and putting them back, is not required due to reshuffling after initial setup draw & shuffle.
* No discarded pile is used (as it is not needed)

## Developers
Project requires SBT (prerequisite)

### Build status
This project uses Travis CI to build and test this code.

[![Build Status](https://travis-ci.org/power-of-kiwi/exploding.svg?branch=master)](https://travis-ci.org/power-of-kiwi/exploding)

Click on the icon above to see the build status.

### Building
* `sbt clean compile` will compile the code
* `sbt clean test` will run the various tests
* `sbt clean assembly` will assemble (package) the code into a jar, under target/scala-2.13 directory

