package com.kiwipower.exploding.game.domain

class Player {
  var cards: List[Card] = List[Card]()

  def addCard(card: Card) {
    cards = card :: cards
  }
}
