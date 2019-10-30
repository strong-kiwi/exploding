package com.kiwipower.exploding.game

import com.kiwipower.exploding.game.domain.CardType._
import com.kiwipower.exploding.game.domain.{ Card, Deck, Player }
import com.kiwipower.exploding.game.logic.CardShuffleLogic

class CardGame(cardPlayer: Player, cards: List[Card]) extends CardShuffleLogic {
  var drawPile: List[Card] = cards
  var lastDrawnCard: Card = _
  var player: Player = cardPlayer

  def setup(): Unit = {
    val defuseCard = takeOnCardFromDrawPile(DEFUSE)
    player.addCard(defuseCard)
    drawPile = shuffle(drawPile)
  }

  def takeOnCardFromDrawPile(cardType: CardType): Card = {
    val cardTypesSought = drawPile.filter(c => c.cardType == cardType)
    val cardSought = cardTypesSought.head
    drawPile = drawPile.filter(c => c.cardType != cardType) ++ cardTypesSought.tail
    cardSought
  }

  def draw(): Card = {
    lastDrawnCard = drawPile.head
    drawPile = drawPile.tail
    lastDrawnCard
  }

  def hasPlayerLost: Boolean = lastDrawnCard.cardType == EXPLOSIVE
}

object CardGame {
  def apply(player: Player, cardDeck: Deck): CardGame = {
    new CardGame(player, cardDeck.cards)
  }
}