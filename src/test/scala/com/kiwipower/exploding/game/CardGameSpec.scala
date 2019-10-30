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

    "discard blank card when blank card is drawn and draw pile is reduced" in {
      val game = new CardGame(player, List(Card()))
      val playerCardsBefore = player.cards
      val drawPileCardsBefore = game.drawPile

      playerCardsBefore should have size (0)
      drawPileCardsBefore should have size (1)

      game.drawCard()

      val playerCardsAfter = player.cards
      playerCardsAfter should have size (0)

      val drawPileCardsAfter = game.drawPile
      drawPileCardsAfter should have size (0)

      game.hasPlayerLost should be(false)
    }

    "add defuse card to players hand when drawn and draw pile is reduced" in {
      val game = new CardGame(player, List(Card(DEFUSE)))
      val playerCardsBefore = player.cards
      val drawPileCardsBefore = game.drawPile

      playerCardsBefore should have size (0)
      drawPileCardsBefore should have size (1)

      game.drawCard()

      val playerCardsAfter = player.cards
      playerCardsAfter should have size (1)

      val drawPileCardsAfter = game.drawPile
      drawPileCardsAfter should have size (0)

      game.hasPlayerLost should be(false)
    }

    "give a player a new card when it is their turn after setup and check when they draw another defuse card" in {
      val player = new Player()

      val game = new CardGame(player, List(Card(DEFUSE), Card(DEFUSE)))
      game.setup()

      player.cards should have size (1)
      player.cards should contain(Card(cardType = DEFUSE))

      game.drawCard()

      player.cards should have size (2)
    }

    "have result of loose when exploded card is drawn and the player has no defuse cards" in {
      val game = new CardGame(player, List(Card(cardType = EXPLOSIVE)))
      game.drawCard()
      game.hasPlayerLost should be(true)
    }

    "discard the players defuse card and put the exploding card back" in {
      val player = new Player()
      player.addCard(Card(DEFUSE))
      val game = new CardGame(player, List(Card(cardType = EXPLOSIVE)))

      game.drawPile should have size (1)

      game.drawCard()

      game.drawPile should have size (1)
      game.hasPlayerLost should be(false)
    }

  }
}
