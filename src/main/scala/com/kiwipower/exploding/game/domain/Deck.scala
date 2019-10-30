package com.kiwipower.exploding.game.domain

import scala.util.Random

class Deck {
  val blankCards: List[Card] = List.fill(16)(Card())
  val explodingCards: List[Card] = List(Card(explosive = true))
  var cards: List[Card] = explodingCards ++ blankCards

  def shuffle() {
    val explodingCard = cards.head
    val blankCards = cards.tail

    val randomPosition = Random.between(1, 17)
    val (before, after) = blankCards.splitAt(randomPosition)

    cards = before ++ List(explodingCard) ++ after
  }

}
