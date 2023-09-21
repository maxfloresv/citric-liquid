package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

abstract class NeutralPanel extends Panel {
  val characters: ArrayBuffer[PlayerCharacter]

  def addCharacter(player: PlayerCharacter): Unit

  def removeCharacter(player: PlayerCharacter): Unit

  val nextPanels: ArrayBuffer[Panel]
}
