package com.kiwipower.exploding.game.domain

import CardType._

class Player {
  var cards: List[Card] = List[Card]()

  def addCard(card: Card) {
    cards = card :: cards
  }

  def hasDefuseCard: Boolean = {
    cards.exists(c => c.cardType == DEFUSE)
  }

  def removeADefuseCard(): Unit = {
    if (!hasDefuseCard) return

    val index = cards.indexWhere(c => c.cardType == DEFUSE)
    val (before, after) = cards.splitAt(index)
    cards = before ++ after.tail
  }

}
