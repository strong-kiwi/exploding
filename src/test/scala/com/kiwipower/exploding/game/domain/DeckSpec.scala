package com.kiwipower.exploding.game.domain

import com.kiwipower.exploding.game.domain.CardType._
import org.scalatest.{ BeforeAndAfter, Matchers, WordSpecLike }

class DeckSpec extends WordSpecLike with Matchers with BeforeAndAfter {
  var deck: Deck = _

  before {
    deck = new Deck()
  }

  "A deck" must {

    "have 20 cards" in {
      deck.cards should have size (20)
    }

    "have 16 blank cards" in {
      val blankCards = deck.cards.filter(c => c.cardType == BLANK)
      blankCards should have size (16)
    }

    "have 1 explosive card" in {
      val explodingCards = deck.cards.filter(c => c.cardType == EXPLOSIVE)
      explodingCards should have size (1)
    }

    "have 3 defuse cards" in {
      val blankCards = deck.cards.filter(c => c.cardType == DEFUSE)
      blankCards should have size (3)
    }

  }
}