package com.kiwipower.exploding.game.domain

import scala.util.Random

class Deck {
  var cards = List[Card](Card(explosive = true), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card(), Card())

  def shuffle() {
    val explodingCard = cards.head
    val blankCards = cards.tail

    val randomPosition = Random.between(1, 17)
    val (before, after) = blankCards.splitAt(randomPosition)

    cards = before ++ List(explodingCard) ++ after
  }

}
