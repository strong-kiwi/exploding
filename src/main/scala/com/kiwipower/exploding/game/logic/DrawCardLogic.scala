package com.kiwipower.exploding.game.logic

import com.kiwipower.exploding.game.domain.CardType.{ BLANK, DEFUSE, EXPLOSIVE }
import com.kiwipower.exploding.game.domain.{ Card, Player }
import com.kiwipower.exploding.game.exception.OutOfCardsException

trait DrawCardLogic {

  def getDrawPile: List[Card]
  def setDrawPile(updatedDrawPile: List[Card])

  def getLastDrawnCard: Card
  def setLastDrawnCard(card: Card)

  def setPlayerLostState(state: Boolean)

  def getPlayer: Player

  def drawCard(): Card = {
    if (getDrawPile.isEmpty)
      throw new OutOfCardsException()

    setLastDrawnCard(getDrawPile.head)
    setDrawPile(getDrawPile.tail)

    getLastDrawnCard.cardType match {
      case BLANK =>
        setPlayerLostState(false)
      case DEFUSE =>
        getPlayer.addCard(getLastDrawnCard)
        setPlayerLostState(false)
      case EXPLOSIVE =>
        if (getPlayer.hasDefuseCard) {
          getPlayer.removeADefuseCard()
          setDrawPile(shuffle(getLastDrawnCard :: getDrawPile))
          setPlayerLostState(false)
        } else {
          setPlayerLostState(true)
        }
    }

    getLastDrawnCard
  }

  def shuffle(cards: List[Card]): List[Card]
}

