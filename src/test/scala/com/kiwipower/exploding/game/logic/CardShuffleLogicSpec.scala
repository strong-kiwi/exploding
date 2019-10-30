package com.kiwipower.exploding.game.logic

import com.kiwipower.exploding.game.domain.Card
import com.kiwipower.exploding.game.domain.CardType._
import org.scalatest.{ Matchers, WordSpecLike }

class CardShuffleLogicSpec extends WordSpecLike with Matchers with CardShuffleLogic {

  "card shuffle logic" must {

    "shuffle cards" in {
      val cardsBefore = List(Card(cardType = DEFUSE), Card(cardType = EXPLOSIVE))
      val cardsAfter = shuffle(cardsBefore)

      cardsAfter should not equal (cardsBefore)
      cardsAfter should have size (2)
    }

  }
}
