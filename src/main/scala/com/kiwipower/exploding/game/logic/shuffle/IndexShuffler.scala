package com.kiwipower.exploding.game.logic.shuffle

import scala.util.Random

class IndexShuffler {

  def shuffleIndexes(indexes: List[Int]): List[Int] = {
    Random.shuffle(indexes)
  }

}
