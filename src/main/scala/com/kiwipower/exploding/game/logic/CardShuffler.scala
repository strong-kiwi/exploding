package com.kiwipower.exploding.game.logic

import com.kiwipower.exploding.game.domain.Card

class CardShuffler(indexShuffler: IndexShuffler) {

  def shuffle(cards: List[Card]): List[Card] = {
    if (!areThereCardDifferences(cards)) return cards

    val cardsWithIndex = cards.zipWithIndex
    val randomPositions = indexShuffler.shuffleIndexes(cardsWithIndex.map(_._2))
    val shuffledCards = for (i <- randomPositions) yield cardsWithIndex(i)._1

    //reshuffle the cards if the shuffled result is the same
    if (shuffledCards == cards) shuffle(cards) else shuffledCards
  }

  def areThereCardDifferences(cards: List[Card]): Boolean = cards.distinctBy(_.cardType).size > 1
}
