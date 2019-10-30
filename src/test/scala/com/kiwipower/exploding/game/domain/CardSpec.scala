package com.kiwipower.exploding.game.domain

import org.scalatest.{ Matchers, WordSpecLike }

class CardSpec extends WordSpecLike with Matchers {

  "A card" must {

    "be specified as blank by default" in {
      val card = Card()
      card.explosive should be(false)
    }

    "be specified as explosive" in {
      val card = Card(explosive = true)
      card.explosive should be(true)
    }

    "to string of blank card should be BLANK" in {
      val card = Card()
      card.toString() should be("BLANK")
    }

    "to string of explosive card should be EXPLOSIVE" in {
      val card = Card(explosive = true)
      card.toString() should be("EXPLOSIVE")
    }

  }
}
