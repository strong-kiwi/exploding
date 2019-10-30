package com.kiwipower.exploding.game.domain

import org.scalatest.{ Matchers, WordSpecLike }

class CardSpec extends WordSpecLike with Matchers {

  "A card" must {

    "be specified as blank by default" in {
      val card = Card()
      card.exploding should be(false)
    }

    "be specified as exploding" in {
      val card = Card(exploding = true)
      card.exploding should be(true)
    }

  }
}
