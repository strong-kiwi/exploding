package com.kiwipower.exploding.game.logic

import com.kiwipower.exploding.game.domain.Card
import com.kiwipower.exploding.game.domain.CardType._
import org.scalamock.scalatest.MockFactory
import org.scalatest.{ Matchers, WordSpecLike }

class CardShufflerSpec extends WordSpecLike with Matchers with MockFactory {

  "card shuffler" must {

    "shuffle cards once" in {
      val mockedIndexShuffler = mock[IndexShuffler]

      (mockedIndexShuffler.shuffleIndexes _).expects(List(0, 1)).returning(List(1, 0)).once()

      val cardShuffler = new CardShuffler(mockedIndexShuffler)

      val cardsBefore = List(Card(cardType = DEFUSE), Card(cardType = EXPLOSIVE))
      val cardsAfter = cardShuffler.shuffle(cardsBefore)

      cardsAfter should not equal (cardsBefore)
      cardsAfter should have size (2)
    }

    "shuffle cards again when shuffle result is the same" in {
      val mockedIndexShuffler = mock[IndexShuffler]

      (mockedIndexShuffler.shuffleIndexes _).expects(List(0, 1)).returning(List(0, 1)).once()
      (mockedIndexShuffler.shuffleIndexes _).expects(List(0, 1)).returning(List(1, 0)).once()

      val cardShuffler = new CardShuffler(mockedIndexShuffler)

      val cardsBefore = List(Card(cardType = DEFUSE), Card(cardType = EXPLOSIVE))
      val cardsAfter = cardShuffler.shuffle(cardsBefore)

      cardsAfter should not equal (cardsBefore)
      cardsAfter should have size (2)
    }

    "not shuffle cards when they do not have different card types" in {
      val cardShuffler = new CardShuffler(new IndexShuffler)

      val cardsBefore = List(Card(), Card())
      val cardsAfter = cardShuffler.shuffle(cardsBefore)

      cardsAfter should equal(cardsBefore)
      cardsAfter should have size (2)
    }

    "not shuffle cards when there is only one card" in {
      val cardShuffler = new CardShuffler(new IndexShuffler)

      val cardsBefore = List(Card())
      val cardsAfter = cardShuffler.shuffle(cardsBefore)

      cardsAfter should equal(cardsBefore)
      cardsAfter should have size (1)
    }

  }
}
