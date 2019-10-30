package com.kiwipower.exploding.game.domain

case class Card(explosive: Boolean = false) {
  override def toString(): String = if (explosive) "EXPLOSIVE" else "BLANK"
}