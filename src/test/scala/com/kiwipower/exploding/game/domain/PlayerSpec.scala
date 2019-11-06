package com.kiwipower.exploding.game.domain

import com.kiwipower.exploding.game.domain.CardType.DEFUSE
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

    "indicate if they have defuse card when in their hand" in {
      val player = new Player()
      player.addCard(Card(DEFUSE))
      player.hasDefuseCard should be(true)
    }

    "indicate that they do not have defuse card in their hand" in {
      val player = new Player()
      player.addCard(Card())
      player.hasDefuseCard should be(false)
    }

    "remove one defuse card" in {
      val player = new Player()
      player.addCard(Card(DEFUSE))
      player.cards should have size (1)

      player.removeADefuseCard()

      player.cards should have size (0)
    }

    "not remove any defuse card when none are available" in {
      val player = new Player()
      player.addCard(Card())
      player.cards should have size (1)

      player.removeADefuseCard()

      player.cards should have size (1)
    }

  }
}
