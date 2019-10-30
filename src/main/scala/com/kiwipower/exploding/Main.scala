package com.kiwipower.exploding

import com.kiwipower.exploding.game.CardGame

object Main extends App {
  val game = CardGame()

  def displayGameOptions(): Unit = {
    val gameOptions = "Exploding card game!\n" +
      "Options: d - draw card, q - quit\n" +
      "enter your choice:"
    println(gameOptions)
  }

  def processUserInput(input: Char) {
    input match {
      case 'd' => takeActionAndSeeResult()
      case _ => println("Try again (options are 'd' or 'q')")
    }
  }

  def takeActionAndSeeResult() {
    game.draw()
    println("You drew card:'%s'".format(game.lastDrawnCard))
    if (game.hasPlayerLost) {
      println("***** Game Over - you loose! *******")
      sys.exit(0)
    }
  }

  displayGameOptions()

  Iterator.continually(io.StdIn.readChar())
    .takeWhile(_ != 'q')
    .foreach(i => processUserInput(i))
}
