package com.kiwipower.exploding.game.domain

import com.kiwipower.exploding.game.domain.CardType._

class Deck {
  val blankCards: List[Card] = List.fill(16)(Card())
  val explodingCards: List[Card] = List(Card(cardType = EXPLOSIVE))
  val defuseCards: List[Card] = List.fill(3)(Card(cardType = DEFUSE))

  var cards: List[Card] = explodingCards ++ blankCards ++ defuseCards
}
