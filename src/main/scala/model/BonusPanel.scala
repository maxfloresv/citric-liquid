package cl.uchile.dcc.citric
package model

import scala.collection.mutable.ArrayBuffer

/** Represents a specific single cell on a board, known as a Panel.
 *
 * This panel give stars to the player when they fall
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class BonusPanel extends Panel {
  val characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  def addCharacter(player: PlayerCharacter): Unit = {
    val listSize: Int = characters.size - 1
    for (i <- 0 to listSize) {
      if (characters(i) == player)
        return
    }
    // We only add players if they not exist.
    characters += player
  }
  def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }

  /** Update the stars of a character given that they fell into a
   * Bonus Panel.
   *
   * @param character The character involved
   */
  def giveStars(character: PlayerCharacter): Unit = {
    val roll: Int = character.rollDice()
    character.stars += math.min(roll * character.norma, roll * 3)
  }
}
