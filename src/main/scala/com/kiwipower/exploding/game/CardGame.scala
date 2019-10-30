package com.kiwipower.exploding.game

import com.kiwipower.exploding.game.domain.CardType._
import com.kiwipower.exploding.game.domain.{ Card, Deck, Player }
import com.kiwipower.exploding.game.logic.DrawCardLogic
import com.kiwipower.exploding.game.logic.shuffle.{ CardShuffler, IndexShuffler }

class CardGame(cardPlayer: Player, cards: List[Card]) extends DrawCardLogic {
  val cardShuffler = new CardShuffler(new IndexShuffler)
  var drawPile: List[Card] = cards
  var lastDrawnCard: Card = _
  var player: Player = cardPlayer
  var playerLost: Boolean = _

  def setup(): Unit = {
    val defuseCard = takeOnCardFromDrawPile(DEFUSE)
    player.addCard(defuseCard)
    drawPile = shuffle(drawPile)
  }

  def shuffle(cards: List[Card]): List[Card] = {
    cardShuffler.shuffle(cards)
  }

  def takeOnCardFromDrawPile(cardType: CardType): Card = {
    val cardTypesSought = drawPile.filter(c => c.cardType == cardType)
    val cardSought = cardTypesSought.head
    drawPile = drawPile.filter(c => c.cardType != cardType) ++ cardTypesSought.tail
    cardSought
  }

  def hasPlayerLost: Boolean = playerLost

  override def getDrawPile: List[Card] = drawPile

  override def setDrawPile(updatedDrawPile: List[Card]) { drawPile = updatedDrawPile }

  override def getLastDrawnCard: Card = lastDrawnCard

  override def setLastDrawnCard(card: Card) { lastDrawnCard = card }

  override def setPlayerLostState(state: Boolean) { playerLost = state }

  override def getPlayer: Player = player
}

object CardGame {
  def apply(player: Player, cardDeck: Deck): CardGame = {
    new CardGame(player, cardDeck.cards)
  }
}