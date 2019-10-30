package com.kiwipower.exploding.game.domain

import com.kiwipower.exploding.game.domain.CardType._
import org.scalatest.{ BeforeAndAfter, Matchers, WordSpecLike }

class DeckSpec extends WordSpecLike with Matchers with BeforeAndAfter {
  var deck: Deck = _

  before {
    deck = new Deck()
  }

  "A deck" must {

    "have 17 cards" in {
      deck.cards should have size (17)
    }

    "have 16 blank cards" in {
      val blankCards = deck.cards.filter(c => c.cardType != EXPLOSIVE)
      blankCards should have size (16)
    }

    "have 1 explosive card" in {
      val explodingCards = deck.cards.filter(c => c.cardType == EXPLOSIVE)
      explodingCards should have size (1)
    }

    "be shuffled" in {
      val cardsBefore = deck.cards
      cardsBefore should have size (17)

      deck.shuffle()

      val cardsAfter = deck.cards
      cardsAfter should have size (17)
      cardsBefore should not equal (cardsAfter)
    }

  }
}