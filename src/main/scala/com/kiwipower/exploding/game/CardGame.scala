package com.kiwipower.exploding.game

import com.kiwipower.exploding.game.domain.CardType._
import com.kiwipower.exploding.game.domain.{ Card, Deck }

class CardGame(cards: List[Card]) {
  var drawPile: List[Card] = cards
  var lastDrawnCard: Card = _

  def draw(): Card = {
    lastDrawnCard = drawPile.head
    drawPile = drawPile.tail
    lastDrawnCard
  }

  def hasPlayerLost: Boolean = lastDrawnCard.cardType == EXPLOSIVE
}

object CardGame {
  def apply(): CardGame = {
    val cardDeck = new Deck()
    cardDeck.shuffle()

    new CardGame(cardDeck.cards)
  }
}