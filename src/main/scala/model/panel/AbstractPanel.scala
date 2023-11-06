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
  protected[model] val _characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer()
  protected[model] val _nextPanels: ArrayBuffer[Panel] = ArrayBuffer()

  /** We return a copy of the main array for security reasons. Arrays are mutable */
  protected[model] def characters: ArrayBuffer[PlayerCharacter] = {
    val copyCharacters: ArrayBuffer[PlayerCharacter] = _characters.clone()
    copyCharacters
  }

  protected[model] def nextPanels: ArrayBuffer[Panel] = {
    val copyNextPanels: ArrayBuffer[Panel] = _nextPanels.clone()
    copyNextPanels
  }

  protected[model] def addCharacter(player: PlayerCharacter): Unit = {
    val listSize: Int = _characters.size
    for (i <- 0 until listSize) {
      if (_characters(i).name == player.name)
        return
    }
    // We only add players if they don't exist.
    _characters += player
  }

  protected[model] def removeCharacter(player: PlayerCharacter): Unit = {
    _characters -= player
  }

  protected[model] def addNextPanel(panel: Panel): Unit = {
    _nextPanels += panel
  }

  protected[model] def removeNextPanel(panel: Panel): Unit = {
    _nextPanels -= panel
  }
}
