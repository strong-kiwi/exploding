package com.kiwipower.exploding.game.domain

import org.scalatest.{ Matchers, WordSpecLike }

class PlayerSpec extends WordSpecLike with Matchers {

  "A player" must {

    "have no cards by default" in {
      val player = new Player()
      player.cards should have size (0)
    }

    "be able to accept cards" in {
      val player = new Player()
      player.addCard(Card())
      player.cards should have size (1)
    }

  }
}
