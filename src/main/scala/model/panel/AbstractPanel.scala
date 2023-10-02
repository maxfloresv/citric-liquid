package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
 *
 * It has implementations and initial values that Panels share.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
abstract class AbstractPanel extends Panel {
  /** Initially, we don't have neither characters nor nextPanels. */
  protected val characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  protected var nextPanels: ArrayBuffer[Panel] = ArrayBuffer[Panel]()

  protected def addCharacter(player: PlayerCharacter): Unit = {
    val listSize: Int = characters.size - 1
    for (i <- 0 to listSize) {
      if (characters(i) == player)
        return
    }
    // We only add players if they don't exist.
    characters += player
  }

  protected def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }
}
