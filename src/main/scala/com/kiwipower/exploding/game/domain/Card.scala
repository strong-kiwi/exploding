package com.kiwipower.exploding.game.domain

import com.kiwipower.exploding.game.domain.CardType.CardType

case class Card(cardType: CardType = CardType.BLANK) {
  override def toString(): String = cardType.toString
}