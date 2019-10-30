package com.kiwipower.exploding.game

import org.scalatest.{ Matchers, WordSpecLike }

class CardGameSpec extends WordSpecLike with Matchers {

  "A card game" must {

    "have cards shuffled and have cards ready to draw" in {
      val game = CardGame()
      game.drawPile should have size (17)
    }

    "draw one card from the top of the draw pile" in {
      val game = CardGame()
      val card = game.draw()
      card should not be (null)
      game.drawPile should have size (16)
    }

    "draw pile should be depleted after all draws" in {
      val game = CardGame()
      for (i <- 1 to 17) game.draw()
      game.drawPile should have size (0)
    }
  }
}
