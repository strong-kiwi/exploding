package com.kiwipower.exploding.game

import com.kiwipower.exploding.game.domain.Card
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

    "have result of no effect when blank card is drawn" in {
      val game = new CardGame(List(Card()))
      game.draw()
      game.hasPlayerLost should be(false)
    }

    "have result of loose when exploded card is drawn" in {
      val game = new CardGame(List(Card(exploding = true)))
      game.draw()
      game.hasPlayerLost should be(true)
    }

  }
}
