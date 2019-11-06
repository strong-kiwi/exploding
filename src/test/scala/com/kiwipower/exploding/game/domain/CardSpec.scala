package com.kiwipower.exploding.game.domain

import com.kiwipower.exploding.game.domain.CardType._
import org.scalatest.{ Matchers, WordSpecLike }

class CardSpec extends WordSpecLike with Matchers {

  "A card" must {

    "be specified as blank by default" in {
      val card = Card()
      card.cardType should be(BLANK)
    }

    "be specified as blank" in {
      val card = Card(cardType = BLANK)
      card.cardType should be(BLANK)
    }

    "be specified as explosive" in {
      val card = Card(cardType = EXPLOSIVE)
      card.cardType should be(EXPLOSIVE)
    }

    "be specified as defuse" in {
      val card = Card(cardType = DEFUSE)
      card.cardType should be(DEFUSE)
    }

    "to string of default blank card should be BLANK" in {
      val card = Card()
      card.toString() should be("BLANK")
    }

    "to string of blank card should be BLANK" in {
      val card = Card(cardType = BLANK)
      card.toString() should be("BLANK")
    }

    "to string of explosive card should be EXPLOSIVE" in {
      val card = Card(cardType = EXPLOSIVE)
      card.toString() should be("EXPLOSIVE")
    }

    "to string of defuse card should be DEFUSE" in {
      val card = Card(cardType = DEFUSE)
      card.toString() should be("DEFUSE")
    }

  }
}
