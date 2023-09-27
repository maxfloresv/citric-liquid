package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

/** Represents a specific single cell on a board, known as BonusPanel.
 *
 * This panel give stars to the player when they fall.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class BonusPanel extends abstractPanel {
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
