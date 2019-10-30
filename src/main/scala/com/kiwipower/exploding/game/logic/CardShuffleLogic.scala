package com.kiwipower.exploding.game.logic

import com.kiwipower.exploding.game.domain.Card

import scala.util.Random

trait CardShuffleLogic {

  def shuffle(cards: List[Card]): List[Card] = {
    val cardsWithIndex = cards.zipWithIndex
    val randomPositions = Random.shuffle(cardsWithIndex.map(_._2))
    val shuffledCards = for (i <- randomPositions) yield cardsWithIndex(i)._1
    shuffledCards
  }

}
