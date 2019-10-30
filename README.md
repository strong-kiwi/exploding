# exploding
Exploding card game.

Card game where user has option to draw from a set of cards.
If the card drawn is an explosive card the player looses.
Player continue to play or quit while they are ahead.

This is for iteration 2, see: [Iteration 2 Specifications](docs/specification.md).
This code will be on the master branch.

## How to play the game
You will need to do this using a command line terminal.

You have 2 options, use sbt to run the card game or package the card game.

1. `sbt run`
2. `java -jar kiwipower-exploding-assembly-0.0.1-SNAPSHOT.jar` (when code is assembled into self contained jar)

For both of the above choices, it should be clear what to do from the options provided.

## Assumptions
* draw pile has cards already arranged face down
* face down means card is drawn from the top

## Developers
Project depends on SBT (prerequisite)

### Build status
This project uses Travis CI to build and test this code.

[![Build Status](https://travis-ci.org/power-of-kiwi/exploding.svg?branch=master)](https://travis-ci.org/power-of-kiwi/exploding)

Click on the icon above to see the build status.

### Building
* `sbt clean compile` will compile the code
* `sbt clean test` will run the various tests
* `sbt clean assembly` will assemble (package) the code into a jar, under target/scala-2.13 directory

