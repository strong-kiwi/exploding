package com.kiwipower.exploding.game

import com.kiwipower.exploding.game.domain.CardType._
import com.kiwipower.exploding.game.domain.{ Card, Deck, Player }
import org.scalatest.{ BeforeAndAfter, Matchers, WordSpecLike }

class CardGameSpec extends WordSpecLike with Matchers with BeforeAndAfter {
  var player: Player = _
  var cardDeck: Deck = _

  before {
    player = new Player()
    cardDeck = new Deck()
  }

  "A card game" must {

    "be setup such that player gets 1 defuse card initially" in {
      val game = new CardGame(player, cardDeck.cards)
      game.setup()

      player.cards should have size (1)
      player.cards should contain(Card(cardType = DEFUSE))

      game.drawPile should have size (19)
    }

    "have cards shuffled after setup and have cards ready to draw" in {
      val game = CardGame(player, cardDeck)

      game.setup()

      game.drawPile should not equal (cardDeck.cards)
    }

    "have the ability to shuffle cards" in {
      val game = new CardGame(player, cardDeck.cards)
      game.drawPile should have size (20)

      val shuffledCards = game.shuffle(game.drawPile)

      shuffledCards should have size (20)
      shuffledCards should not equal (game.drawPile)
    }

    "draw one card from the top of the draw pile" in {
      val game = new CardGame(player, cardDeck.cards)
      val card = game.drawCard()
      card should not be (null)
      game.drawPile should have size (19)
    }

    "draw pile should be depleted after all draws" in {
      val game = new CardGame(player, cardDeck.cards)
      val drawPileCount = game.drawPile.size
      for (i <- 1 to drawPileCount) game.drawCard()
      game.drawPile should have size (0)
    }

    "have result of no effect when blank card is drawn" in {
      val game = new CardGame(player, List(Card()))
      game.drawCard()
      game.hasPlayerLost should be(false)
    }

    "have result of loose when explosive card is drawn" in {
      val game = new CardGame(player, List(Card(cardType = EXPLOSIVE)))
      game.drawCard()
      game.hasPlayerLost should be(true)
    }

  }
}
